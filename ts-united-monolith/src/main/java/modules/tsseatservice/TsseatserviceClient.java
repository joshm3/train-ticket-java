package modules.tsseatservice;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.ArrayList;
import java.util.List;
import modules.tscommon.edu.fudan.common.entity.Config;
import modules.tscommon.edu.fudan.common.entity.LeftTicketInfo;
import modules.tscommon.edu.fudan.common.entity.Seat;
import modules.tscommon.edu.fudan.common.util.Response;
import modules.tsconfigservice.TsconfigserviceApi;
import modules.tsorderotherservice.TsorderotherserviceApi;
import modules.tsorderservice.TsorderserviceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
@Component
public class TsseatserviceClient {
    @Autowired
    TsconfigserviceApi tsconfigserviceApi;

    @Autowired
    TsorderotherserviceApi tsorderotherserviceApi;

    @Autowired
    TsorderserviceApi tsorderserviceApi;

    public ResponseEntity<Response<LeftTicketInfo>> postApiV1OrderserviceOrderTickets(Seat seat8, HttpHeaders httpheaders9) {
        Seat local0;
        if (seat8 != null) {
            Seat output1 = new Seat();
            String field2 = seat8.getTravelDate();
            output1.setTravelDate(field2);
            String field3 = seat8.getTrainNumber();
            output1.setTrainNumber(field3);
            String field4 = seat8.getStartStation();
            output1.setStartStation(field4);
            String field5 = seat8.getDestStation();
            output1.setDestStation(field5);
            int field6 = seat8.getSeatType();
            output1.setSeatType(field6);
            int field7 = seat8.getTotalNum();
            output1.setTotalNum(field7);
            List<String> field8 = seat8.getStations();
            ArrayList<String> output9 = new ArrayList<String>();
            for (String listType10 : field8) {
                output9.add(listType10);
            }
            output1.setStations(output9);
            local0 = output1;
        } else
            local0 = null;

        HttpHeaders local11;
        if (httpheaders9 != null) {
            HttpHeaders local12 = new HttpHeaders();
            local12.putAll(httpheaders9);
            local11 = local12;
        } else
            local11 = null;

        HttpEntity input = tsorderserviceApi.postApiV1OrderserviceOrderTickets(local0, local11);
        Object local13 = input.getBody();
        Response<LeftTicketInfo> local14 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local13);
            local14 = mapper.readValue(bytes, new TypeReference<Response<LeftTicketInfo>>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local15 = input.getHeaders();
        HttpHeaders local16 = new HttpHeaders();
        local16.putAll(local15);
        ResponseEntity<Response<LeftTicketInfo>> output17 = new ResponseEntity<Response<LeftTicketInfo>>(local14, local16, HttpStatus.CREATED);
        return output17;
    }

    public ResponseEntity<Response<LeftTicketInfo>> postApiV1OrderotherserviceOrderotherTickets(Seat seat18, HttpHeaders httpheaders19) {
        Seat local0;
        if (seat18 != null) {
            Seat output1 = new Seat();
            String field2 = seat18.getTravelDate();
            output1.setTravelDate(field2);
            String field3 = seat18.getTrainNumber();
            output1.setTrainNumber(field3);
            String field4 = seat18.getStartStation();
            output1.setStartStation(field4);
            String field5 = seat18.getDestStation();
            output1.setDestStation(field5);
            int field6 = seat18.getSeatType();
            output1.setSeatType(field6);
            int field7 = seat18.getTotalNum();
            output1.setTotalNum(field7);
            List<String> field8 = seat18.getStations();
            ArrayList<String> output9 = new ArrayList<String>();
            for (String listType10 : field8) {
                output9.add(listType10);
            }
            output1.setStations(output9);
            local0 = output1;
        } else
            local0 = null;

        HttpHeaders local11;
        if (httpheaders19 != null) {
            HttpHeaders local12 = new HttpHeaders();
            local12.putAll(httpheaders19);
            local11 = local12;
        } else
            local11 = null;

        HttpEntity input = tsorderotherserviceApi.postApiV1OrderotherserviceOrderotherTickets(local0, local11);
        Object local13 = input.getBody();
        Response<LeftTicketInfo> local14 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local13);
            local14 = mapper.readValue(bytes, new TypeReference<Response<LeftTicketInfo>>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local15 = input.getHeaders();
        HttpHeaders local16 = new HttpHeaders();
        local16.putAll(local15);
        ResponseEntity<Response<LeftTicketInfo>> output17 = new ResponseEntity<Response<LeftTicketInfo>>(local14, local16, HttpStatus.CREATED);
        return output17;
    }

    public ResponseEntity<Response<Config>> getApiV1ConfigserviceConfigsPathvariable(HttpHeaders httpheaders22) {
        String pathVar = "DirectTicketAllocationProportion";
        HttpHeaders local0;
        if (httpheaders22 != null) {
            HttpHeaders local1 = new HttpHeaders();
            local1.putAll(httpheaders22);
            local0 = local1;
        } else
            local0 = null;

        HttpEntity input = tsconfigserviceApi.getApiV1ConfigserviceConfigsPathvariable(pathVar, local0);
        Object local2 = input.getBody();
        Response<Config> local3 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local2);
            local3 = mapper.readValue(bytes, new TypeReference<Response<Config>>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local4 = input.getHeaders();
        HttpHeaders local5 = new HttpHeaders();
        local5.putAll(local4);
        ResponseEntity<Response<Config>> output6 = new ResponseEntity<Response<Config>>(local3, local5, HttpStatus.CREATED);
        return output6;
    }
}