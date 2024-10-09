// package auth.service.impl;
// import auth.constant.InfoConstant;
// import auth.dto.BasicAuthDto;
// import auth.dto.TokenDto;
// import auth.entity.User;
// import auth.exception.UserOperationException;
// import auth.repository.UserRepository;
// import auth.security.jwt.JWTProvider;
// import auth.service.TokenService;
// import edu.fudan.common.util.Response;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.cloud.client.ServiceInstance;
// import org.springframework.cloud.client.discovery.DiscoveryClient;
// import org.springframework.http.HttpEntity;
// import org.springframework.http.HttpHeaders;
// import org.springframework.http.HttpMethod;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.AuthenticationException;
// import org.springframework.stereotype.Service;
// import org.springframework.util.StringUtils;
// import org.springframework.web.client.RestTemplate;
// import java.text.MessageFormat;
// import java.util.List;
// 
// * @author fdse
// 
// @Service
// public class TokenServiceImpl implements TokenService {
// private static final Logger LOGGER = LoggerFactory.getLogger(TokenServiceImpl.class);
// @Autowired
// private JWTProvider jwtProvider;
// @Autowired
// private UserRepository userRepository;
// @Autowired
// private AuthenticationManager authenticationManager;
// @Autowired
// private RestTemplate restTemplate;
// @Autowired
// private DiscoveryClient discoveryClient;
// private String getServiceUrl(String serviceName) {
// return "http://" + serviceName;
// }
// @Override
// public Response getToken(BasicAuthDto dto, HttpHeaders headers) throws UserOperationException {
// String username = dto.getUsername();
// String password = dto.getPassword();
// String verifyCode = dto.getVerificationCode();
// LOGGER.info("LOGIN USER :" + username + " __ " + password + " __ " + verifyCode);
// String verification_code_service_url = getServiceUrl("ts-verification-code-service");
// if (!StringUtils.isEmpty(verifyCode)) {
// HttpEntity requestEntity = new HttpEntity(headers);
// ResponseEntity<Boolean> re = restTemplate.exchange(
// verification_code_service_url + "/api/v1/verifycode/verify/" + verifyCode,
// HttpMethod.GET,
// requestEntity,
// Boolean.class);
// boolean id = re.getBody();
// failed code
// if (!id) {
// LOGGER.info("[getToken][Verification failed][userName: {}]", username);
// return new Response<>(0, "Verification failed.", null);
// }
// }
// verify username and password
// UsernamePasswordAuthenticationToken upat = new UsernamePasswordAuthenticationToken(username, password);
// try {
// authenticationManager.authenticate(upat);
// } catch (AuthenticationException e) {
// LOGGER.warn("[getToken][Incorrect username or password][username: {}, password: {}]", username, password);
// return new Response<>(0, "Incorrect username or password.", null);
// }
// User user = userRepository.findByUsername(username)
// .orElseThrow(() -> new UserOperationException(MessageFormat.format(
// InfoConstant.USER_NAME_NOT_FOUND_1, username
// )));
// String token = jwtProvider.createToken(user);
// LOGGER.info("[getToken][success][USER TOKEN: {} USER ID: {}]", token, user.getUserId());
// return new Response<>(1, "login success", new TokenDto(user.getUserId(), username, token));
// }
// }
package modules.tsavatarservice.avatar.service.impl;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Base64;
import nu.pattern.OpenCV;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.objdetect.CascadeClassifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
@Service
public class AvatarService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AvatarService.class);

    private static final String PATH_SAVE = "/tmp/";

    private CascadeClassifier faceDetector;

    static {
        // System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        OpenCV.loadShared();
    }

    public String checkImage(Mat image) throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("haarcascade_frontalface_default.xml");
        // Create a temporary file
        File tempFile = Files.createTempFile("haarcascade_frontalface_default", ".xml").toFile();
        // Copy the resource content to the temporary file
        try (InputStream inputStream = classPathResource.getInputStream();FileOutputStream outputStream = new FileOutputStream(tempFile)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != (-1)) {
                outputStream.write(buffer, 0, bytesRead);
            } 
        }
        // Load the cascade classifier using the temporary file path
        faceDetector = new CascadeClassifier(tempFile.getAbsolutePath());
        // Detect faces
        MatOfRect faceDetections = new MatOfRect();
        faceDetector.detectMultiScale(image, faceDetections);
        // Check if faces are found
        if (faceDetections.toArray().length < 1) {
            AvatarService.LOGGER.info("[AVATAR SERVICE][No human face found]");
            return "no human face found";
        }
        // Return first detected face if one was detected
        if (faceDetections.toArray().length > 0) {
            Rect rect = faceDetections.toArray()[0];
            Mat face = new Mat(image, rect);
            Imgcodecs.imwrite(PATH_SAVE + "img_face.jpg", face);
            MatOfByte buffer = new MatOfByte();
            Imgcodecs.imencode(".jpg", face, buffer);
            byte[] faceBytes = buffer.toArray();
            String base64Str = Base64.getEncoder().encodeToString(faceBytes);
            return base64Str;// Return the first face found as Base64 string

        }
        return "{\"msg\":\"error processing image\"}";
    }
}