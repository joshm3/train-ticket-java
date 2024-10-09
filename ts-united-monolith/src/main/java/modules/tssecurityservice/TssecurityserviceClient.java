package modules.tssecurityservice;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Date;
import modules.tscommon.edu.fudan.common.entity.OrderSecurity;
import modules.tscommon.edu.fudan.common.util.Response;
import modules.tsorderotherservice.TsorderotherserviceApi;
import modules.tsorderservice.TsorderserviceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
@Component
public class TssecurityserviceClient {
    @Autowired
    TsorderotherserviceApi tsorderotherserviceApi;

    @Autowired
    TsorderserviceApi tsorderserviceApi;

    public ResponseEntity<Response<OrderSecurity>> getApiV1OrderserviceOrderSecurityPathvariablePathvariable(Date date8, String string9, HttpHeaders httpheaders10) {
        String local0;
        if (date8 != null) {
            String local1 = null;
            try  {
                com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
                mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
                byte[] bytes = mapper.writeValueAsBytes(date8);
                local1 = mapper.readValue(bytes, new TypeReference<String>() {});
            } catch (Exception e) {
                System.err.println(e.toString());
            }
            local0 = local1;
        } else
            local0 = null;

        String local2;
        if (string9 != null) {
            local2 = string9;
        } else
            local2 = null;

        HttpHeaders local3;
        if (httpheaders10 != null) {
            HttpHeaders local4 = new HttpHeaders();
            local4.putAll(httpheaders10);
            local3 = local4;
        } else
            local3 = null;

        HttpEntity input = tsorderserviceApi.getApiV1OrderserviceOrderSecurityPathvariablePathvariable(local0, local2, local3);
        Object local5 = input.getBody();
        Response<OrderSecurity> local6 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local5);
            local6 = mapper.readValue(bytes, new TypeReference<Response<OrderSecurity>>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local7 = input.getHeaders();
        HttpHeaders local8 = new HttpHeaders();
        local8.putAll(local7);
        ResponseEntity<Response<OrderSecurity>> output9 = new ResponseEntity<Response<OrderSecurity>>(local6, local8, HttpStatus.CREATED);
        return output9;
    }

    public ResponseEntity<Response<OrderSecurity>> getApiV1OrderotherserviceOrderotherSecurityPathvariablePathvariable(Date date10, String string11, HttpHeaders httpheaders12) {
        String local0;
        if (date10 != null) {
            String local1 = null;
            try  {
                com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
                mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
                byte[] bytes = mapper.writeValueAsBytes(date10);
                local1 = mapper.readValue(bytes, new TypeReference<String>() {});
            } catch (Exception e) {
                System.err.println(e.toString());
            }
            local0 = local1;
        } else
            local0 = null;

        String local2;
        if (string11 != null) {
            local2 = string11;
        } else
            local2 = null;

        HttpHeaders local3;
        if (httpheaders12 != null) {
            HttpHeaders local4 = new HttpHeaders();
            local4.putAll(httpheaders12);
            local3 = local4;
        } else
            local3 = null;

        HttpEntity input = tsorderotherserviceApi.getApiV1OrderotherserviceOrderotherSecurityPathvariablePathvariable(local0, local2, local3);
        Object local5 = input.getBody();
        Response<OrderSecurity> local6 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local5);
            local6 = mapper.readValue(bytes, new TypeReference<Response<OrderSecurity>>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local7 = input.getHeaders();
        HttpHeaders local8 = new HttpHeaders();
        local8.putAll(local7);
        ResponseEntity<Response<OrderSecurity>> output9 = new ResponseEntity<Response<OrderSecurity>>(local6, local8, HttpStatus.CREATED);
        return output9;
    }
}