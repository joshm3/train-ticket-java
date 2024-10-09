package modules.tsorderservice;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.ArrayList;
import java.util.List;
import modules.tscommon.edu.fudan.common.entity.Order;
import modules.tscommon.edu.fudan.common.util.Response;
import modules.tsorderotherservice.TsorderotherserviceApi;
import modules.tsstationservice.TsstationserviceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
@Component
public class TsorderserviceClient {
    @Autowired
    TsorderotherserviceApi tsorderotherserviceApi;

    @Autowired
    TsorderserviceApi tsorderserviceApi;

    @Autowired
    TsstationserviceApi tsstationserviceApi;

    public ResponseEntity<Response<List<String>>> postApiV1StationserviceStationsNamelist(List<String> list7, HttpHeaders httpheaders8) {
        List<String> local0;
        if (list7 != null) {
            ArrayList<String> output1 = new ArrayList<String>();
            for (String listType2 : list7) {
                output1.add(listType2);
            }
            local0 = output1;
        } else
            local0 = null;

        HttpHeaders local3;
        if (httpheaders8 != null) {
            HttpHeaders local4 = new HttpHeaders();
            local4.putAll(httpheaders8);
            local3 = local4;
        } else
            local3 = null;

        HttpEntity input = tsstationserviceApi.postApiV1StationserviceStationsNamelist(local0, local3);
        Object local5 = input.getBody();
        Response<List<String>> local6 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local5);
            local6 = mapper.readValue(bytes, new TypeReference<Response<List<String>>>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local7 = input.getHeaders();
        HttpHeaders local8 = new HttpHeaders();
        local8.putAll(local7);
        ResponseEntity<Response<List<String>>> output9 = new ResponseEntity<Response<List<String>>>(local6, local8, HttpStatus.CREATED);
        return output9;
    }

    public ResponseEntity<Response<Order>> getApiV1OrderserviceOrderPathvariable(String string10, HttpHeaders httpheaders11) {
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