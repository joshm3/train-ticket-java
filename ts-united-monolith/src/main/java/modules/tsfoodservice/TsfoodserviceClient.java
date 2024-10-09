package modules.tsfoodservice;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.ArrayList;
import java.util.List;
import modules.tscommon.edu.fudan.common.entity.Food;
import modules.tscommon.edu.fudan.common.entity.Route;
import modules.tscommon.edu.fudan.common.entity.StationFoodStore;
import modules.tscommon.edu.fudan.common.util.Response;
import modules.tsstationfoodservice.TsstationfoodserviceApi;
import modules.tstrainfoodservice.TstrainfoodserviceApi;
import modules.tstravelservice.TstravelserviceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
@Component
public class TsfoodserviceClient {
    @Autowired
    TsstationfoodserviceApi tsstationfoodserviceApi;

    @Autowired
    TstravelserviceApi tstravelserviceApi;

    @Autowired
    TstrainfoodserviceApi tstrainfoodserviceApi;

    public ResponseEntity<Response<List<Food>>> getApiV1TrainfoodserviceTrainfoodsPathvariable(String string4, HttpHeaders httpheaders5) {
        String local0;
        if (string4 != null) {
            local0 = string4;
        } else
            local0 = null;

        HttpHeaders local1;
        if (httpheaders5 != null) {
            HttpHeaders local2 = new HttpHeaders();
            local2.putAll(httpheaders5);
            local1 = local2;
        } else
            local1 = null;

        HttpEntity input = tstrainfoodserviceApi.getApiV1TrainfoodserviceTrainfoodsPathvariable(local0, local1);
        Object local3 = input.getBody();
        Response<List<Food>> local4 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local3);
            local4 = mapper.readValue(bytes, new TypeReference<Response<List<Food>>>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local5 = input.getHeaders();
        HttpHeaders local6 = new HttpHeaders();
        local6.putAll(local5);
        ResponseEntity<Response<List<Food>>> output7 = new ResponseEntity<Response<List<Food>>>(local4, local6, HttpStatus.CREATED);
        return output7;
    }

    public ResponseEntity<Response<Route>> getApiV1TravelserviceRoutesPathvariable(String string8, HttpHeaders httpheaders9) {
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

        HttpEntity input = tstravelserviceApi.getApiV1TravelserviceRoutesPathvariable(local0, local1);
        Object local3 = input.getBody();
        Response<Route> local4 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local3);
            local4 = mapper.readValue(bytes, new TypeReference<Response<Route>>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local5 = input.getHeaders();
        HttpHeaders local6 = new HttpHeaders();
        local6.putAll(local5);
        ResponseEntity<Response<Route>> output7 = new ResponseEntity<Response<Route>>(local4, local6, HttpStatus.CREATED);
        return output7;
    }

    public ResponseEntity<Response<List<StationFoodStore>>> postApiV1StationfoodserviceStationfoodstores(List<String> list8) {
        List<String> local0;
        if (list8 != null) {
            ArrayList<String> output1 = new ArrayList<String>();
            for (String listType2 : list8) {
                output1.add(listType2);
            }
            local0 = output1;
        } else
            local0 = null;

        HttpEntity input = tsstationfoodserviceApi.postApiV1StationfoodserviceStationfoodstores(local0);
        Object local3 = input.getBody();
        Response<List<StationFoodStore>> local4 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local3);
            local4 = mapper.readValue(bytes, new TypeReference<Response<List<StationFoodStore>>>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local5 = input.getHeaders();
        HttpHeaders local6 = new HttpHeaders();
        local6.putAll(local5);
        ResponseEntity<Response<List<StationFoodStore>>> output7 = new ResponseEntity<Response<List<StationFoodStore>>>(local4, local6, HttpStatus.CREATED);
        return output7;
    }
}