package modules.tstravelplanservice;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.ArrayList;
import java.util.List;
import modules.tscommon.edu.fudan.common.entity.RoutePlanInfo;
import modules.tscommon.edu.fudan.common.entity.RoutePlanResultUnit;
import modules.tscommon.edu.fudan.common.entity.Seat;
import modules.tscommon.edu.fudan.common.entity.TripInfo;
import modules.tscommon.edu.fudan.common.entity.TripResponse;
import modules.tscommon.edu.fudan.common.util.Response;
import modules.tsrouteplanservice.TsrouteplanserviceApi;
import modules.tsseatservice.TsseatserviceApi;
import modules.tstrainservice.TstrainserviceApi;
import modules.tstravel2service.Tstravel2serviceApi;
import modules.tstravelservice.TstravelserviceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
@Component
public class TstravelplanserviceClient {
    @Autowired
    TstrainserviceApi tstrainserviceApi;

    @Autowired
    Tstravel2serviceApi tstravel2serviceApi;

    @Autowired
    TstravelserviceApi tstravelserviceApi;

    @Autowired
    TsrouteplanserviceApi tsrouteplanserviceApi;

    @Autowired
    TsseatserviceApi tsseatserviceApi;

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

    public ResponseEntity<Response<ArrayList<RoutePlanResultUnit>>> postApiV1RouteplanserviceRouteplanCheapestroute(RoutePlanInfo routeplaninfo18, HttpHeaders httpheaders19) {
        RoutePlanInfo local0;
        if (routeplaninfo18 != null) {
            RoutePlanInfo output1 = new RoutePlanInfo();
            String field2 = routeplaninfo18.getStartStation();
            output1.setStartStation(field2);
            String field3 = routeplaninfo18.getEndStation();
            output1.setEndStation(field3);
            String field4 = routeplaninfo18.getTravelDate();
            output1.setTravelDate(field4);
            int field5 = routeplaninfo18.getNum();
            output1.setNum(field5);
            local0 = output1;
        } else
            local0 = null;

        HttpHeaders local6;
        if (httpheaders19 != null) {
            HttpHeaders local7 = new HttpHeaders();
            local7.putAll(httpheaders19);
            local6 = local7;
        } else
            local6 = null;

        HttpEntity input = tsrouteplanserviceApi.postApiV1RouteplanserviceRouteplanCheapestroute(local0, local6);
        Object local8 = input.getBody();
        Response<ArrayList<RoutePlanResultUnit>> local9 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local8);
            local9 = mapper.readValue(bytes, new TypeReference<Response<ArrayList<RoutePlanResultUnit>>>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local10 = input.getHeaders();
        HttpHeaders local11 = new HttpHeaders();
        local11.putAll(local10);
        ResponseEntity<Response<ArrayList<RoutePlanResultUnit>>> output12 = new ResponseEntity<Response<ArrayList<RoutePlanResultUnit>>>(local9, local11, HttpStatus.CREATED);
        return output12;
    }

    public ResponseEntity<Response<ArrayList<RoutePlanResultUnit>>> postApiV1RouteplanserviceRouteplanQuickestroute(RoutePlanInfo routeplaninfo13, HttpHeaders httpheaders14) {
        RoutePlanInfo local0;
        if (routeplaninfo13 != null) {
            RoutePlanInfo output1 = new RoutePlanInfo();
            String field2 = routeplaninfo13.getStartStation();
            output1.setStartStation(field2);
            String field3 = routeplaninfo13.getEndStation();
            output1.setEndStation(field3);
            String field4 = routeplaninfo13.getTravelDate();
            output1.setTravelDate(field4);
            int field5 = routeplaninfo13.getNum();
            output1.setNum(field5);
            local0 = output1;
        } else
            local0 = null;

        HttpHeaders local6;
        if (httpheaders14 != null) {
            HttpHeaders local7 = new HttpHeaders();
            local7.putAll(httpheaders14);
            local6 = local7;
        } else
            local6 = null;

        HttpEntity input = tsrouteplanserviceApi.postApiV1RouteplanserviceRouteplanQuickestroute(local0, local6);
        Object local8 = input.getBody();
        Response<ArrayList<RoutePlanResultUnit>> local9 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local8);
            local9 = mapper.readValue(bytes, new TypeReference<Response<ArrayList<RoutePlanResultUnit>>>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local10 = input.getHeaders();
        HttpHeaders local11 = new HttpHeaders();
        local11.putAll(local10);
        ResponseEntity<Response<ArrayList<RoutePlanResultUnit>>> output12 = new ResponseEntity<Response<ArrayList<RoutePlanResultUnit>>>(local9, local11, HttpStatus.CREATED);
        return output12;
    }

