package modules.tscancelservice;
import com.fasterxml.jackson.core.type.TypeReference;
import modules.tscommon.edu.fudan.common.entity.NotifyInfo;
import modules.tscommon.edu.fudan.common.entity.Order;
import modules.tscommon.edu.fudan.common.entity.User;
import modules.tscommon.edu.fudan.common.util.Response;
import modules.tsinsidepaymentservice.TsinsidepaymentserviceApi;
import modules.tsnotificationservice.TsnotificationserviceApi;
import modules.tsorderotherservice.TsorderotherserviceApi;
import modules.tsorderotherservice.other.entity.OrderFromtsorderotherservice;
import modules.tsorderservice.TsorderserviceApi;
import modules.tsuserservice.TsuserserviceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
@Component
public class TscancelserviceClient {
    @Autowired
    TsuserserviceApi tsuserserviceApi;

    @Autowired
    TsinsidepaymentserviceApi tsinsidepaymentserviceApi;

    @Autowired
    TsorderotherserviceApi tsorderotherserviceApi;

    @Autowired
    TsorderserviceApi tsorderserviceApi;

    @Autowired
    TsnotificationserviceApi tsnotificationserviceApi;

    public ResponseEntity<Boolean> postApiV1NotifyserviceNotificationOrder_cancel_success(NotifyInfo notifyinfo20, HttpHeaders httpheaders21) {
        modules.tsnotificationservice.notification.entity.NotifyInfo local0;
        if (notifyinfo20 != null) {
            modules.tsnotificationservice.notification.entity.NotifyInfo local1 = null;
            try  {
                com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
                mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
                byte[] bytes = mapper.writeValueAsBytes(notifyinfo20);
                local1 = mapper.readValue(bytes, new TypeReference<modules.tsnotificationservice.notification.entity.NotifyInfo>() {});
            } catch (Exception e) {
                System.err.println(e.toString());
            }
            local0 = local1;
        } else
            local0 = null;

        HttpHeaders local2;
        if (httpheaders21 != null) {
            HttpHeaders local3 = new HttpHeaders();
            local3.putAll(httpheaders21);
            local2 = local3;
        } else
            local2 = null;

        boolean input = tsnotificationserviceApi.postApiV1NotifyserviceNotificationOrder_cancel_success(local0, local2);
        ResponseEntity output4 = new ResponseEntity(input, HttpStatus.CREATED);
        return output4;
    }

    public ResponseEntity<Response> putApiV1OrderserviceOrder(Order order5, HttpHeaders httpheaders6) {
        modules.tsorderservice.order.entity.Order local0;
        if (order5 != null) {
            modules.tsorderservice.order.entity.Order local1 = null;
            try  {
                com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
                mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
                byte[] bytes = mapper.writeValueAsBytes(order5);
                local1 = mapper.readValue(bytes, new TypeReference<modules.tsorderservice.order.entity.Order>() {});
            } catch (Exception e) {
                System.err.println(e.toString());
            }
            local0 = local1;
        } else
            local0 = null;

        HttpHeaders local2;
        if (httpheaders6 != null) {
            HttpHeaders local3 = new HttpHeaders();
            local3.putAll(httpheaders6);
            local2 = local3;
        } else
            local2 = null;

        HttpEntity input = tsorderserviceApi.putApiV1OrderserviceOrder(local0, local2);
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

    public ResponseEntity<Response> putApiV1OrderotherserviceOrderother(Order order9, HttpHeaders httpheaders10) {
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

        HttpEntity input = tsorderotherserviceApi.putApiV1OrderotherserviceOrderother(local0, local2);
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

    public ResponseEntity<Response> getApiV1Inside_pay_serviceInside_paymentDrawbackPathvariablePathvariable(String string9, String string10, HttpHeaders httpheaders11) {
        String local0;
        if (string9 != null) {
            local0 = string9;
        } else
            local0 = null;

        String local1;
        if (string10 != null) {
            local1 = string10;
        } else
            local1 = null;

        HttpHeaders local2;
        if (httpheaders11 != null) {
            HttpHeaders local3 = new HttpHeaders();
            local3.putAll(httpheaders11);
            local2 = local3;
        } else
            local2 = null;

        HttpEntity input = tsinsidepaymentserviceApi.getApiV1Inside_pay_serviceInside_paymentDrawbackPathvariablePathvariable(local0, local1, local2);
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

    public ResponseEntity<Response<User>> getApiV1UserserviceUsersIdPathvariable(String string9, HttpHeaders httpheaders10) {
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

        ResponseEntity<Response> input = tsuserserviceApi.getApiV1UserserviceUsersIdPathvariable(local0, local1);
        Object local3 = input.getBody();
        Response<User> local4 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local3);
            local4 = mapper.readValue(bytes, new TypeReference<Response<User>>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local5 = input.getHeaders();
        HttpHeaders local6 = new HttpHeaders();
        local6.putAll(local5);
        ResponseEntity<Response<User>> output7 = new ResponseEntity<Response<User>>(local4, local6, input.getStatusCode());
        return output7;
    }

    public ResponseEntity<Response<Order>> getApiV1OrderserviceOrderPathvariable(String string8, HttpHeaders httpheaders9) {
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