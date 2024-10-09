package modules.tsorderotherservice;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.ArrayList;
import java.util.List;
import modules.tscommon.edu.fudan.common.util.Response;
import modules.tsstationservice.TsstationserviceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
@Component
public class TsorderotherserviceClient {
    @Autowired
    TsstationserviceApi tsstationserviceApi;

    public ResponseEntity<Response<List<String>>> postApiV1StationserviceStationsNamelist(List<String> list8, HttpHeaders httpheaders9) {
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
}