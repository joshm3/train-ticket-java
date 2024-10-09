package modules.tsadminorderservice;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.ArrayList;
import modules.tscommon.edu.fudan.common.entity.Order;
import modules.tscommon.edu.fudan.common.util.Response;
import modules.tsorderotherservice.TsorderotherserviceApi;
import modules.tsorderotherservice.other.entity.OrderFromtsorderotherservice;
import modules.tsorderservice.TsorderserviceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
@Component
public class TsadminorderserviceClient {
    @Autowired
    TsorderotherserviceApi tsorderotherserviceApi;

    @Autowired
    TsorderserviceApi tsorderserviceApi;

    public ResponseEntity<Response<ArrayList<Order>>> getApiV1OrderserviceOrder(HttpHeaders httpheaders10) {
        HttpHeaders local0;
        if (httpheaders10 != null) {
            HttpHeaders local1 = new HttpHeaders();
            local1.putAll(httpheaders10);
            local0 = local1;
        } else
            local0 = null;

        HttpEntity input = tsorderserviceApi.getApiV1OrderserviceOrder(local0);
        Object local2 = input.getBody();
        Response<ArrayList<Order>> local3 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local2);
            local3 = mapper.readValue(bytes, new TypeReference<Response<ArrayList<Order>>>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local4 = input.getHeaders();
        HttpHeaders local5 = new HttpHeaders();
        local5.putAll(local4);
        ResponseEntity<Response<ArrayList<Order>>> output6 = new ResponseEntity<Response<ArrayList<Order>>>(local3, local5, HttpStatus.CREATED);
        return output6;
    }

    public ResponseEntity<Response<ArrayList<Order>>> getApiV1OrderotherserviceOrderother(HttpHeaders httpheaders7) {
        HttpHeaders local0;
        if (httpheaders7 != null) {
            HttpHeaders local1 = new HttpHeaders();
            local1.putAll(httpheaders7);
            local0 = local1;
        } else
            local0 = null;

        HttpEntity input = tsorderotherserviceApi.getApiV1OrderotherserviceOrderother(local0);
        Object local2 = input.getBody();
        Response<ArrayList<Order>> local3 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local2);
            local3 = mapper.readValue(bytes, new TypeReference<Response<ArrayList<Order>>>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local4 = input.getHeaders();
        HttpHeaders local5 = new HttpHeaders();
        local5.putAll(local4);
        ResponseEntity<Response<ArrayList<Order>>> output6 = new ResponseEntity<Response<ArrayList<Order>>>(local3, local5, HttpStatus.CREATED);
        return output6;
    }

    public ResponseEntity<Response> deleteApiV1OrderserviceOrderPathvariable(String string7, HttpHeaders httpheaders8) {
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

        HttpEntity input = tsorderserviceApi.deleteApiV1OrderserviceOrderPathvariable(local0, local1);
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
        ResponseEntity<Response> output7 = new ResponseEntity<Response>(local4, local6, HttpStatus.CREATED);
        return output7;
    }

    public ResponseEntity<Response> deleteApiV1OrderotherserviceOrderotherPathvariable(String string8, HttpHeaders httpheaders9) {
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

        HttpEntity input = tsorderotherserviceApi.deleteApiV1OrderotherserviceOrderotherPathvariable(local0, local1);
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
        ResponseEntity<Response> output7 = new ResponseEntity<Response>(local4, local6, HttpStatus.CREATED);
        return output7;
    }

    public ResponseEntity<Response> putApiV1OrderserviceOrderAdmin(Order order8, HttpHeaders httpheaders9) {
        modules.tsorderservice.order.entity.Order local0;
        if (order8 != null) {
            modules.tsorderservice.order.entity.Order local1 = null;
            try  {
                com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
                mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
                byte[] bytes = mapper.writeValueAsBytes(order8);
                local1 = mapper.readValue(bytes, new TypeReference<modules.tsorderservice.order.entity.Order>() {});
            } catch (Exception e) {
                System.err.println(e.toString());
            }
            local0 = local1;
        } else
            local0 = null;

        HttpHeaders local2;
        if (httpheaders9 != null) {
            HttpHeaders local3 = new HttpHeaders();
            local3.putAll(httpheaders9);
            local2 = local3;
        } else
            local2 = null;

        HttpEntity input = tsorderserviceApi.putApiV1OrderserviceOrderAdmin(local0, local2);
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

    public ResponseEntity<Response> putApiV1OrderotherserviceOrderotherAdmin(Order order9, HttpHeaders httpheaders10) {
        OrderFromtsorderotherservice local0;
        if (order9 != null) {
            OrderFromtsorderotherservice local1 = null;
            try  {
                com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
                mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
                byte[] bytes = mapper.writeValueAsBytes(order9);
                local1 = mapper.readValue(bytes, new TypeReference<OrderFromtsorderotherservice>() {});
            } catch (Exception e) {
                System.err.println(e.toString());
            }
            local0 = local1;
        } else
            local0 = null;

        HttpHeaders local2;
        if (httpheaders10 != null) {
            HttpHeaders local3 = new HttpHeaders();
            local3.putAll(httpheaders10);
            local2 = local3;
        } else
            local2 = null;

        HttpEntity input = tsorderotherserviceApi.putApiV1OrderotherserviceOrderotherAdmin(local0, local2);
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

    public ResponseEntity<Response> postApiV1OrderserviceOrderAdmin(Order order9, HttpHeaders httpheaders10) {
        modules.tsorderservice.order.entity.Order local0;
        if (order9 != null) {
            modules.tsorderservice.order.entity.Order local1 = null;
            try  {
                com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
                mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
                byte[] bytes = mapper.writeValueAsBytes(order9);
                local1 = mapper.readValue(bytes, new TypeReference<modules.tsorderservice.order.entity.Order>() {});
            } catch (Exception e) {
                System.err.println(e.toString());
            }
            local0 = local1;
        } else
            local0 = null;

        HttpHeaders local2;
        if (httpheaders10 != null) {
            HttpHeaders local3 = new HttpHeaders();
            local3.putAll(httpheaders10);
            local2 = local3;
        } else
            local2 = null;

        HttpEntity input = tsorderserviceApi.postApiV1OrderserviceOrderAdmin(local0, local2);
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

    public ResponseEntity<Response> postApiV1OrderotherserviceOrderotherAdmin(Order order9, HttpHeaders httpheaders10) {
        OrderFromtsorderotherservice local0;
        if (order9 != null) {
            OrderFromtsorderotherservice local1 = null;
            try  {
                com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
                mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
                byte[] bytes = mapper.writeValueAsBytes(order9);
                local1 = mapper.readValue(bytes, new TypeReference<OrderFromtsorderotherservice>() {});
            } catch (Exception e) {
                System.err.println(e.toString());
            }
            local0 = local1;
        } else
            local0 = null;

        HttpHeaders local2;
        if (httpheaders10 != null) {
            HttpHeaders local3 = new HttpHeaders();
            local3.putAll(httpheaders10);
            local2 = local3;
        } else
            local2 = null;

        HttpEntity input = tsorderotherserviceApi.postApiV1OrderotherserviceOrderotherAdmin(local0, local2);
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
}