package modules.tsrouteplanservice;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.ArrayList;
import modules.tscommon.edu.fudan.common.entity.Route;
import modules.tscommon.edu.fudan.common.entity.Trip;
import modules.tscommon.edu.fudan.common.entity.TripAllDetail;
import modules.tscommon.edu.fudan.common.entity.TripAllDetailInfo;
import modules.tscommon.edu.fudan.common.entity.TripInfo;
import modules.tscommon.edu.fudan.common.entity.TripResponse;
import modules.tscommon.edu.fudan.common.util.Response;
import modules.tsrouteservice.TsrouteserviceApi;
import modules.tstravel2service.Tstravel2serviceApi;
import modules.tstravelservice.TstravelserviceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
@Component
public class TsrouteplanserviceClient {
    @Autowired
    Tstravel2serviceApi tstravel2serviceApi;

    @Autowired
    TstravelserviceApi tstravelserviceApi;

    @Autowired
    TsrouteserviceApi tsrouteserviceApi;

    public ResponseEntity<Response<ArrayList<Route>>> getApiV1RouteserviceRoutesPathvariablePathvariable(String string8, String string9, HttpHeaders httpheaders10) {
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

        HttpEntity input = tsrouteserviceApi.getApiV1RouteserviceRoutesPathvariablePathvariable(local0, local1, local2);
        Object local4 = input.getBody();
        Response<ArrayList<Route>> local5 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local4);
            local5 = mapper.readValue(bytes, new TypeReference<Response<ArrayList<Route>>>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local6 = input.getHeaders();
        HttpHeaders local7 = new HttpHeaders();
        local7.putAll(local6);
        ResponseEntity<Response<ArrayList<Route>>> output8 = new ResponseEntity<Response<ArrayList<Route>>>(local5, local7, HttpStatus.CREATED);
        return output8;
    }

