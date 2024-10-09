package modules.tsbasicservice;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.ArrayList;
import java.util.List;
import modules.tscommon.edu.fudan.common.util.Response;
import modules.tspriceservice.TspriceserviceApi;
import modules.tsrouteservice.TsrouteserviceApi;
import modules.tsstationservice.TsstationserviceApi;
import modules.tstrainservice.TstrainserviceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
@Component
public class TsbasicserviceClient {
    @Autowired
    TspriceserviceApi tspriceserviceApi;

    @Autowired
    TsrouteserviceApi tsrouteserviceApi;

    @Autowired
    TstrainserviceApi tstrainserviceApi;

    @Autowired
    TsstationserviceApi tsstationserviceApi;

    public ResponseEntity<Response> getApiV1StationserviceStationsIdPathvariable(String string10, HttpHeaders httpheaders11) {
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

        HttpEntity input = tsstationserviceApi.getApiV1StationserviceStationsIdPathvariable(local0, local1);
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

    public ResponseEntity<Response> postApiV1StationserviceStationsIdlist(List<String> list8, HttpHeaders httpheaders9) {
        List<String> local0;
        if (list8 != null) {
            ArrayList<String> output1 = new ArrayList<String>();
            for (String listType2 : list8) {
                output1.add(listType2);
            }
            local0 = output1;
        } else
            local0 = null;

        HttpHeaders local3;
        if (httpheaders9 != null) {
            HttpHeaders local4 = new HttpHeaders();
            local4.putAll(httpheaders9);
            local3 = local4;
        } else
            local3 = null;

        HttpEntity input = tsstationserviceApi.postApiV1StationserviceStationsIdlist(local0, local3);
        Object local5 = input.getBody();
        Response local6 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local5);
            local6 = mapper.readValue(bytes, new TypeReference<Response>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local7 = input.getHeaders();
        HttpHeaders local8 = new HttpHeaders();
        local8.putAll(local7);
        ResponseEntity<Response> output9 = new ResponseEntity<Response>(local6, local8, HttpStatus.CREATED);
        return output9;
    }

    public ResponseEntity<Response> postApiV1TrainserviceTrainsBynames(List<String> list12, HttpHeaders httpheaders13) {
        List<String> local0;
        if (list12 != null) {
            ArrayList<String> output1 = new ArrayList<String>();
            for (String listType2 : list12) {
                output1.add(listType2);
            }
            local0 = output1;
        } else
            local0 = null;

        HttpHeaders local3;
        if (httpheaders13 != null) {
            HttpHeaders local4 = new HttpHeaders();
            local4.putAll(httpheaders13);
            local3 = local4;
        } else
            local3 = null;

        HttpEntity input = tstrainserviceApi.postApiV1TrainserviceTrainsBynames(local0, local3);
        Object local5 = input.getBody();
        Response local6 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local5);
            local6 = mapper.readValue(bytes, new TypeReference<Response>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local7 = input.getHeaders();
        HttpHeaders local8 = new HttpHeaders();
        local8.putAll(local7);
        ResponseEntity<Response> output9 = new ResponseEntity<Response>(local6, local8, HttpStatus.CREATED);
        return output9;
    }

    public ResponseEntity<Response> getApiV1TrainserviceTrainsBynamePathvariable(String string10, HttpHeaders httpheaders11) {
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

        HttpEntity input = tstrainserviceApi.getApiV1TrainserviceTrainsBynamePathvariable(local0, local1);
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

    public ResponseEntity<Response> postApiV1RouteserviceRoutesByids(List<String> list8, HttpHeaders httpheaders9) {
        List<String> local0;
        if (list8 != null) {
            ArrayList<String> output1 = new ArrayList<String>();
            for (String listType2 : list8) {
                output1.add(listType2);
            }
            local0 = output1;
        } else
            local0 = null;

        HttpHeaders local3;
        if (httpheaders9 != null) {
            HttpHeaders local4 = new HttpHeaders();
            local4.putAll(httpheaders9);
            local3 = local4;
        } else
            local3 = null;

        HttpEntity input = tsrouteserviceApi.postApiV1RouteserviceRoutesByids(local0, local3);
        Object local5 = input.getBody();
        Response local6 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local5);
            local6 = mapper.readValue(bytes, new TypeReference<Response>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local7 = input.getHeaders();
        HttpHeaders local8 = new HttpHeaders();
        local8.putAll(local7);
        ResponseEntity<Response> output9 = new ResponseEntity<Response>(local6, local8, HttpStatus.CREATED);
        return output9;
    }

    public ResponseEntity<Response> getApiV1RouteserviceRoutesPathvariable(String string10, HttpHeaders httpheaders11) {
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

        HttpEntity input = tsrouteserviceApi.getApiV1RouteserviceRoutesPathvariable(local0, local1);
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

    public ResponseEntity<Response> getApiV1PriceservicePricesPathvariablePathvariable(String string8, String string9, HttpHeaders httpheaders10) {
        String local0;
        if (string8 != null) {
            local0 = string8;
        } else
            local0 = null;

        String local1;
        if (string9 != null) {
            local1 = string9;
        } else
            local1 = null;

        HttpHeaders local2;
        if (httpheaders10 != null) {
            HttpHeaders local3 = new HttpHeaders();
            local3.putAll(httpheaders10);
            local2 = local3;
        } else
            local2 = null;

        HttpEntity input = tspriceserviceApi.getApiV1PriceservicePricesPathvariablePathvariable(local0, local1, local2);
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

    public ResponseEntity<Response> postApiV1PriceservicePricesByrouteidsandtraintypes(List<String> list9, HttpHeaders httpheaders10) {
        List<String> local0;
        if (list9 != null) {
            ArrayList<String> output1 = new ArrayList<String>();
            for (String listType2 : list9) {
                output1.add(listType2);
            }
            local0 = output1;
        } else
            local0 = null;

        HttpHeaders local3;
        if (httpheaders10 != null) {
            HttpHeaders local4 = new HttpHeaders();
            local4.putAll(httpheaders10);
            local3 = local4;
        } else
            local3 = null;

        HttpEntity input = tspriceserviceApi.postApiV1PriceservicePricesByrouteidsandtraintypes(local0, local3);
        Object local5 = input.getBody();
        Response local6 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local5);
            local6 = mapper.readValue(bytes, new TypeReference<Response>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local7 = input.getHeaders();
        HttpHeaders local8 = new HttpHeaders();
        local8.putAll(local7);
        ResponseEntity<Response> output9 = new ResponseEntity<Response>(local6, local8, HttpStatus.CREATED);
        return output9;
    }
}