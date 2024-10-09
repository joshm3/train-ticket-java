package modules.tssecurityservice.security.service;
import modules.tscommon.edu.fudan.common.util.Response;
import modules.tssecurityservice.security.entity.SecurityConfig;
import org.springframework.http.HttpHeaders;
/**
 *
 * @author fdse
 */
public interface SecurityService {
    Response findAllSecurityConfig(HttpHeaders headers);

    Response addNewSecurityConfig(SecurityConfig info, HttpHeaders headers);

    Response modifySecurityConfig(SecurityConfig info, HttpHeaders headers);

    Response deleteSecurityConfig(String id, HttpHeaders headers);

    Response check(String accountId, HttpHeaders headers);
}