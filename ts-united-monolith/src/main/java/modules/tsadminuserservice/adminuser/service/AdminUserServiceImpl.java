package modules.tsadminuserservice.adminuser.service;
import java.util.List;
import modules.tsadminuserservice.TsadminuserserviceClient;
import modules.tsadminuserservice.adminuser.dto.UserDto;
import modules.tscommon.edu.fudan.common.entity.User;
import modules.tscommon.edu.fudan.common.util.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
/**
 *
 * @author fdse
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {
    @Autowired
    TsadminuserserviceClient tsadminuserserviceClient;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminUserServiceImpl.class);

    // @Value("${user-service.url}")
    // String user_service_url;
    // private final String USER_SERVICE_IP_URI = user_service_url + "/api/v1/userservice/users";
    private String getServiceUrl(String serviceName) {
        return "http://" + serviceName;
    }

    @Override
    public Response getAllUsers(HttpHeaders headers) {
        HttpEntity requestEntity = new HttpEntity(null);
        String user_service_url = getServiceUrl("ts-user-service");
        String USER_SERVICE_IP_URI = user_service_url + "/api/v1/userservice/users";
        ResponseEntity<Response<List<User>>> re = tsadminuserserviceClient.getApiV1UserserviceUsers(null);
        if ((re.getBody() == null) || (re.getBody().getStatus() != 1)) {
            AdminUserServiceImpl.LOGGER.error("[getAllUsers][receive response][Get All Users error]");
            return new Response(0, "get all users error", null);
        }
        AdminUserServiceImpl.LOGGER.info("[getAllUsers][Get All Users][success]");
        return re.getBody();
    }

    @Override
    public Response deleteUser(String userId, HttpHeaders headers) {
        HttpHeaders newHeaders = new HttpHeaders();
        String token = headers.getFirst(HttpHeaders.AUTHORIZATION);
        newHeaders.set(HttpHeaders.AUTHORIZATION, token);
        HttpEntity<Response> requestEntity = new HttpEntity<>(newHeaders);
        String user_service_url = getServiceUrl("ts-user-service");
        String USER_SERVICE_IP_URI = user_service_url + "/api/v1/userservice/users";
        ResponseEntity<Response> re = tsadminuserserviceClient.deleteApiV1UserserviceUsersPathvariable(userId, newHeaders);
        if ((re.getBody() == null) || (re.getBody().getStatus() != 1)) {
            AdminUserServiceImpl.LOGGER.error("[deleteUser][receive response][Delete user error][userId: {}]", userId);
            return new Response(0, "delete user error", null);
        }
        AdminUserServiceImpl.LOGGER.info("[deleteUser][Delete user success][userId: {}]", userId);
        return re.getBody();
    }

    @Override
    public Response updateUser(UserDto userDto, HttpHeaders headers) {
        LOGGER.info("UPDATE USER: " + userDto.toString());
        HttpHeaders newHeaders = new HttpHeaders();
        String token = headers.getFirst(HttpHeaders.AUTHORIZATION);
        newHeaders.set(HttpHeaders.AUTHORIZATION, token);
        HttpEntity requestEntity = new HttpEntity(userDto, newHeaders);
        String user_service_url = getServiceUrl("ts-user-service");
        String USER_SERVICE_IP_URI = user_service_url + "/api/v1/userservice/users";
        ResponseEntity<Response> re = tsadminuserserviceClient.putApiV1UserserviceUsers(userDto, newHeaders);
        String userName = userDto.getUserName();
        if ((re.getBody() == null) || (re.getBody().getStatus() != 1)) {
            AdminUserServiceImpl.LOGGER.error("[updateUser][receive response][Update user error][userName: {}]", userName);
            return new Response(0, "Update user error", null);
        }
        AdminUserServiceImpl.LOGGER.info("[updateUser][Update user success][userName: {}]", userName);
        return re.getBody();
    }

    @Override
    public Response addUser(UserDto userDto, HttpHeaders headers) {
        LOGGER.info("[addUser][ADD USER INFO][UserDto: {}]", userDto.toString());
        HttpEntity requestEntity = new HttpEntity(userDto, null);
        String user_service_url = getServiceUrl("ts-user-service");
        String USER_SERVICE_IP_URI = user_service_url + "/api/v1/userservice/users";
        ResponseEntity<Response<User>> re = tsadminuserserviceClient.postApiV1UserserviceUsersRegister(userDto, null);
        String userName = userDto.getUserName();
        if ((re.getBody() == null) || (re.getBody().getStatus() != 1)) {
            AdminUserServiceImpl.LOGGER.error("[addUser][receive response][Add user error][userName: {}]", userName);
            return new Response(0, "Add user error", null);
        }
        AdminUserServiceImpl.LOGGER.info("[addUser][Add user success][userName: {}]", userName);
        return re.getBody();
    }
}