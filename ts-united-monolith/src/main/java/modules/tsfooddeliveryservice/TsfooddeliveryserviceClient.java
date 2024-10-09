package modules.tsfooddeliveryservice;
import com.fasterxml.jackson.core.type.TypeReference;
import modules.tscommon.edu.fudan.common.util.Response;
import modules.tsfooddeliveryservice.food_delivery.entity.StationFoodStoreInfo;
import modules.tsstationfoodservice.TsstationfoodserviceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
@Component
public class TsfooddeliveryserviceClient {
    @Autowired
    TsstationfoodserviceApi tsstationfoodserviceApi;

    public ResponseEntity<Response<StationFoodStoreInfo>> getApiV1StationfoodserviceStationfoodstoresBystoreidPathvariable(String string8, HttpHeaders httpheaders9) {
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

        HttpEntity input = tsstationfoodserviceApi.getApiV1StationfoodserviceStationfoodstoresBystoreidPathvariable(local0, local1);
        Object local3 = input.getBody();
        Response<StationFoodStoreInfo> local4 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local3);
            local4 = mapper.readValue(bytes, new TypeReference<Response<StationFoodStoreInfo>>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local5 = input.getHeaders();
        HttpHeaders local6 = new HttpHeaders();
        local6.putAll(local5);
        ResponseEntity<Response<StationFoodStoreInfo>> output7 = new ResponseEntity<Response<StationFoodStoreInfo>>(local4, local6, HttpStatus.CREATED);
        return output7;
    }
}