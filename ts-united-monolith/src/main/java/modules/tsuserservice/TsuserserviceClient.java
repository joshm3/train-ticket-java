package modules.tsuserservice;
import com.fasterxml.jackson.core.type.TypeReference;
import modules.tsauthservice.TsauthserviceApi;
import modules.tscommon.edu.fudan.common.util.Response;
import modules.tsuserservice.user.dto.AuthDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
@Component
public class TsuserserviceClient {
    @Autowired
    TsauthserviceApi tsauthserviceApi;

    public ResponseEntity<Response<AuthDto>> postApiV1Auth(AuthDto authdto16) {
        modules.tsauthservice.auth.dto.AuthDto local0;
        if (authdto16 != null) {
            modules.tsauthservice.auth.dto.AuthDto output1 = new modules.tsauthservice.auth.dto.AuthDto();
            String field2 = authdto16.getUserId();
            output1.setUserId(field2);
            String field3 = authdto16.getUserName();
            output1.setUserName(field3);
            String field4 = authdto16.getPassword();
            output1.setPassword(field4);
            local0 = output1;
        } else
            local0 = null;

        HttpEntity<Response> input = tsauthserviceApi.postApiV1Auth(local0);
        Object local5 = input.getBody();
        Response<AuthDto> local6 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local5);
            local6 = mapper.readValue(bytes, new TypeReference<Response<AuthDto>>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local7 = input.getHeaders();
        HttpHeaders local8 = new HttpHeaders();
        local8.putAll(local7);
        ResponseEntity<Response<AuthDto>> output9 = new ResponseEntity<Response<AuthDto>>(local6, local8, HttpStatus.CREATED);
        return output9;
    }

    public void deleteApiV1UsersPathvariable(String string10, HttpHeaders httpheaders11) {
        String local0;
        if (string10 != null) {
            local0 = string10;
        } else
            local0 = null;

        HttpHeaders local1;
        if (httpheaders11 != null) {
            HttpHeaders local2 = new HttpHeaders();
            local2.putAll(httpheaders11);
            local1 = local2;
        } else
            local1 = null;

        ResponseEntity<Response> input = tsauthserviceApi.deleteApiV1UsersPathvariable(local0, local1);
        return;
    }
}