package modules.tstravel2service;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.ArrayList;
import java.util.List;
import modules.tsbasicservice.TsbasicserviceApi;
import modules.tscommon.edu.fudan.common.entity.Seat;
import modules.tscommon.edu.fudan.common.entity.TrainType;
import modules.tscommon.edu.fudan.common.entity.TravelResult;
import modules.tscommon.edu.fudan.common.entity.Trip;
import modules.tscommon.edu.fudan.common.entity.TripId;
import modules.tscommon.edu.fudan.common.entity.Type;
import modules.tscommon.edu.fudan.common.util.Response;
import modules.tsrouteservice.TsrouteserviceApi;
import modules.tsseatservice.TsseatserviceApi;
import modules.tstrainservice.TstrainserviceApi;
import modules.tstravel2service.travel2.entity.Travel;
import modules.tstravel2service.travel2.entity.TripFromtstravel2service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
@Component
public class Tstravel2serviceClient {
    @Autowired
    TsseatserviceApi tsseatserviceApi;

    @Autowired
    TsrouteserviceApi tsrouteserviceApi;

    @Autowired
    TstrainserviceApi tstrainserviceApi;

    @Autowired
    TsbasicserviceApi tsbasicserviceApi;

    public ResponseEntity<Response> postApiV1BasicserviceBasicTravels(List<Travel> list18, HttpHeaders httpheaders19) {
        List<modules.tscommon.edu.fudan.common.entity.Travel> local0;
        if (list18 != null) {
            ArrayList<modules.tscommon.edu.fudan.common.entity.Travel> output1 = new ArrayList<modules.tscommon.edu.fudan.common.entity.Travel>();
            for (Travel listType2 : list18) {
                modules.tscommon.edu.fudan.common.entity.Travel output3 = new modules.tscommon.edu.fudan.common.entity.Travel();
                TripFromtstravel2service field4 = listType2.getTrip();
                Trip output5 = new Trip();
                String field6 = field4.getId();
                output5.setId(field6);
                TripId field7 = field4.getTripId();
                TripId output8 = new TripId();
                Type field9 = field7.getType();
                output8.setType(field9);
                String field10 = field7.getNumber();
                output8.setNumber(field10);
                output5.setTripId(output8);
                String field11 = field4.getTrainTypeName();
                output5.setTrainTypeName(field11);
                String field12 = field4.getRouteId();
                output5.setRouteId(field12);
                String field13 = field4.getStartStationName();
                output5.setStartStationName(field13);
                String field14 = field4.getStationsName();
                output5.setStationsName(field14);
                String field15 = field4.getTerminalStationName();
                output5.setTerminalStationName(field15);
                String field16 = field4.getStartTime();
                output5.setStartTime(field16);
                String field17 = field4.getEndTime();
                output5.setEndTime(field17);
                output3.setTrip(output5);
                String field18 = listType2.getStartPlace();
                output3.setStartPlace(field18);
                String field19 = listType2.getEndPlace();
                output3.setEndPlace(field19);
                String field20 = listType2.getDepartureTime();
                output3.setDepartureTime(field20);
                output1.add(output3);
            }
            local0 = output1;
        } else
            local0 = null;

        HttpHeaders local21;
        if (httpheaders19 != null) {
            HttpHeaders local22 = new HttpHeaders();
            local22.putAll(httpheaders19);
            local21 = local22;
        } else
            local21 = null;

        HttpEntity input = tsbasicserviceApi.postApiV1BasicserviceBasicTravels(local0, local21);
        Object local23 = input.getBody();
        Response local24 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local23);
            local24 = mapper.readValue(bytes, new TypeReference<Response>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local25 = input.getHeaders();
        HttpHeaders local26 = new HttpHeaders();
        local26.putAll(local25);
        ResponseEntity<Response> output27 = new ResponseEntity<Response>(local24, local26, HttpStatus.CREATED);
        return output27;
    }

