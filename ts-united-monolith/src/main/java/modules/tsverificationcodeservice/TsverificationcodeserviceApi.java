package modules.tsverificationcodeservice;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modules.tsverificationcodeservice.verifycode.controller.VerifyCodeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
@Component
public class TsverificationcodeserviceApi {
    @Autowired
    VerifyCodeController verifyCodeController;

    public boolean getApiV1VerifycodeVerifyPathvariable(String verifyCode, HttpServletRequest request, HttpServletResponse response, HttpHeaders headers) {
        return verifyCodeController.verifyCode(verifyCode, request, response, headers);
    }
}