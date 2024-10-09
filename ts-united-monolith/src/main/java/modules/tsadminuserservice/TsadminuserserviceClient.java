package modules.tsadminuserservice;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;
import modules.tsadminuserservice.adminuser.dto.UserDto;
import modules.tscommon.edu.fudan.common.entity.User;
import modules.tscommon.edu.fudan.common.util.Response;
import modules.tsuserservice.TsuserserviceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
@Component
public class TsadminuserserviceClient {
    @Autowired
    TsuserserviceApi tsuserserviceApi;

    public ResponseEntity<Response<List<User>>> getApiV1UserserviceUsers(HttpHeaders httpheaders0) {
        HttpHeaders local0;
        if (httpheaders0 != null) {
            HttpHeaders local1 = new HttpHeaders();
            local1.putAll(httpheaders0);
            local0 = local1;
        } else
            local0 = null;

        ResponseEntity<Response> input = tsuserserviceApi.getApiV1UserserviceUsers(local0);
        Object local2 = input.getBody();
        Response<List<User>> local3 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local2);
            local3 = mapper.readValue(bytes, new TypeReference<Response<List<User>>>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local4 = input.getHeaders();
        HttpHeaders local5 = new HttpHeaders();
        local5.putAll(local4);
        ResponseEntity<Response<List<User>>> output6 = new ResponseEntity<Response<List<User>>>(local3, local5, input.getStatusCode());
        return output6;
    }

    public ResponseEntity<Response> deleteApiV1UserserviceUsersPathvariable(String string7, HttpHeaders httpheaders8) {
        String local0;
        if (string7 != null) {
            local0 = string7;
        } else
            local0 = null;

        HttpHeaders local1;
        if (httpheaders8 != null) {
            HttpHeaders local2 = new HttpHeaders();
            local2.putAll(httpheaders8);
            local1 = local2;
        } else
            local1 = null;

        ResponseEntity<Response> input = tsuserserviceApi.deleteApiV1UserserviceUsersPathvariable(local0, local1);
        Object local3 = input.getBody();
        Response local4 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local3);
            local4 = mapper.readValue(bytes, new TypeReference<Response>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local5 = input.getHeaders();
        HttpHeaders local6 = new HttpHeaders();
        local6.putAll(local5);
        ResponseEntity<Response> output7 = new ResponseEntity<Response>(local4, local6, input.getStatusCode());
        return output7;
    }

    public ResponseEntity<Response> putApiV1UserserviceUsers(UserDto userdto8, HttpHeaders httpheaders9) {
        modules.tsuserservice.user.dto.UserDto local0;
        if (userdto8 != null) {
            modules.tsuserservice.user.dto.UserDto output1 = new modules.tsuserservice.user.dto.UserDto();
            String field2 = userdto8.getUserId();
            output1.setUserId(field2);
            String field3 = userdto8.getUserName();
            output1.setUserName(field3);
            String field4 = userdto8.getPassword();
            output1.setPassword(field4);
            int field5 = userdto8.getGender();
            output1.setGender(field5);
            int field6 = userdto8.getDocumentType();
            output1.setDocumentType(field6);
            String field7 = userdto8.getDocumentNum();
            output1.setDocumentNum(field7);
            String field8 = userdto8.getEmail();
            output1.setEmail(field8);
            local0 = output1;
        } else
            local0 = null;

        HttpHeaders local9;
        if (httpheaders9 != null) {
            HttpHeaders local10 = new HttpHeaders();
            local10.putAll(httpheaders9);
            local9 = local10;
        } else
            local9 = null;

        ResponseEntity<Response> input = tsuserserviceApi.putApiV1UserserviceUsers(local0, local9);
        Object local11 = input.getBody();
        Response local12 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local11);
            local12 = mapper.readValue(bytes, new TypeReference<Response>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local13 = input.getHeaders();
        HttpHeaders local14 = new HttpHeaders();
        local14.putAll(local13);
        ResponseEntity<Response> output15 = new ResponseEntity<Response>(local12, local14, input.getStatusCode());
        return output15;
    }

    public ResponseEntity<Response<User>> postApiV1UserserviceUsersRegister(UserDto userdto16, HttpHeaders httpheaders17) {
        modules.tsuserservice.user.dto.UserDto local0;
        if (userdto16 != null) {
            modules.tsuserservice.user.dto.UserDto output1 = new modules.tsuserservice.user.dto.UserDto();
            String field2 = userdto16.getUserId();
            output1.setUserId(field2);
            String field3 = userdto16.getUserName();
            output1.setUserName(field3);
            String field4 = userdto16.getPassword();
            output1.setPassword(field4);
            int field5 = userdto16.getGender();
            output1.setGender(field5);
            int field6 = userdto16.getDocumentType();
            output1.setDocumentType(field6);
            String field7 = userdto16.getDocumentNum();
            output1.setDocumentNum(field7);
            String field8 = userdto16.getEmail();
            output1.setEmail(field8);
            local0 = output1;
        } else
            local0 = null;

        HttpHeaders local9;
        if (httpheaders17 != null) {
            HttpHeaders local10 = new HttpHeaders();
            local10.putAll(httpheaders17);
            local9 = local10;
        } else
            local9 = null;

        ResponseEntity<Response> input = tsuserserviceApi.postApiV1UserserviceUsersRegister(local0, local9);
        Object local11 = input.getBody();
        Response<User> local12 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local11);
            local12 = mapper.readValue(bytes, new TypeReference<Response<User>>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local13 = input.getHeaders();
        HttpHeaders local14 = new HttpHeaders();
        local14.putAll(local13);
        ResponseEntity<Response<User>> output15 = new ResponseEntity<Response<User>>(local12, local14, input.getStatusCode());
        return output15;
    }
}