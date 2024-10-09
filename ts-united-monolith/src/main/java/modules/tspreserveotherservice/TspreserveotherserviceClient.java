package modules.tspreserveotherservice;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.ArrayList;
import java.util.List;
import modules.tsassuranceservice.TsassuranceserviceApi;
import modules.tsbasicservice.TsbasicserviceApi;
import modules.tscommon.edu.fudan.common.entity.Assurance;
import modules.tscommon.edu.fudan.common.entity.Consign;
import modules.tscommon.edu.fudan.common.entity.Contacts;
import modules.tscommon.edu.fudan.common.entity.FoodOrder;
import modules.tscommon.edu.fudan.common.entity.Order;
import modules.tscommon.edu.fudan.common.entity.Seat;
import modules.tscommon.edu.fudan.common.entity.Ticket;
import modules.tscommon.edu.fudan.common.entity.Travel;
import modules.tscommon.edu.fudan.common.entity.TravelResult;
import modules.tscommon.edu.fudan.common.entity.Trip;
import modules.tscommon.edu.fudan.common.entity.TripAllDetail;
import modules.tscommon.edu.fudan.common.entity.TripAllDetailInfo;
import modules.tscommon.edu.fudan.common.entity.TripId;
import modules.tscommon.edu.fudan.common.entity.Type;
import modules.tscommon.edu.fudan.common.entity.User;
import modules.tscommon.edu.fudan.common.util.Response;
import modules.tsconsignservice.TsconsignserviceApi;
import modules.tscontactsservice.TscontactsserviceApi;
import modules.tsfoodservice.TsfoodserviceApi;
import modules.tsorderotherservice.TsorderotherserviceApi;
import modules.tsorderotherservice.other.entity.OrderFromtsorderotherservice;
import modules.tsseatservice.TsseatserviceApi;
import modules.tssecurityservice.TssecurityserviceApi;
import modules.tsstationservice.TsstationserviceApi;
import modules.tstravel2service.Tstravel2serviceApi;
import modules.tsuserservice.TsuserserviceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
@Component
public class TspreserveotherserviceClient {
    @Autowired
    TsconsignserviceApi tsconsignserviceApi;

    @Autowired
    TsfoodserviceApi tsfoodserviceApi;

    @Autowired
    TsorderotherserviceApi tsorderotherserviceApi;

    @Autowired
    TscontactsserviceApi tscontactsserviceApi;

    @Autowired
    Tstravel2serviceApi tstravel2serviceApi;

    @Autowired
    TssecurityserviceApi tssecurityserviceApi;

    @Autowired
    TsstationserviceApi tsstationserviceApi;

    @Autowired
    TsassuranceserviceApi tsassuranceserviceApi;

    @Autowired
    TsuserserviceApi tsuserserviceApi;

    @Autowired
    TsseatserviceApi tsseatserviceApi;

    @Autowired
    TsbasicserviceApi tsbasicserviceApi;

