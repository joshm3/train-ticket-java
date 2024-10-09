package modules.tsuserservice;
import modules.tscommon.edu.fudan.common.util.Response;
import modules.tsuserservice.user.controller.UserController;
import modules.tsuserservice.user.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
@Component
public class TsuserserviceApi {
    @Autowired
    UserController userController;

    public ResponseEntity<Response> putApiV1UserserviceUsers(UserDto user, HttpHeaders headers) {
        return userController.updateUser(user, headers);
    }

    public ResponseEntity<Response> getApiV1UserserviceUsers(HttpHeaders headers) {
        return userController.getAllUser(headers);
    }

    public ResponseEntity<Response> postApiV1UserserviceUsersRegister(UserDto userDto, HttpHeaders headers) {
        return userController.registerUser(userDto, headers);
    }

    public ResponseEntity<Response> getApiV1UserserviceUsersIdPathvariable(String userId, HttpHeaders headers) {
        return userController.getUserByUserId(userId, headers);
    }

    public ResponseEntity<Response> deleteApiV1UserserviceUsersPathvariable(String userId, HttpHeaders headers) {
        return userController.deleteUserById(userId, headers);
    }
}