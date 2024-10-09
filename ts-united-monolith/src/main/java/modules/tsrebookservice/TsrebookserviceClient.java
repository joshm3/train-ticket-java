package modules.tsrebookservice;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.ArrayList;
import java.util.List;
import modules.tscommon.edu.fudan.common.entity.Order;
import modules.tscommon.edu.fudan.common.entity.PaymentDifferenceInfo;
import modules.tscommon.edu.fudan.common.entity.Seat;
import modules.tscommon.edu.fudan.common.entity.Ticket;
import modules.tscommon.edu.fudan.common.entity.TripAllDetail;
import modules.tscommon.edu.fudan.common.entity.TripAllDetailInfo;
import modules.tscommon.edu.fudan.common.util.Response;
import modules.tsinsidepaymentservice.TsinsidepaymentserviceApi;
import modules.tsinsidepaymentservice.inside_payment.entity.PaymentInfo;
import modules.tsorderotherservice.TsorderotherserviceApi;
import modules.tsorderotherservice.other.entity.OrderFromtsorderotherservice;
import modules.tsorderservice.TsorderserviceApi;
import modules.tsrouteservice.TsrouteserviceApi;
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
public class TsrebookserviceClient {
    @Autowired
    TsinsidepaymentserviceApi tsinsidepaymentserviceApi;

    @Autowired
    TsrouteserviceApi tsrouteserviceApi;

    @Autowired
    TstrainserviceApi tstrainserviceApi;

    @Autowired
    TsorderserviceApi tsorderserviceApi;

    @Autowired
    TsorderotherserviceApi tsorderotherserviceApi;

    @Autowired
    TstravelserviceApi tstravelserviceApi;

    @Autowired
    Tstravel2serviceApi tstravel2serviceApi;

    @Autowired
    TsseatserviceApi tsseatserviceApi;

