package modules.tssecurityservice;
import modules.tssecurityservice.security.controller.SecurityController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
@Component
public class TssecurityserviceApi {
    @Autowired
    SecurityController securityController;

    public HttpEntity getApiV1SecurityserviceSecurityconfigsPathvariable(String accountId, HttpHeaders headers) {
        return securityController.check(accountId, headers);
    }
}