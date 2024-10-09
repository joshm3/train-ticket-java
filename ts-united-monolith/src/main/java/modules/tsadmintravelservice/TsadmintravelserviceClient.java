package modules.tsadmintravelservice;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.ArrayList;
import java.util.List;
import modules.tscommon.edu.fudan.common.entity.AdminTrip;
import modules.tscommon.edu.fudan.common.entity.TravelInfo;
import modules.tscommon.edu.fudan.common.util.Response;
import modules.tsrouteservice.TsrouteserviceApi;
import modules.tsstationservice.TsstationserviceApi;
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
public class TsadmintravelserviceClient {
    @Autowired
    TsrouteserviceApi tsrouteserviceApi;

    @Autowired
    TstrainserviceApi tstrainserviceApi;

    @Autowired
    TsstationserviceApi tsstationserviceApi;

    @Autowired
    Tstravel2serviceApi tstravel2serviceApi;

    @Autowired
    TstravelserviceApi tstravelserviceApi;

    public ResponseEntity<Response<ArrayList<AdminTrip>>> getApiV1TravelserviceAdmin_trip(HttpHeaders httpheaders18) {
        HttpHeaders local0;
        if (httpheaders18 != null) {
            HttpHeaders local1 = new HttpHeaders();
            local1.putAll(httpheaders18);
            local0 = local1;
        } else
            local0 = null;

        HttpEntity input = tstravelserviceApi.getApiV1TravelserviceAdmin_trip(local0);
        Object local2 = input.getBody();
        Response<ArrayList<AdminTrip>> local3 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local2);
            local3 = mapper.readValue(bytes, new TypeReference<Response<ArrayList<AdminTrip>>>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local4 = input.getHeaders();
        HttpHeaders local5 = new HttpHeaders();
        local5.putAll(local4);
        ResponseEntity<Response<ArrayList<AdminTrip>>> output6 = new ResponseEntity<Response<ArrayList<AdminTrip>>>(local3, local5, HttpStatus.CREATED);
        return output6;
    }

    public ResponseEntity<Response<ArrayList<AdminTrip>>> getApiV1Travel2serviceAdmin_trip(HttpHeaders httpheaders7) {
        HttpHeaders local0;
        if (httpheaders7 != null) {
            HttpHeaders local1 = new HttpHeaders();
            local1.putAll(httpheaders7);
            local0 = local1;
        } else
            local0 = null;

        HttpEntity input = tstravel2serviceApi.getApiV1Travel2serviceAdmin_trip(local0);
        Object local2 = input.getBody();
        Response<ArrayList<AdminTrip>> local3 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local2);
            local3 = mapper.readValue(bytes, new TypeReference<Response<ArrayList<AdminTrip>>>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local4 = input.getHeaders();
        HttpHeaders local5 = new HttpHeaders();
        local5.putAll(local4);
        ResponseEntity<Response<ArrayList<AdminTrip>>> output6 = new ResponseEntity<Response<ArrayList<AdminTrip>>>(local3, local5, HttpStatus.CREATED);
        return output6;
    }

    public ResponseEntity<Response> postApiV1Travel2serviceTrips(TravelInfo travelinfo7, HttpHeaders httpheaders8) {
        TravelInfo local0;
        if (travelinfo7 != null) {
            TravelInfo output1 = new TravelInfo();
            String field2 = travelinfo7.getLoginId();
            output1.setLoginId(field2);
            String field3 = travelinfo7.getTripId();
            output1.setTripId(field3);
            String field4 = travelinfo7.getTrainTypeName();
            output1.setTrainTypeName(field4);
            String field5 = travelinfo7.getRouteId();
            output1.setRouteId(field5);
            String field6 = travelinfo7.getStartStationName();
            output1.setStartStationName(field6);
            String field7 = travelinfo7.getStationsName();
            output1.setStationsName(field7);
            String field8 = travelinfo7.getTerminalStationName();
            output1.setTerminalStationName(field8);
            String field9 = travelinfo7.getStartTime();
            output1.setStartTime(field9);
            String field10 = travelinfo7.getEndTime();
            output1.setEndTime(field10);
            local0 = output1;
        } else
            local0 = null;

        HttpHeaders local11;
        if (httpheaders8 != null) {
            HttpHeaders local12 = new HttpHeaders();
            local12.putAll(httpheaders8);
            local11 = local12;
        } else
            local11 = null;

        HttpEntity<?> input = tstravel2serviceApi.postApiV1Travel2serviceTrips(local0, local11);
        Object local13 = input.getBody();
        Response local14 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local13);
            local14 = mapper.readValue(bytes, new TypeReference<Response>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local15 = input.getHeaders();
        HttpHeaders local16 = new HttpHeaders();
        local16.putAll(local15);
        ResponseEntity<Response> output17 = new ResponseEntity<Response>(local14, local16, HttpStatus.CREATED);
        return output17;
    }