    public ResponseEntity<Response<TravelResult>> postApiV1BasicserviceBasicTravel(Travel travel28, HttpHeaders httpheaders29) {
        modules.tscommon.edu.fudan.common.entity.Travel local0;
        if (travel28 != null) {
            modules.tscommon.edu.fudan.common.entity.Travel output1 = new modules.tscommon.edu.fudan.common.entity.Travel();
            TripFromtstravel2service field2 = travel28.getTrip();
            Trip output3 = new Trip();
            String field4 = field2.getId();
            output3.setId(field4);
            TripId field5 = field2.getTripId();
            TripId output6 = new TripId();
            Type field7 = field5.getType();
            output6.setType(field7);
            String field8 = field5.getNumber();
            output6.setNumber(field8);
            output3.setTripId(output6);
            String field9 = field2.getTrainTypeName();
            output3.setTrainTypeName(field9);
            String field10 = field2.getRouteId();
            output3.setRouteId(field10);
            String field11 = field2.getStartStationName();
            output3.setStartStationName(field11);
            String field12 = field2.getStationsName();
            output3.setStationsName(field12);
            String field13 = field2.getTerminalStationName();
            output3.setTerminalStationName(field13);
            String field14 = field2.getStartTime();
            output3.setStartTime(field14);
            String field15 = field2.getEndTime();
            output3.setEndTime(field15);
            output1.setTrip(output3);
            String field16 = travel28.getStartPlace();
            output1.setStartPlace(field16);
            String field17 = travel28.getEndPlace();
            output1.setEndPlace(field17);
            String field18 = travel28.getDepartureTime();
            output1.setDepartureTime(field18);
            local0 = output1;
        } else
            local0 = null;

        HttpHeaders local19;
        if (httpheaders29 != null) {
            HttpHeaders local20 = new HttpHeaders();
            local20.putAll(httpheaders29);
            local19 = local20;
        } else
            local19 = null;

        HttpEntity input = tsbasicserviceApi.postApiV1BasicserviceBasicTravel(local0, local19);
        Object local21 = input.getBody();
        Response<TravelResult> local22 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local21);
            local22 = mapper.readValue(bytes, new TypeReference<Response<TravelResult>>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local23 = input.getHeaders();
        HttpHeaders local24 = new HttpHeaders();
        local24.putAll(local23);
        ResponseEntity<Response<TravelResult>> output25 = new ResponseEntity<Response<TravelResult>>(local22, local24, HttpStatus.CREATED);
        return output25;
    }

    public ResponseEntity<Response<TrainType>> getApiV1TrainserviceTrainsBynamePathvariable(String string26, HttpHeaders httpheaders27) {
        String local0;
        if (string26 != null) {
            local0 = string26;
        } else
            local0 = null;

        HttpHeaders local1;
        if (httpheaders27 != null) {
            HttpHeaders local2 = new HttpHeaders();
            local2.putAll(httpheaders27);
            local1 = local2;
        } else
            local1 = null;

        HttpEntity input = tstrainserviceApi.getApiV1TrainserviceTrainsBynamePathvariable(local0, local1);
        Object local3 = input.getBody();
        Response<TrainType> local4 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local3);
            local4 = mapper.readValue(bytes, new TypeReference<Response<TrainType>>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local5 = input.getHeaders();
        HttpHeaders local6 = new HttpHeaders();
        local6.putAll(local5);
        ResponseEntity<Response<TrainType>> output7 = new ResponseEntity<Response<TrainType>>(local4, local6, HttpStatus.CREATED);
        return output7;
    }

    public ResponseEntity<Response> getApiV1RouteserviceRoutesPathvariable(String string8, HttpHeaders httpheaders9) {
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

    public ResponseEntity<Response<Integer>> postApiV1SeatserviceSeatsLeft_tickets(Seat seat8, HttpHeaders httpheaders9) {
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

        HttpEntity input = tsseatserviceApi.postApiV1SeatserviceSeatsLeft_tickets(local0, local11);
        Object local13 = input.getBody();
        Response<Integer> local14 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local13);
            local14 = mapper.readValue(bytes, new TypeReference<Response<Integer>>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local15 = input.getHeaders();
        HttpHeaders local16 = new HttpHeaders();
        local16.putAll(local15);
        ResponseEntity<Response<Integer>> output17 = new ResponseEntity<Response<Integer>>(local14, local16, HttpStatus.CREATED);
        return output17;
    }
}