    public ResponseEntity<Response<TravelResult>> postApiV1BasicserviceBasicTravel(Travel travel20, HttpHeaders httpheaders21) {
        Travel local0;
        if (travel20 != null) {
            Travel output1 = new Travel();
            Trip field2 = travel20.getTrip();
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
            String field16 = travel20.getStartPlace();
            output1.setStartPlace(field16);
            String field17 = travel20.getEndPlace();
            output1.setEndPlace(field17);
            String field18 = travel20.getDepartureTime();
            output1.setDepartureTime(field18);
            local0 = output1;
        } else
            local0 = null;

        HttpHeaders local19;
        if (httpheaders21 != null) {
            HttpHeaders local20 = new HttpHeaders();
            local20.putAll(httpheaders21);
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

    public ResponseEntity<Response<Ticket>> postApiV1SeatserviceSeats(Seat seat26, HttpHeaders httpheaders27) {
        Seat local0;
        if (seat26 != null) {
            Seat output1 = new Seat();
            String field2 = seat26.getTravelDate();
            output1.setTravelDate(field2);
            String field3 = seat26.getTrainNumber();
            output1.setTrainNumber(field3);
            String field4 = seat26.getStartStation();
            output1.setStartStation(field4);
            String field5 = seat26.getDestStation();
            output1.setDestStation(field5);
            int field6 = seat26.getSeatType();
            output1.setSeatType(field6);
            int field7 = seat26.getTotalNum();
            output1.setTotalNum(field7);
            List<String> field8 = seat26.getStations();
            ArrayList<String> output9 = new ArrayList<String>();
            for (String listType10 : field8) {
                output9.add(listType10);
            }
            output1.setStations(output9);
            local0 = output1;
        } else
            local0 = null;

        HttpHeaders local11;
        if (httpheaders27 != null) {
            HttpHeaders local12 = new HttpHeaders();
            local12.putAll(httpheaders27);
            local11 = local12;
        } else
            local11 = null;

        HttpEntity input = tsseatserviceApi.postApiV1SeatserviceSeats(local0, local11);
        Object local13 = input.getBody();
        Response<Ticket> local14 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local13);
            local14 = mapper.readValue(bytes, new TypeReference<Response<Ticket>>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local15 = input.getHeaders();
        HttpHeaders local16 = new HttpHeaders();
        local16.putAll(local15);
        ResponseEntity<Response<Ticket>> output17 = new ResponseEntity<Response<Ticket>>(local14, local16, HttpStatus.CREATED);
        return output17;
    }

    public ResponseEntity<Response<User>> getApiV1UserserviceUsersIdPathvariable(String string18, HttpHeaders httpheaders19) {
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

        ResponseEntity<Response> input = tsuserserviceApi.getApiV1UserserviceUsersIdPathvariable(local0, local1);
        Object local3 = input.getBody();
        Response<User> local4 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local3);
            local4 = mapper.readValue(bytes, new TypeReference<Response<User>>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local5 = input.getHeaders();
        HttpHeaders local6 = new HttpHeaders();
        local6.putAll(local5);
        ResponseEntity<Response<User>> output7 = new ResponseEntity<Response<User>>(local4, local6, input.getStatusCode());
        return output7;
    }

    public ResponseEntity<Response<Assurance>> getApiV1AssuranceserviceAssurancesPathvariablePathvariable(int int8, String string9, HttpHeaders httpheaders10) {
        int local0;
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

        HttpEntity input = tsassuranceserviceApi.getApiV1AssuranceserviceAssurancesPathvariablePathvariable(int8, local1, local2);
        Object local4 = input.getBody();
        Response<Assurance> local5 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local4);
            local5 = mapper.readValue(bytes, new TypeReference<Response<Assurance>>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local6 = input.getHeaders();
        HttpHeaders local7 = new HttpHeaders();
        local7.putAll(local6);
        ResponseEntity<Response<Assurance>> output8 = new ResponseEntity<Response<Assurance>>(local5, local7, HttpStatus.CREATED);
        return output8;
    }

    public ResponseEntity<Response<String>> getApiV1StationserviceStationsIdPathvariable(String string9, HttpHeaders httpheaders10) {
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

        HttpEntity input = tsstationserviceApi.getApiV1StationserviceStationsIdPathvariable(local0, local1);
        Object local3 = input.getBody();
        Response<String> local4 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local3);
            local4 = mapper.readValue(bytes, new TypeReference<Response<String>>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local5 = input.getHeaders();
        HttpHeaders local6 = new HttpHeaders();
        local6.putAll(local5);
        ResponseEntity<Response<String>> output7 = new ResponseEntity<Response<String>>(local4, local6, HttpStatus.CREATED);
        return output7;
    }

    public ResponseEntity<Response> getApiV1SecurityserviceSecurityconfigsPathvariable(String string8, HttpHeaders httpheaders9) {
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

        HttpEntity input = tssecurityserviceApi.getApiV1SecurityserviceSecurityconfigsPathvariable(local0, local1);
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

    public ResponseEntity<Response<TripAllDetail>> postApiV1Travel2serviceTrip_detail(TripAllDetailInfo tripalldetailinfo8, HttpHeaders httpheaders9) {
        TripAllDetailInfo local0;
        if (tripalldetailinfo8 != null) {
            TripAllDetailInfo output1 = new TripAllDetailInfo();
            String field2 = tripalldetailinfo8.getTripId();
            output1.setTripId(field2);
            String field3 = tripalldetailinfo8.getTravelDate();
            output1.setTravelDate(field3);
            String field4 = tripalldetailinfo8.getFrom();
            output1.setFrom(field4);
            String field5 = tripalldetailinfo8.getTo();
            output1.setTo(field5);
            local0 = output1;
        } else
            local0 = null;

        HttpHeaders local6;
        if (httpheaders9 != null) {
            HttpHeaders local7 = new HttpHeaders();
            local7.putAll(httpheaders9);
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

    public ResponseEntity<Response<Contacts>> getApiV1ContactserviceContactsPathvariable(String string13, HttpHeaders httpheaders14) {
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

        HttpEntity input = tscontactsserviceApi.getApiV1ContactserviceContactsPathvariable(local0, local1);
        Object local3 = input.getBody();
        Response<Contacts> local4 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local3);
            local4 = mapper.readValue(bytes, new TypeReference<Response<Contacts>>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local5 = input.getHeaders();
        HttpHeaders local6 = new HttpHeaders();
        local6.putAll(local5);
        ResponseEntity<Response<Contacts>> output7 = new ResponseEntity<Response<Contacts>>(local4, local6, HttpStatus.CREATED);
        return output7;
    }

    public ResponseEntity<Response<Order>> postApiV1OrderotherserviceOrderother(Order order8, HttpHeaders httpheaders9) {
        OrderFromtsorderotherservice local0;
        if (order8 != null) {
            OrderFromtsorderotherservice local1 = null;
            try  {
                com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
                mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
                byte[] bytes = mapper.writeValueAsBytes(order8);
                local1 = mapper.readValue(bytes, new TypeReference<OrderFromtsorderotherservice>() {});
            } catch (Exception e) {
                System.err.println(e.toString());
            }
            local0 = local1;
        } else
            local0 = null;

        HttpHeaders local2;
        if (httpheaders9 != null) {
            HttpHeaders local3 = new HttpHeaders();
            local3.putAll(httpheaders9);
            local2 = local3;
        } else
            local2 = null;

        HttpEntity input = tsorderotherserviceApi.postApiV1OrderotherserviceOrderother(local0, local2);
        Object local4 = input.getBody();
        Response<Order> local5 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local4);
            local5 = mapper.readValue(bytes, new TypeReference<Response<Order>>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local6 = input.getHeaders();
        HttpHeaders local7 = new HttpHeaders();
        local7.putAll(local6);
        ResponseEntity<Response<Order>> output8 = new ResponseEntity<Response<Order>>(local5, local7, HttpStatus.CREATED);
        return output8;
    }

    public ResponseEntity<Response> postApiV1FoodserviceOrders(FoodOrder foodorder9, HttpHeaders httpheaders10) {
        modules.tsfoodservice.foodsearch.entity.FoodOrder local0;
        if (foodorder9 != null) {
            modules.tsfoodservice.foodsearch.entity.FoodOrder output1 = new modules.tsfoodservice.foodsearch.entity.FoodOrder();
            String field2 = foodorder9.getId();
            output1.setId(field2);
            String field3 = foodorder9.getOrderId();
            output1.setOrderId(field3);
            int field4 = foodorder9.getFoodType();
            output1.setFoodType(field4);
            String field5 = foodorder9.getStationName();
            output1.setStationName(field5);
            String field6 = foodorder9.getStoreName();
            output1.setStoreName(field6);
            String field7 = foodorder9.getFoodName();
            output1.setFoodName(field7);
            double field8 = foodorder9.getPrice();
            output1.setPrice(field8);
            local0 = output1;
        } else
            local0 = null;

        HttpHeaders local9;
        if (httpheaders10 != null) {
            HttpHeaders local10 = new HttpHeaders();
            local10.putAll(httpheaders10);
            local9 = local10;
        } else
            local9 = null;

        HttpEntity input = tsfoodserviceApi.postApiV1FoodserviceOrders(local0, local9);
        Object local11 = input.getBody();
        Response local12 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local11);
            local12 = mapper.readValue(bytes, new TypeReference<Response>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local13 = input.getHeaders();
        HttpHeaders local14 = new HttpHeaders();
        local14.putAll(local13);
        ResponseEntity<Response> output15 = new ResponseEntity<Response>(local12, local14, HttpStatus.CREATED);
        return output15;
    }

    public ResponseEntity<Response> postApiV1ConsignserviceConsigns(Consign consign16, HttpHeaders httpheaders17) {
        modules.tsconsignservice.consign.entity.Consign local0;
        if (consign16 != null) {
            modules.tsconsignservice.consign.entity.Consign output1 = new modules.tsconsignservice.consign.entity.Consign();
            String field2 = consign16.getId();
            output1.setId(field2);
            String field3 = consign16.getOrderId();
            output1.setOrderId(field3);
            String field4 = consign16.getAccountId();
            output1.setAccountId(field4);
            String field5 = consign16.getHandleDate();
            output1.setHandleDate(field5);
            String field6 = consign16.getTargetDate();
            output1.setTargetDate(field6);
            String field7 = consign16.getFrom();
            output1.setFrom(field7);
            String field8 = consign16.getTo();
            output1.setTo(field8);
            String field9 = consign16.getConsignee();
            output1.setConsignee(field9);
            String field10 = consign16.getPhone();
            output1.setPhone(field10);
            double field11 = consign16.getWeight();
            output1.setWeight(field11);
            boolean field12 = consign16.isWithin();
            output1.setWithin(field12);
            local0 = output1;
        } else
            local0 = null;

        HttpHeaders local13;
        if (httpheaders17 != null) {
            HttpHeaders local14 = new HttpHeaders();
            local14.putAll(httpheaders17);
            local13 = local14;
        } else
            local13 = null;

        HttpEntity input = tsconsignserviceApi.postApiV1ConsignserviceConsigns(local0, local13);
        Object local15 = input.getBody();
        Response local16 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local15);
            local16 = mapper.readValue(bytes, new TypeReference<Response>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local17 = input.getHeaders();
        HttpHeaders local18 = new HttpHeaders();
        local18.putAll(local17);
        ResponseEntity<Response> output19 = new ResponseEntity<Response>(local16, local18, HttpStatus.CREATED);
        return output19;
    }
}