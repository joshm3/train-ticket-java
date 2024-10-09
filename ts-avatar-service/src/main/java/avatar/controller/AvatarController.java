package avatar.controller;

import avatar.service.impl.AvatarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;

import java.util.Base64;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/v1/avatar")
public class AvatarController {

    @Autowired
    private AvatarService avatarService;

    private static final Logger LOGGER = LoggerFactory.getLogger(AvatarController.class);

    @PostMapping
    public ResponseEntity<String> processAvatar(@RequestBody Map<String, String> data) {
        AvatarController.LOGGER.info("[LOGGER CONTROLLER][post mapping]");

        String imageBase64 = data.get("img");

        if (imageBase64 == null || imageBase64.isEmpty()) {
            return new ResponseEntity<>("{\"msg\": \"need img in request body\"}", HttpStatus.BAD_REQUEST);
        }

        try {
            byte[] image_decode = Base64.getDecoder().decode(imageBase64);
            Mat image = Imgcodecs.imdecode(new MatOfByte(image_decode), Imgcodecs.IMREAD_COLOR);
            String result = avatarService.checkImage(image);

            if (result.equals("no human face found")) {
                return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
            }
            
            //result should be a base64_str
            return new ResponseEntity<>(result, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("{\"msg\": \"exception: " + e.getMessage() + "\"}", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}