package modules.tsexecuteservice;
import com.fasterxml.jackson.core.type.TypeReference;
import modules.tscommon.edu.fudan.common.entity.Order;
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
public class TsexecuteserviceClient {
    @Autowired
    TsorderotherserviceApi tsorderotherserviceApi;

    @Autowired
    TsorderserviceApi tsorderserviceApi;

    public ResponseEntity<Response> getApiV1OrderserviceOrderStatusPathvariablePathvariable(String string8, int int9, HttpHeaders httpheaders10) {
        String local0;
        if (string8 != null) {
            local0 = string8;
        } else
            local0 = null;

        int local1;
        HttpHeaders local2;
        if (httpheaders10 != null) {
            HttpHeaders local3 = new HttpHeaders();
            local3.putAll(httpheaders10);
            local2 = local3;
        } else
            local2 = null;

        HttpEntity input = tsorderserviceApi.getApiV1OrderserviceOrderStatusPathvariablePathvariable(local0, int9, local2);
        Object local4 = input.getBody();
        Response local5 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local4);
            local5 = mapper.readValue(bytes, new TypeReference<Response>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local6 = input.getHeaders();
        HttpHeaders local7 = new HttpHeaders();
        local7.putAll(local6);
        ResponseEntity<Response> output8 = new ResponseEntity<Response>(local5, local7, HttpStatus.CREATED);
        return output8;
    }

    public ResponseEntity<Response> getApiV1OrderotherserviceOrderotherStatusPathvariablePathvariable(String string9, int int10, HttpHeaders httpheaders11) {
        String local0;
        if (string9 != null) {
            local0 = string9;
        } else
            local0 = null;

        int local1;
        HttpHeaders local2;
        if (httpheaders11 != null) {
            HttpHeaders local3 = new HttpHeaders();
            local3.putAll(httpheaders11);
            local2 = local3;
        } else
            local2 = null;

        HttpEntity input = tsorderotherserviceApi.getApiV1OrderotherserviceOrderotherStatusPathvariablePathvariable(local0, int10, local2);
        Object local4 = input.getBody();
        Response local5 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local4);
            local5 = mapper.readValue(bytes, new TypeReference<Response>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local6 = input.getHeaders();
        HttpHeaders local7 = new HttpHeaders();
        local7.putAll(local6);
        ResponseEntity<Response> output8 = new ResponseEntity<Response>(local5, local7, HttpStatus.CREATED);
        return output8;
    }

    public ResponseEntity<Response<Order>> getApiV1OrderserviceOrderPathvariable(String string9, HttpHeaders httpheaders10) {
        String local0;
        if (string9 != null) {
            local0 = string9;
        } else
            local0 = null;

        HttpHeaders local1;
        if (httpheaders10 != null) {
            HttpHeaders local2 = new HttpHeaders();
            local2.putAll(httpheaders10);
            local1 = local2;
        } else
            local1 = null;

        HttpEntity input = tsorderserviceApi.getApiV1OrderserviceOrderPathvariable(local0, local1);
        Object local3 = input.getBody();
        Response<Order> local4 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local3);
            local4 = mapper.readValue(bytes, new TypeReference<Response<Order>>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local5 = input.getHeaders();
        HttpHeaders local6 = new HttpHeaders();
        local6.putAll(local5);
        ResponseEntity<Response<Order>> output7 = new ResponseEntity<Response<Order>>(local4, local6, HttpStatus.CREATED);
        return output7;
    }

    public ResponseEntity<Response<Order>> getApiV1OrderotherserviceOrderotherPathvariable(String string8, HttpHeaders httpheaders9) {
        String local0;
        if (string8 != null) {
            local0 = string8;
        } else
            local0 = null;

        HttpHeaders local1;
        if (httpheaders9 != null) {
            HttpHeaders local2 = new HttpHeaders();
            local2.putAll(httpheaders9);
            local1 = local2;
        } else
            local1 = null;

        HttpEntity input = tsorderotherserviceApi.getApiV1OrderotherserviceOrderotherPathvariable(local0, local1);
        Object local3 = input.getBody();
        Response<Order> local4 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local3);
            local4 = mapper.readValue(bytes, new TypeReference<Response<Order>>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local5 = input.getHeaders();
        HttpHeaders local6 = new HttpHeaders();
        local6.putAll(local5);
        ResponseEntity<Response<Order>> output7 = new ResponseEntity<Response<Order>>(local4, local6, HttpStatus.CREATED);
        return output7;
    }
}