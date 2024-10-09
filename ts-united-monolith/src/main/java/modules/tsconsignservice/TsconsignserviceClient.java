package modules.tsconsignservice;
import com.fasterxml.jackson.core.type.TypeReference;
import modules.tscommon.edu.fudan.common.util.Response;
import modules.tsconsignpriceservice.TsconsignpriceserviceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
@Component
public class TsconsignserviceClient {
    @Autowired
    TsconsignpriceserviceApi tsconsignpriceserviceApi;

    public ResponseEntity<Response<Double>> getApiV1ConsignpriceserviceConsignpricePathvariablePathvariable(double double10, boolean boolean11, HttpHeaders httpheaders12) {
        String local0;
        String local1 = String.valueOf(double10);
        String local2;
        String local3 = String.valueOf(boolean11);
        HttpHeaders local4;
        if (httpheaders12 != null) {
            HttpHeaders local5 = new HttpHeaders();
            local5.putAll(httpheaders12);
            local4 = local5;
        } else
            local4 = null;

        HttpEntity input = tsconsignpriceserviceApi.getApiV1ConsignpriceserviceConsignpricePathvariablePathvariable(local1, local3, local4);
        Object local6 = input.getBody();
        Response<Double> local7 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local6);
            local7 = mapper.readValue(bytes, new TypeReference<Response<Double>>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local8 = input.getHeaders();
        HttpHeaders local9 = new HttpHeaders();
        local9.putAll(local8);
        ResponseEntity<Response<Double>> output10 = new ResponseEntity<Response<Double>>(local7, local9, HttpStatus.CREATED);
        return output10;
    }
}