    public ResponseEntity<Response<ArrayList<RoutePlanResultUnit>>> postApiV1RouteplanserviceRouteplanMinstopstations(RoutePlanInfo routeplaninfo13, HttpHeaders httpheaders14) {
        RoutePlanInfo local0;
        if (routeplaninfo13 != null) {
            RoutePlanInfo output1 = new RoutePlanInfo();
            String field2 = routeplaninfo13.getStartStation();
            output1.setStartStation(field2);
            String field3 = routeplaninfo13.getEndStation();
            output1.setEndStation(field3);
            String field4 = routeplaninfo13.getTravelDate();
            output1.setTravelDate(field4);
            int field5 = routeplaninfo13.getNum();
            output1.setNum(field5);
            local0 = output1;
        } else
            local0 = null;

        HttpHeaders local6;
        if (httpheaders14 != null) {
            HttpHeaders local7 = new HttpHeaders();
            local7.putAll(httpheaders14);
            local6 = local7;
        } else
            local6 = null;

        HttpEntity input = tsrouteplanserviceApi.postApiV1RouteplanserviceRouteplanMinstopstations(local0, local6);
        Object local8 = input.getBody();
        Response<ArrayList<RoutePlanResultUnit>> local9 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local8);
            local9 = mapper.readValue(bytes, new TypeReference<Response<ArrayList<RoutePlanResultUnit>>>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local10 = input.getHeaders();
        HttpHeaders local11 = new HttpHeaders();
        local11.putAll(local10);
        ResponseEntity<Response<ArrayList<RoutePlanResultUnit>>> output12 = new ResponseEntity<Response<ArrayList<RoutePlanResultUnit>>>(local9, local11, HttpStatus.CREATED);
        return output12;
    }

    public ResponseEntity<Response<List<TripResponse>>> postApiV1TravelserviceTripsLeft(TripInfo tripinfo13, HttpHeaders httpheaders14) {
        TripInfo local0;
        if (tripinfo13 != null) {
            TripInfo output1 = new TripInfo();
            String field2 = tripinfo13.getStartPlace();
            output1.setStartPlace(field2);
            String field3 = tripinfo13.getEndPlace();
            output1.setEndPlace(field3);
            String field4 = tripinfo13.getDepartureTime();
            output1.setDepartureTime(field4);
            local0 = output1;
        } else
            local0 = null;

        HttpHeaders local5;
        if (httpheaders14 != null) {
            HttpHeaders local6 = new HttpHeaders();
            local6.putAll(httpheaders14);
            local5 = local6;
        } else
            local5 = null;

        HttpEntity input = tstravelserviceApi.postApiV1TravelserviceTripsLeft(local0, local5);
        Object local7 = input.getBody();
        Response<List<TripResponse>> local8 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local7);
            local8 = mapper.readValue(bytes, new TypeReference<Response<List<TripResponse>>>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local9 = input.getHeaders();
        HttpHeaders local10 = new HttpHeaders();
        local10.putAll(local9);
        ResponseEntity<Response<List<TripResponse>>> output11 = new ResponseEntity<Response<List<TripResponse>>>(local8, local10, HttpStatus.CREATED);
        return output11;
    }

    public ResponseEntity<Response<ArrayList<TripResponse>>> postApiV1Travel2serviceTripsLeft(TripInfo tripinfo12, HttpHeaders httpheaders13) {
        TripInfo local0;
        if (tripinfo12 != null) {
            TripInfo output1 = new TripInfo();
            String field2 = tripinfo12.getStartPlace();
            output1.setStartPlace(field2);
            String field3 = tripinfo12.getEndPlace();
            output1.setEndPlace(field3);
            String field4 = tripinfo12.getDepartureTime();
            output1.setDepartureTime(field4);
            local0 = output1;
        } else
            local0 = null;

        HttpHeaders local5;
        if (httpheaders13 != null) {
            HttpHeaders local6 = new HttpHeaders();
            local6.putAll(httpheaders13);
            local5 = local6;
        } else
            local5 = null;

        HttpEntity input = tstravel2serviceApi.postApiV1Travel2serviceTripsLeft(local0, local5);
        Object local7 = input.getBody();
        Response<ArrayList<TripResponse>> local8 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local7);
            local8 = mapper.readValue(bytes, new TypeReference<Response<ArrayList<TripResponse>>>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local9 = input.getHeaders();
        HttpHeaders local10 = new HttpHeaders();
        local10.putAll(local9);
        ResponseEntity<Response<ArrayList<TripResponse>>> output11 = new ResponseEntity<Response<ArrayList<TripResponse>>>(local8, local10, HttpStatus.CREATED);
        return output11;
    }

    public ResponseEntity<Response> getApiV1TrainserviceTrainsBynamePathvariable(String string12, HttpHeaders httpheaders13) {
        String local0;
        if (string12 != null) {
            local0 = string12;
        } else
            local0 = null;

        HttpHeaders local1;
        if (httpheaders13 != null) {
            HttpHeaders local2 = new HttpHeaders();
            local2.putAll(httpheaders13);
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
}