    public ResponseEntity<Response<ArrayList<ArrayList<Trip>>>> postApiV1TravelserviceTripsRoutes(ArrayList<String> arraylist9, HttpHeaders httpheaders10) {
        ArrayList<String> local0;
        if (arraylist9 != null) {
            ArrayList<String> output1 = new ArrayList<String>();
            for (String listType2 : arraylist9) {
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

        HttpEntity input = tstravelserviceApi.postApiV1TravelserviceTripsRoutes(local0, local3);
        Object local5 = input.getBody();
        Response<ArrayList<ArrayList<Trip>>> local6 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local5);
            local6 = mapper.readValue(bytes, new TypeReference<Response<ArrayList<ArrayList<Trip>>>>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local7 = input.getHeaders();
        HttpHeaders local8 = new HttpHeaders();
        local8.putAll(local7);
        ResponseEntity<Response<ArrayList<ArrayList<Trip>>>> output9 = new ResponseEntity<Response<ArrayList<ArrayList<Trip>>>>(local6, local8, HttpStatus.CREATED);
        return output9;
    }

    public ResponseEntity<Response<ArrayList<ArrayList<Trip>>>> postApiV1Travel2serviceTripsRoutes(ArrayList<String> arraylist10, HttpHeaders httpheaders11) {
        ArrayList<String> local0;
        if (arraylist10 != null) {
            ArrayList<String> output1 = new ArrayList<String>();
            for (String listType2 : arraylist10) {
                output1.add(listType2);
            }
            local0 = output1;
        } else
            local0 = null;

        HttpHeaders local3;
        if (httpheaders11 != null) {
            HttpHeaders local4 = new HttpHeaders();
            local4.putAll(httpheaders11);
            local3 = local4;
        } else
            local3 = null;

        HttpEntity input = tstravel2serviceApi.postApiV1Travel2serviceTripsRoutes(local0, local3);
        Object local5 = input.getBody();
        Response<ArrayList<ArrayList<Trip>>> local6 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local5);
            local6 = mapper.readValue(bytes, new TypeReference<Response<ArrayList<ArrayList<Trip>>>>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local7 = input.getHeaders();
        HttpHeaders local8 = new HttpHeaders();
        local8.putAll(local7);
        ResponseEntity<Response<ArrayList<ArrayList<Trip>>>> output9 = new ResponseEntity<Response<ArrayList<ArrayList<Trip>>>>(local6, local8, HttpStatus.CREATED);
        return output9;
    }

    public ResponseEntity<Response<TripAllDetail>> postApiV1Travel2serviceTrip_detail(TripAllDetailInfo tripalldetailinfo10, HttpHeaders httpheaders11) {
        TripAllDetailInfo local0;
        if (tripalldetailinfo10 != null) {
            TripAllDetailInfo output1 = new TripAllDetailInfo();
            String field2 = tripalldetailinfo10.getTripId();
            output1.setTripId(field2);
            String field3 = tripalldetailinfo10.getTravelDate();
            output1.setTravelDate(field3);
            String field4 = tripalldetailinfo10.getFrom();
            output1.setFrom(field4);
            String field5 = tripalldetailinfo10.getTo();
            output1.setTo(field5);
            local0 = output1;
        } else
            local0 = null;

        HttpHeaders local6;
        if (httpheaders11 != null) {
            HttpHeaders local7 = new HttpHeaders();
            local7.putAll(httpheaders11);
            local6 = local7;
        } else
            local6 = null;

        HttpEntity input = tstravel2serviceApi.postApiV1Travel2serviceTrip_detail(local0, local6);
        Object local8 = input.getBody();
        Response<TripAllDetail> local9 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local8);
            local9 = mapper.readValue(bytes, new TypeReference<Response<TripAllDetail>>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local10 = input.getHeaders();
        HttpHeaders local11 = new HttpHeaders();
        local11.putAll(local10);
        ResponseEntity<Response<TripAllDetail>> output12 = new ResponseEntity<Response<TripAllDetail>>(local9, local11, HttpStatus.CREATED);
        return output12;
    }

    public ResponseEntity<Response<TripAllDetail>> postApiV1TravelserviceTrip_detail(TripAllDetailInfo tripalldetailinfo13, HttpHeaders httpheaders14) {
        TripAllDetailInfo local0;
        if (tripalldetailinfo13 != null) {
            TripAllDetailInfo output1 = new TripAllDetailInfo();
            String field2 = tripalldetailinfo13.getTripId();
            output1.setTripId(field2);
            String field3 = tripalldetailinfo13.getTravelDate();
            output1.setTravelDate(field3);
            String field4 = tripalldetailinfo13.getFrom();
            output1.setFrom(field4);
            String field5 = tripalldetailinfo13.getTo();
            output1.setTo(field5);
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

        HttpEntity input = tstravelserviceApi.postApiV1TravelserviceTrip_detail(local0, local6);
        Object local8 = input.getBody();
        Response<TripAllDetail> local9 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local8);
            local9 = mapper.readValue(bytes, new TypeReference<Response<TripAllDetail>>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local10 = input.getHeaders();
        HttpHeaders local11 = new HttpHeaders();
        local11.putAll(local10);
        ResponseEntity<Response<TripAllDetail>> output12 = new ResponseEntity<Response<TripAllDetail>>(local9, local11, HttpStatus.CREATED);
        return output12;
    }

    public ResponseEntity<Response<Route>> getApiV1RouteserviceRoutesPathvariable(String string13, HttpHeaders httpheaders14) {
        String local0;
        if (string13 != null) {
            local0 = string13;
        } else
            local0 = null;

        HttpHeaders local1;
        if (httpheaders14 != null) {
            HttpHeaders local2 = new HttpHeaders();
            local2.putAll(httpheaders14);
            local1 = local2;
        } else
            local1 = null;

        HttpEntity input = tsrouteserviceApi.getApiV1RouteserviceRoutesPathvariable(local0, local1);
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

    public ResponseEntity<Response<ArrayList<TripResponse>>> postApiV1TravelserviceTripsLeft(TripInfo tripinfo8, HttpHeaders httpheaders9) {
        TripInfo local0;
        if (tripinfo8 != null) {
            TripInfo output1 = new TripInfo();
            String field2 = tripinfo8.getStartPlace();
            output1.setStartPlace(field2);
            String field3 = tripinfo8.getEndPlace();
            output1.setEndPlace(field3);
            String field4 = tripinfo8.getDepartureTime();
            output1.setDepartureTime(field4);
            local0 = output1;
        } else
            local0 = null;

        HttpHeaders local5;
        if (httpheaders9 != null) {
            HttpHeaders local6 = new HttpHeaders();
            local6.putAll(httpheaders9);
            local5 = local6;
        } else
            local5 = null;

        HttpEntity input = tstravelserviceApi.postApiV1TravelserviceTripsLeft(local0, local5);
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

    public ResponseEntity<Response<Route>> getApiV1Travel2serviceRoutesPathvariable(String string12, HttpHeaders httpheaders13) {
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

        HttpEntity input = tstravel2serviceApi.getApiV1Travel2serviceRoutesPathvariable(local0, local1);
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
}