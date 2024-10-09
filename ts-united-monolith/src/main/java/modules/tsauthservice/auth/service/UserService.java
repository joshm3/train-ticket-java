package modules.tsauthservice.auth.service;
import java.util.List;
import modules.tsauthservice.auth.dto.AuthDto;
import modules.tsauthservice.auth.entity.UserFromtsauthservice;
import modules.tscommon.edu.fudan.common.util.Response;
import org.springframework.http.HttpHeaders;
/**
 *
 * @author fdse
 */
public interface UserService {
    /**
     * save user
     *
     * @param user
    		user
     * @return user
     */
    UserFromtsauthservice saveUser(UserFromtsauthservice user);

    /**
     * get all users
     *
     * @param headers
    		headers
     * @return List<User>
     */
    List<UserFromtsauthservice> getAllUser(HttpHeaders headers);

    /**
     * create default auth user
     *
     * @param dto
    		dto
     * @return user
     */
    UserFromtsauthservice createDefaultAuthUser(AuthDto dto);

    /**
     * delete by user id
     *
     * @param userId
     * 		user id
     * @param headers
    		headers
     * @return Response
     */
    Response deleteByUserId(String userId, HttpHeaders headers);
}