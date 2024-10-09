package modules.tsuserservice.user.service;
import modules.tscommon.edu.fudan.common.util.Response;
import modules.tsuserservice.user.dto.UserDto;
import org.springframework.http.HttpHeaders;
/**
 *
 * @author fdse
 */
public interface UserService {
    Response saveUser(UserDto user, HttpHeaders headers);

    Response getAllUsers(HttpHeaders headers);

    Response findByUserName(String userName, HttpHeaders headers);

    Response findByUserId(String userId, HttpHeaders headers);

    Response deleteUser(String userId, HttpHeaders headers);

    Response updateUser(UserDto user, HttpHeaders headers);
}