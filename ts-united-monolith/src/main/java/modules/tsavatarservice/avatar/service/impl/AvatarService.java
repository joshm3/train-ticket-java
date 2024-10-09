package modules.tsavatarservice.avatar.service.impl;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import nu.pattern.OpenCV;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.objdetect.CascadeClassifier;
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