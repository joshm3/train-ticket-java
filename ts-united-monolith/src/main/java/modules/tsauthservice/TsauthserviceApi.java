package modules.tsauthservice;
import modules.tsauthservice.auth.controller.AuthController;
import modules.tsauthservice.auth.controller.UserController;
import modules.tsauthservice.auth.dto.AuthDto;
import modules.tscommon.edu.fudan.common.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
@Component
public class TsauthserviceApi {
    @Autowired
    UserController userController;

    @Autowired
    AuthController authController;

    public HttpEntity<Response> postApiV1Auth(AuthDto authDto) {
        return authController.createDefaultUser(authDto);
    }

    public ResponseEntity<Response> deleteApiV1UsersPathvariable(String userId, HttpHeaders headers) {
        return userController.deleteUserById(userId, headers);
    }
}