    public ResponseEntity<Response<Ticket>> postApiV1SeatserviceSeats(Seat seat8, HttpHeaders httpheaders9) {
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

    public ResponseEntity<Response<TripAllDetail>> postApiV1Travel2serviceTrip_detail(TripAllDetailInfo tripalldetailinfo18, HttpHeaders httpheaders19) {
        TripAllDetailInfo local0;
        if (tripalldetailinfo18 != null) {
            TripAllDetailInfo output1 = new TripAllDetailInfo();
            String field2 = tripalldetailinfo18.getTripId();
            output1.setTripId(field2);
            String field3 = tripalldetailinfo18.getTravelDate();
            output1.setTravelDate(field3);
            String field4 = tripalldetailinfo18.getFrom();
            output1.setFrom(field4);
            String field5 = tripalldetailinfo18.getTo();
            output1.setTo(field5);
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

    public ResponseEntity<Response> postApiV1OrderotherserviceOrderother(Order order13, HttpHeaders httpheaders14) {
        OrderFromtsorderotherservice local0;
        if (order13 != null) {
            OrderFromtsorderotherservice local1 = null;
            try  {
                com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
                mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
                byte[] bytes = mapper.writeValueAsBytes(order13);
                local1 = mapper.readValue(bytes, new TypeReference<OrderFromtsorderotherservice>() {});
            } catch (Exception e) {
                System.err.println(e.toString());
            }
            local0 = local1;
        } else
            local0 = null;

        HttpHeaders local2;
        if (httpheaders14 != null) {
            HttpHeaders local3 = new HttpHeaders();
            local3.putAll(httpheaders14);
            local2 = local3;
        } else
            local2 = null;

        HttpEntity input = tsorderotherserviceApi.postApiV1OrderotherserviceOrderother(local0, local2);
        Object local4 = input.getBody();
        Response local5 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local4);
            local5 = mapper.readValue(bytes, new TypeReference<Response>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local6 = input.getHeaders();
        HttpHeaders local7 = new HttpHeaders();
        local7.putAll(local6);
        ResponseEntity<Response> output8 = new ResponseEntity<Response>(local5, local7, HttpStatus.CREATED);
        return output8;
    }

    public ResponseEntity<Response> postApiV1OrderserviceOrder(Order order9, HttpHeaders httpheaders10) {
        modules.tsorderservice.order.entity.Order local0;
        if (order9 != null) {
            modules.tsorderservice.order.entity.Order local1 = null;
            try  {
                com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
                mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
                byte[] bytes = mapper.writeValueAsBytes(order9);
                local1 = mapper.readValue(bytes, new TypeReference<modules.tsorderservice.order.entity.Order>() {});
            } catch (Exception e) {
                System.err.println(e.toString());
            }
            local0 = local1;
        } else
            local0 = null;

        HttpHeaders local2;
        if (httpheaders10 != null) {
            HttpHeaders local3 = new HttpHeaders();
            local3.putAll(httpheaders10);
            local2 = local3;
        } else
            local2 = null;

        HttpEntity input = tsorderserviceApi.postApiV1OrderserviceOrder(local0, local2);
        Object local4 = input.getBody();
        Response local5 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local4);
            local5 = mapper.readValue(bytes, new TypeReference<Response>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local6 = input.getHeaders();
        HttpHeaders local7 = new HttpHeaders();
        local7.putAll(local6);
        ResponseEntity<Response> output8 = new ResponseEntity<Response>(local5, local7, HttpStatus.CREATED);
        return output8;
    }

    public ResponseEntity<Response> putApiV1OrderotherserviceOrderother(Order order9, HttpHeaders httpheaders10) {
        OrderFromtsorderotherservice local0;
        if (order9 != null) {
            OrderFromtsorderotherservice local1 = null;
            try  {
                com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
                mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
                byte[] bytes = mapper.writeValueAsBytes(order9);
                local1 = mapper.readValue(bytes, new TypeReference<OrderFromtsorderotherservice>() {});
            } catch (Exception e) {
                System.err.println(e.toString());
            }
            local0 = local1;
        } else
            local0 = null;

        HttpHeaders local2;
        if (httpheaders10 != null) {
            HttpHeaders local3 = new HttpHeaders();
            local3.putAll(httpheaders10);
            local2 = local3;
        } else
            local2 = null;

        HttpEntity input = tsorderotherserviceApi.putApiV1OrderotherserviceOrderother(local0, local2);
        Object local4 = input.getBody();
        Response local5 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local4);
            local5 = mapper.readValue(bytes, new TypeReference<Response>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local6 = input.getHeaders();
        HttpHeaders local7 = new HttpHeaders();
        local7.putAll(local6);
        ResponseEntity<Response> output8 = new ResponseEntity<Response>(local5, local7, HttpStatus.CREATED);
        return output8;
    }

    public ResponseEntity<Response> putApiV1OrderserviceOrder(Order order9, HttpHeaders httpheaders10) {
        modules.tsorderservice.order.entity.Order local0;
        if (order9 != null) {
            modules.tsorderservice.order.entity.Order local1 = null;
            try  {
                com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
                mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
                byte[] bytes = mapper.writeValueAsBytes(order9);
                local1 = mapper.readValue(bytes, new TypeReference<modules.tsorderservice.order.entity.Order>() {});
            } catch (Exception e) {
                System.err.println(e.toString());
            }
            local0 = local1;
        } else
            local0 = null;

        HttpHeaders local2;
        if (httpheaders10 != null) {
            HttpHeaders local3 = new HttpHeaders();
            local3.putAll(httpheaders10);
            local2 = local3;
        } else
            local2 = null;

        HttpEntity input = tsorderserviceApi.putApiV1OrderserviceOrder(local0, local2);
        Object local4 = input.getBody();
        Response local5 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local4);
            local5 = mapper.readValue(bytes, new TypeReference<Response>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local6 = input.getHeaders();
        HttpHeaders local7 = new HttpHeaders();
        local7.putAll(local6);
        ResponseEntity<Response> output8 = new ResponseEntity<Response>(local5, local7, HttpStatus.CREATED);
        return output8;
    }

    public ResponseEntity<Response<Order>> getApiV1OrderotherserviceOrderotherPathvariable(String string9, HttpHeaders httpheaders10) {
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

        HttpEntity input = tsorderotherserviceApi.getApiV1OrderotherserviceOrderotherPathvariable(local0, local1);
        Object local3 = input.getBody();
        Response<Order> local4 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local3);
            local4 = mapper.readValue(bytes, new TypeReference<Response<Order>>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local5 = input.getHeaders();
        HttpHeaders local6 = new HttpHeaders();
        local6.putAll(local5);
        ResponseEntity<Response<Order>> output7 = new ResponseEntity<Response<Order>>(local4, local6, HttpStatus.CREATED);
        return output7;
    }

    public ResponseEntity<Response<Order>> getApiV1OrderserviceOrderPathvariable(String string8, HttpHeaders httpheaders9) {
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

        HttpEntity input = tsorderserviceApi.getApiV1OrderserviceOrderPathvariable(local0, local1);
        Object local3 = input.getBody();
        Response<Order> local4 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local3);
            local4 = mapper.readValue(bytes, new TypeReference<Response<Order>>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local5 = input.getHeaders();
        HttpHeaders local6 = new HttpHeaders();
        local6.putAll(local5);
        ResponseEntity<Response<Order>> output7 = new ResponseEntity<Response<Order>>(local4, local6, HttpStatus.CREATED);
        return output7;
    }

    public ResponseEntity<Response> getApiV1TrainserviceTrainsBynamePathvariable(String string8, HttpHeaders httpheaders9) {
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

    public ResponseEntity<Response> postApiV1Inside_pay_serviceInside_paymentDifference(PaymentDifferenceInfo paymentdifferenceinfo8, HttpHeaders httpheaders9) {
        PaymentInfo local0;
        if (paymentdifferenceinfo8 != null) {
            PaymentInfo local1 = null;
            try  {
                com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
                mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
                byte[] bytes = mapper.writeValueAsBytes(paymentdifferenceinfo8);
                local1 = mapper.readValue(bytes, new TypeReference<PaymentInfo>() {});
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

        HttpEntity input = tsinsidepaymentserviceApi.postApiV1Inside_pay_serviceInside_paymentDifference(local0, local2);
        Object local4 = input.getBody();
        Response local5 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local4);
            local5 = mapper.readValue(bytes, new TypeReference<Response>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local6 = input.getHeaders();
        HttpHeaders local7 = new HttpHeaders();
        local7.putAll(local6);
        ResponseEntity<Response> output8 = new ResponseEntity<Response>(local5, local7, HttpStatus.CREATED);
        return output8;
    }

    public ResponseEntity<Response> getApiV1Inside_pay_serviceInside_paymentDrawbackPathvariablePathvariable(String string9, String string10, HttpHeaders httpheaders11) {
        String local0;
        if (string9 != null) {
            local0 = string9;
        } else
            local0 = null;

        String local1;
        if (string10 != null) {
            local1 = string10;
        } else
            local1 = null;

        HttpHeaders local2;
        if (httpheaders11 != null) {
            HttpHeaders local3 = new HttpHeaders();
            local3.putAll(httpheaders11);
            local2 = local3;
        } else
            local2 = null;

        HttpEntity input = tsinsidepaymentserviceApi.getApiV1Inside_pay_serviceInside_paymentDrawbackPathvariablePathvariable(local0, local1, local2);
        Object local4 = input.getBody();
        Response local5 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local4);
            local5 = mapper.readValue(bytes, new TypeReference<Response>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local6 = input.getHeaders();
        HttpHeaders local7 = new HttpHeaders();
        local7.putAll(local6);
        ResponseEntity<Response> output8 = new ResponseEntity<Response>(local5, local7, HttpStatus.CREATED);
        return output8;
    }
}