package modules.tsauthservice;
import javax.servlet.http.HttpServletRequest;
import modules.tsverificationcodeservice.TsverificationcodeserviceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
@Component
public class TsauthserviceClient {
    @Autowired
    javax.servlet.http.HttpServletResponse HttpServletResponse;

    @Autowired
    HttpServletRequest httpServletRequest;

    @Autowired
    TsverificationcodeserviceApi tsverificationcodeserviceApi;

    public ResponseEntity<Boolean> getApiV1VerifycodeVerifyPathvariable(String string3, HttpHeaders httpheaders4) {
        String local0;
        if (string3 != null) {
            local0 = string3;
        } else
            local0 = null;

        HttpHeaders local1;
        if (httpheaders4 != null) {
            HttpHeaders local2 = new HttpHeaders();
            local2.putAll(httpheaders4);
            local1 = local2;
        } else
            local1 = null;

        boolean input = tsverificationcodeserviceApi.getApiV1VerifycodeVerifyPathvariable(local0, httpServletRequest, HttpServletResponse, local1);
        ResponseEntity output3 = new ResponseEntity(input, HttpStatus.CREATED);
        return output3;
    }
}