    public ResponseEntity<Response> postApiV1TravelserviceTrips(TravelInfo travelinfo18, HttpHeaders httpheaders19) {
        TravelInfo local0;
        if (travelinfo18 != null) {
            TravelInfo output1 = new TravelInfo();
            String field2 = travelinfo18.getLoginId();
            output1.setLoginId(field2);
            String field3 = travelinfo18.getTripId();
            output1.setTripId(field3);
            String field4 = travelinfo18.getTrainTypeName();
            output1.setTrainTypeName(field4);
            String field5 = travelinfo18.getRouteId();
            output1.setRouteId(field5);
            String field6 = travelinfo18.getStartStationName();
            output1.setStartStationName(field6);
            String field7 = travelinfo18.getStationsName();
            output1.setStationsName(field7);
            String field8 = travelinfo18.getTerminalStationName();
            output1.setTerminalStationName(field8);
            String field9 = travelinfo18.getStartTime();
            output1.setStartTime(field9);
            String field10 = travelinfo18.getEndTime();
            output1.setEndTime(field10);
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

        HttpEntity<?> input = tstravelserviceApi.postApiV1TravelserviceTrips(local0, local11);
        Object local13 = input.getBody();
        Response local14 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local13);
            local14 = mapper.readValue(bytes, new TypeReference<Response>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local15 = input.getHeaders();
        HttpHeaders local16 = new HttpHeaders();
        local16.putAll(local15);
        ResponseEntity<Response> output17 = new ResponseEntity<Response>(local14, local16, HttpStatus.CREATED);
        return output17;
    }

    public ResponseEntity<Response> putApiV1Travel2serviceTrips(TravelInfo travelinfo18, HttpHeaders httpheaders19) {
        TravelInfo local0;
        if (travelinfo18 != null) {
            TravelInfo output1 = new TravelInfo();
            String field2 = travelinfo18.getLoginId();
            output1.setLoginId(field2);
            String field3 = travelinfo18.getTripId();
            output1.setTripId(field3);
            String field4 = travelinfo18.getTrainTypeName();
            output1.setTrainTypeName(field4);
            String field5 = travelinfo18.getRouteId();
            output1.setRouteId(field5);
            String field6 = travelinfo18.getStartStationName();
            output1.setStartStationName(field6);
            String field7 = travelinfo18.getStationsName();
            output1.setStationsName(field7);
            String field8 = travelinfo18.getTerminalStationName();
            output1.setTerminalStationName(field8);
            String field9 = travelinfo18.getStartTime();
            output1.setStartTime(field9);
            String field10 = travelinfo18.getEndTime();
            output1.setEndTime(field10);
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

        HttpEntity input = tstravel2serviceApi.putApiV1Travel2serviceTrips(local0, local11);
        Object local13 = input.getBody();
        Response local14 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local13);
            local14 = mapper.readValue(bytes, new TypeReference<Response>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local15 = input.getHeaders();
        HttpHeaders local16 = new HttpHeaders();
        local16.putAll(local15);
        ResponseEntity<Response> output17 = new ResponseEntity<Response>(local14, local16, HttpStatus.CREATED);
        return output17;
    }

    public ResponseEntity<Response> putApiV1TravelserviceTrips(TravelInfo travelinfo18, HttpHeaders httpheaders19) {
        TravelInfo local0;
        if (travelinfo18 != null) {
            TravelInfo output1 = new TravelInfo();
            String field2 = travelinfo18.getLoginId();
            output1.setLoginId(field2);
            String field3 = travelinfo18.getTripId();
            output1.setTripId(field3);
            String field4 = travelinfo18.getTrainTypeName();
            output1.setTrainTypeName(field4);
            String field5 = travelinfo18.getRouteId();
            output1.setRouteId(field5);
            String field6 = travelinfo18.getStartStationName();
            output1.setStartStationName(field6);
            String field7 = travelinfo18.getStationsName();
            output1.setStationsName(field7);
            String field8 = travelinfo18.getTerminalStationName();
            output1.setTerminalStationName(field8);
            String field9 = travelinfo18.getStartTime();
            output1.setStartTime(field9);
            String field10 = travelinfo18.getEndTime();
            output1.setEndTime(field10);
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

        HttpEntity input = tstravelserviceApi.putApiV1TravelserviceTrips(local0, local11);
        Object local13 = input.getBody();
        Response local14 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local13);
            local14 = mapper.readValue(bytes, new TypeReference<Response>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local15 = input.getHeaders();
        HttpHeaders local16 = new HttpHeaders();
        local16.putAll(local15);
        ResponseEntity<Response> output17 = new ResponseEntity<Response>(local14, local16, HttpStatus.CREATED);
        return output17;
    }

    public ResponseEntity<Response> deleteApiV1Travel2serviceTripsPathvariable(String string18, HttpHeaders httpheaders19) {
        String local0;
        if (string18 != null) {
            local0 = string18;
        } else
            local0 = null;

        HttpHeaders local1;
        if (httpheaders19 != null) {
            HttpHeaders local2 = new HttpHeaders();
            local2.putAll(httpheaders19);
            local1 = local2;
        } else
            local1 = null;

        HttpEntity input = tstravel2serviceApi.deleteApiV1Travel2serviceTripsPathvariable(local0, local1);
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

    public ResponseEntity<Response> deleteApiV1TravelserviceTripsPathvariable(String string8, HttpHeaders httpheaders9) {
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

        HttpEntity input = tstravelserviceApi.deleteApiV1TravelserviceTripsPathvariable(local0, local1);
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
}