package modules.tsadminrouteservice;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.ArrayList;
import java.util.List;
import modules.tscommon.edu.fudan.common.entity.Route;
import modules.tscommon.edu.fudan.common.entity.RouteInfo;
import modules.tscommon.edu.fudan.common.util.Response;
import modules.tsrouteservice.TsrouteserviceApi;
import modules.tsstationservice.TsstationserviceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
@Component
public class TsadminrouteserviceClient {
    @Autowired
    TsstationserviceApi tsstationserviceApi;

    @Autowired
    TsrouteserviceApi tsrouteserviceApi;

    public ResponseEntity<Response> getApiV1RouteserviceRoutes(HttpHeaders httpheaders8) {
        HttpHeaders local0;
        if (httpheaders8 != null) {
            HttpHeaders local1 = new HttpHeaders();
            local1.putAll(httpheaders8);
            local0 = local1;
        } else
            local0 = null;

        HttpEntity input = tsrouteserviceApi.getApiV1RouteserviceRoutes(local0);
        Object local2 = input.getBody();
        Response local3 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local2);
            local3 = mapper.readValue(bytes, new TypeReference<Response>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local4 = input.getHeaders();
        HttpHeaders local5 = new HttpHeaders();
        local5.putAll(local4);
        ResponseEntity<Response> output6 = new ResponseEntity<Response>(local3, local5, HttpStatus.CREATED);
        return output6;
    }

    public ResponseEntity<Response<Route>> postApiV1RouteserviceRoutes(RouteInfo routeinfo7, HttpHeaders httpheaders8) {
        modules.tsrouteservice.route.entity.RouteInfo local0;
        if (routeinfo7 != null) {
            modules.tsrouteservice.route.entity.RouteInfo local1 = null;
            try  {
                com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
                mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
                byte[] bytes = mapper.writeValueAsBytes(routeinfo7);
                local1 = mapper.readValue(bytes, new TypeReference<modules.tsrouteservice.route.entity.RouteInfo>() {});
            } catch (Exception e) {
                System.err.println(e.toString());
            }
            local0 = local1;
        } else
            local0 = null;

        HttpHeaders local2;
        if (httpheaders8 != null) {
            HttpHeaders local3 = new HttpHeaders();
            local3.putAll(httpheaders8);
            local2 = local3;
        } else
            local2 = null;

        ResponseEntity<Response> input = tsrouteserviceApi.postApiV1RouteserviceRoutes(local0, local2);
        Object local4 = input.getBody();
        Response<Route> local5 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local4);
            local5 = mapper.readValue(bytes, new TypeReference<Response<Route>>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local6 = input.getHeaders();
        HttpHeaders local7 = new HttpHeaders();
        local7.putAll(local6);
        ResponseEntity<Response<Route>> output8 = new ResponseEntity<Response<Route>>(local5, local7, input.getStatusCode());
        return output8;
    }

    public ResponseEntity<Response> deleteApiV1RouteserviceRoutesPathvariable(String string9, HttpHeaders httpheaders10) {
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

        HttpEntity input = tsrouteserviceApi.deleteApiV1RouteserviceRoutesPathvariable(local0, local1);
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
}