package modules.tsadminbasicinfoservice;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.UUID;
import modules.tsadminbasicinfoservice.adminbasic.entity.PriceInfo;
import modules.tscommon.edu.fudan.common.entity.Config;
import modules.tscommon.edu.fudan.common.entity.Contacts;
import modules.tscommon.edu.fudan.common.entity.Station;
import modules.tscommon.edu.fudan.common.entity.TrainType;
import modules.tscommon.edu.fudan.common.util.Response;
import modules.tsconfigservice.TsconfigserviceApi;
import modules.tscontactsservice.TscontactsserviceApi;
import modules.tspriceservice.TspriceserviceApi;
import modules.tspriceservice.price.entity.PriceConfig;
import modules.tsstationservice.TsstationserviceApi;
import modules.tstrainservice.TstrainserviceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
@Component
public class TsadminbasicinfoserviceClient {
    @Autowired
    TspriceserviceApi tspriceserviceApi;

    @Autowired
    TsconfigserviceApi tsconfigserviceApi;

    @Autowired
    TstrainserviceApi tstrainserviceApi;

    @Autowired
    TsstationserviceApi tsstationserviceApi;

    @Autowired
    TscontactsserviceApi tscontactsserviceApi;

    public ResponseEntity<Response> getApiV1ContactserviceContacts(HttpHeaders httpheaders14) {
        HttpHeaders local0;
        if (httpheaders14 != null) {
            HttpHeaders local1 = new HttpHeaders();
            local1.putAll(httpheaders14);
            local0 = local1;
        } else
            local0 = null;

        HttpEntity input = tscontactsserviceApi.getApiV1ContactserviceContacts(local0);
        Object local2 = input.getBody();
        Response local3 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local2);
            local3 = mapper.readValue(bytes, new TypeReference<Response>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local4 = input.getHeaders();
        HttpHeaders local5 = new HttpHeaders();
        local5.putAll(local4);
        ResponseEntity<Response> output6 = new ResponseEntity<Response>(local3, local5, HttpStatus.CREATED);
        return output6;
    }

    public ResponseEntity<Response> deleteApiV1ContactserviceContactsPathvariable(String string7, HttpHeaders httpheaders8) {
        String local0;
        if (string7 != null) {
            local0 = string7;
        } else
            local0 = null;

        HttpHeaders local1;
        if (httpheaders8 != null) {
            HttpHeaders local2 = new HttpHeaders();
            local2.putAll(httpheaders8);
            local1 = local2;
        } else
            local1 = null;

        HttpEntity input = tscontactsserviceApi.deleteApiV1ContactserviceContactsPathvariable(local0, local1);
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

    public ResponseEntity<Response> putApiV1ContactserviceContacts(Contacts contacts8, HttpHeaders httpheaders9) {
        modules.tscontactsservice.contacts.entity.Contacts local0;
        if (contacts8 != null) {
            modules.tscontactsservice.contacts.entity.Contacts output1 = new modules.tscontactsservice.contacts.entity.Contacts();
            UUID field2 = contacts8.getId();
            String local3 = String.valueOf(field2);
            output1.setId(local3);
            UUID field4 = contacts8.getAccountId();
            String local5 = String.valueOf(field4);
            output1.setAccountId(local5);
            String field6 = contacts8.getName();
            output1.setName(field6);
            int field7 = contacts8.getDocumentType();
            output1.setDocumentType(field7);
            String field8 = contacts8.getDocumentNumber();
            output1.setDocumentNumber(field8);
            String field9 = contacts8.getPhoneNumber();
            output1.setPhoneNumber(field9);
            local0 = output1;
        } else
            local0 = null;

        HttpHeaders local10;
        if (httpheaders9 != null) {
            HttpHeaders local11 = new HttpHeaders();
            local11.putAll(httpheaders9);
            local10 = local11;
        } else
            local10 = null;

        HttpEntity input = tscontactsserviceApi.putApiV1ContactserviceContacts(local0, local10);
        Object local12 = input.getBody();
        Response local13 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local12);
            local13 = mapper.readValue(bytes, new TypeReference<Response>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local14 = input.getHeaders();
        HttpHeaders local15 = new HttpHeaders();
        local15.putAll(local14);
        ResponseEntity<Response> output16 = new ResponseEntity<Response>(local13, local15, HttpStatus.CREATED);
        return output16;
    }

    public ResponseEntity<Response> postApiV1ContactserviceContactsAdmin(Contacts contacts17, HttpHeaders httpheaders18) {
        modules.tscontactsservice.contacts.entity.Contacts local0;
        if (contacts17 != null) {
            modules.tscontactsservice.contacts.entity.Contacts output1 = new modules.tscontactsservice.contacts.entity.Contacts();
            UUID field2 = contacts17.getId();
            String local3 = String.valueOf(field2);
            output1.setId(local3);
            UUID field4 = contacts17.getAccountId();
            String local5 = String.valueOf(field4);
            output1.setAccountId(local5);
            String field6 = contacts17.getName();
            output1.setName(field6);
            int field7 = contacts17.getDocumentType();
            output1.setDocumentType(field7);
            String field8 = contacts17.getDocumentNumber();
            output1.setDocumentNumber(field8);
            String field9 = contacts17.getPhoneNumber();
            output1.setPhoneNumber(field9);
            local0 = output1;
        } else
            local0 = null;

        HttpHeaders local10;
        if (httpheaders18 != null) {
            HttpHeaders local11 = new HttpHeaders();
            local11.putAll(httpheaders18);
            local10 = local11;
        } else
            local10 = null;

        HttpEntity<?> input = tscontactsserviceApi.postApiV1ContactserviceContactsAdmin(local0, local10);
        Object local12 = input.getBody();
        Response local13 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local12);
            local13 = mapper.readValue(bytes, new TypeReference<Response>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local14 = input.getHeaders();
        HttpHeaders local15 = new HttpHeaders();
        local15.putAll(local14);
        ResponseEntity<Response> output16 = new ResponseEntity<Response>(local13, local15, HttpStatus.CREATED);
        return output16;
    }

    public ResponseEntity<Response> getApiV1StationserviceStations(HttpHeaders httpheaders17) {
        HttpHeaders local0;
        if (httpheaders17 != null) {
            HttpHeaders local1 = new HttpHeaders();
            local1.putAll(httpheaders17);
            local0 = local1;
        } else
            local0 = null;

        HttpEntity input = tsstationserviceApi.getApiV1StationserviceStations(local0);
        Object local2 = input.getBody();
        Response local3 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local2);
            local3 = mapper.readValue(bytes, new TypeReference<Response>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local4 = input.getHeaders();
        HttpHeaders local5 = new HttpHeaders();
        local5.putAll(local4);
        ResponseEntity<Response> output6 = new ResponseEntity<Response>(local3, local5, HttpStatus.CREATED);
        return output6;
    }

    public ResponseEntity<Response> postApiV1StationserviceStations(Station station7, HttpHeaders httpheaders8) {
        modules.tsstationservice.fdse.microservice.entity.Station local0;
        if (station7 != null) {
            modules.tsstationservice.fdse.microservice.entity.Station output1 = new modules.tsstationservice.fdse.microservice.entity.Station();
            String field2 = station7.getId();
            output1.setId(field2);
            String field3 = station7.getName();
            output1.setName(field3);
            int field4 = station7.getStayTime();
            output1.setStayTime(field4);
            local0 = output1;
        } else
            local0 = null;

        HttpHeaders local5;
        if (httpheaders8 != null) {
            HttpHeaders local6 = new HttpHeaders();
            local6.putAll(httpheaders8);
            local5 = local6;
        } else
            local5 = null;

        ResponseEntity<Response> input = tsstationserviceApi.postApiV1StationserviceStations(local0, local5);
        Object local7 = input.getBody();
        Response local8 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local7);
            local8 = mapper.readValue(bytes, new TypeReference<Response>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local9 = input.getHeaders();
        HttpHeaders local10 = new HttpHeaders();
        local10.putAll(local9);
        ResponseEntity<Response> output11 = new ResponseEntity<Response>(local8, local10, input.getStatusCode());
        return output11;
    }

    public ResponseEntity<Response> deleteApiV1StationserviceStationsPathvariable(String string12, HttpHeaders httpheaders13) {
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

        ResponseEntity<Response> input = tsstationserviceApi.deleteApiV1StationserviceStationsPathvariable(local0, local1);
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
        ResponseEntity<Response> output7 = new ResponseEntity<Response>(local4, local6, input.getStatusCode());
        return output7;
    }

    public ResponseEntity<Response> putApiV1StationserviceStations(Station station8, HttpHeaders httpheaders9) {
        modules.tsstationservice.fdse.microservice.entity.Station local0;
        if (station8 != null) {
            modules.tsstationservice.fdse.microservice.entity.Station output1 = new modules.tsstationservice.fdse.microservice.entity.Station();
            String field2 = station8.getId();
            output1.setId(field2);
            String field3 = station8.getName();
            output1.setName(field3);
            int field4 = station8.getStayTime();
            output1.setStayTime(field4);
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

        HttpEntity input = tsstationserviceApi.putApiV1StationserviceStations(local0, local5);
        Object local7 = input.getBody();
        Response local8 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local7);
            local8 = mapper.readValue(bytes, new TypeReference<Response>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local9 = input.getHeaders();
        HttpHeaders local10 = new HttpHeaders();
        local10.putAll(local9);
        ResponseEntity<Response> output11 = new ResponseEntity<Response>(local8, local10, HttpStatus.CREATED);
        return output11;
    }

    public ResponseEntity<Response> getApiV1TrainserviceTrains(HttpHeaders httpheaders12) {
        HttpHeaders local0;
        if (httpheaders12 != null) {
            HttpHeaders local1 = new HttpHeaders();
            local1.putAll(httpheaders12);
            local0 = local1;
        } else
            local0 = null;

        HttpEntity input = tstrainserviceApi.getApiV1TrainserviceTrains(local0);
        Object local2 = input.getBody();
        Response local3 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local2);
            local3 = mapper.readValue(bytes, new TypeReference<Response>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local4 = input.getHeaders();
        HttpHeaders local5 = new HttpHeaders();
        local5.putAll(local4);
        ResponseEntity<Response> output6 = new ResponseEntity<Response>(local3, local5, HttpStatus.CREATED);
        return output6;
    }

    public ResponseEntity<Response> postApiV1TrainserviceTrains(TrainType traintype7, HttpHeaders httpheaders8) {
        modules.tstrainservice.train.entity.TrainType local0;
        if (traintype7 != null) {
            modules.tstrainservice.train.entity.TrainType output1 = new modules.tstrainservice.train.entity.TrainType();
            String field2 = traintype7.getId();
            output1.setId(field2);
            String field3 = traintype7.getName();
            output1.setName(field3);
            int field4 = traintype7.getEconomyClass();
            output1.setEconomyClass(field4);
            int field5 = traintype7.getConfortClass();
            output1.setConfortClass(field5);
            int field6 = traintype7.getAverageSpeed();
            output1.setAverageSpeed(field6);
            local0 = output1;
        } else
            local0 = null;

        HttpHeaders local7;
        if (httpheaders8 != null) {
            HttpHeaders local8 = new HttpHeaders();
            local8.putAll(httpheaders8);
            local7 = local8;
        } else
            local7 = null;

        HttpEntity input = tstrainserviceApi.postApiV1TrainserviceTrains(local0, local7);
        Object local9 = input.getBody();
        Response local10 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local9);
            local10 = mapper.readValue(bytes, new TypeReference<Response>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local11 = input.getHeaders();
        HttpHeaders local12 = new HttpHeaders();
        local12.putAll(local11);
        ResponseEntity<Response> output13 = new ResponseEntity<Response>(local10, local12, HttpStatus.CREATED);
        return output13;
    }

    public ResponseEntity<Response> deleteApiV1TrainserviceTrainsPathvariable(String string14, HttpHeaders httpheaders15) {
        String local0;
        if (string14 != null) {
            local0 = string14;
        } else
            local0 = null;

        HttpHeaders local1;
        if (httpheaders15 != null) {
            HttpHeaders local2 = new HttpHeaders();
            local2.putAll(httpheaders15);
            local1 = local2;
        } else
            local1 = null;

        HttpEntity input = tstrainserviceApi.deleteApiV1TrainserviceTrainsPathvariable(local0, local1);
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

    public ResponseEntity<Response> putApiV1TrainserviceTrains(TrainType traintype8, HttpHeaders httpheaders9) {
        modules.tstrainservice.train.entity.TrainType local0;
        if (traintype8 != null) {
            modules.tstrainservice.train.entity.TrainType output1 = new modules.tstrainservice.train.entity.TrainType();
            String field2 = traintype8.getId();
            output1.setId(field2);
            String field3 = traintype8.getName();
            output1.setName(field3);
            int field4 = traintype8.getEconomyClass();
            output1.setEconomyClass(field4);
            int field5 = traintype8.getConfortClass();
            output1.setConfortClass(field5);
            int field6 = traintype8.getAverageSpeed();
            output1.setAverageSpeed(field6);
            local0 = output1;
        } else
            local0 = null;

        HttpHeaders local7;
        if (httpheaders9 != null) {
            HttpHeaders local8 = new HttpHeaders();
            local8.putAll(httpheaders9);
            local7 = local8;
        } else
            local7 = null;

        HttpEntity input = tstrainserviceApi.putApiV1TrainserviceTrains(local0, local7);
        Object local9 = input.getBody();
        Response local10 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local9);
            local10 = mapper.readValue(bytes, new TypeReference<Response>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local11 = input.getHeaders();
        HttpHeaders local12 = new HttpHeaders();
        local12.putAll(local11);
        ResponseEntity<Response> output13 = new ResponseEntity<Response>(local10, local12, HttpStatus.CREATED);
        return output13;
    }

    public ResponseEntity<Response> getApiV1ConfigserviceConfigs(HttpHeaders httpheaders14) {
        HttpHeaders local0;
        if (httpheaders14 != null) {
            HttpHeaders local1 = new HttpHeaders();
            local1.putAll(httpheaders14);
            local0 = local1;
        } else
            local0 = null;

        HttpEntity input = tsconfigserviceApi.getApiV1ConfigserviceConfigs(local0);
        Object local2 = input.getBody();
        Response local3 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local2);
            local3 = mapper.readValue(bytes, new TypeReference<Response>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local4 = input.getHeaders();
        HttpHeaders local5 = new HttpHeaders();
        local5.putAll(local4);
        ResponseEntity<Response> output6 = new ResponseEntity<Response>(local3, local5, HttpStatus.CREATED);
        return output6;
    }

    public ResponseEntity<Response> postApiV1ConfigserviceConfigs(Config config7, HttpHeaders httpheaders8) {
        modules.tsconfigservice.config.entity.Config local0;
        if (config7 != null) {
            modules.tsconfigservice.config.entity.Config output1 = new modules.tsconfigservice.config.entity.Config();
            String field2 = config7.getName();
            output1.setName(field2);
            String field3 = config7.getValue();
            output1.setValue(field3);
            String field4 = config7.getDescription();
            output1.setDescription(field4);
            local0 = output1;
        } else
            local0 = null;

        HttpHeaders local5;
        if (httpheaders8 != null) {
            HttpHeaders local6 = new HttpHeaders();
            local6.putAll(httpheaders8);
            local5 = local6;
        } else
            local5 = null;

        HttpEntity<?> input = tsconfigserviceApi.postApiV1ConfigserviceConfigs(local0, local5);
        Object local7 = input.getBody();
        Response local8 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local7);
            local8 = mapper.readValue(bytes, new TypeReference<Response>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local9 = input.getHeaders();
        HttpHeaders local10 = new HttpHeaders();
        local10.putAll(local9);
        ResponseEntity<Response> output11 = new ResponseEntity<Response>(local8, local10, HttpStatus.CREATED);
        return output11;
    }

    public ResponseEntity<Response> deleteApiV1ConfigserviceConfigsPathvariable(String string12, HttpHeaders httpheaders13) {
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

        HttpEntity input = tsconfigserviceApi.deleteApiV1ConfigserviceConfigsPathvariable(local0, local1);
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

    public ResponseEntity<Response> putApiV1ConfigserviceConfigs(Config config8, HttpHeaders httpheaders9) {
        modules.tsconfigservice.config.entity.Config local0;
        if (config8 != null) {
            modules.tsconfigservice.config.entity.Config output1 = new modules.tsconfigservice.config.entity.Config();
            String field2 = config8.getName();
            output1.setName(field2);
            String field3 = config8.getValue();
            output1.setValue(field3);
            String field4 = config8.getDescription();
            output1.setDescription(field4);
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

        HttpEntity input = tsconfigserviceApi.putApiV1ConfigserviceConfigs(local0, local5);
        Object local7 = input.getBody();
        Response local8 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local7);
            local8 = mapper.readValue(bytes, new TypeReference<Response>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local9 = input.getHeaders();
        HttpHeaders local10 = new HttpHeaders();
        local10.putAll(local9);
        ResponseEntity<Response> output11 = new ResponseEntity<Response>(local8, local10, HttpStatus.CREATED);
        return output11;
    }

    public ResponseEntity<Response> getApiV1PriceservicePrices(HttpHeaders httpheaders12) {
        HttpHeaders local0;
        if (httpheaders12 != null) {
            HttpHeaders local1 = new HttpHeaders();
            local1.putAll(httpheaders12);
            local0 = local1;
        } else
            local0 = null;

        HttpEntity input = tspriceserviceApi.getApiV1PriceservicePrices(local0);
        Object local2 = input.getBody();
        Response local3 = null;
        try  {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
            byte[] bytes = mapper.writeValueAsBytes(local2);
            local3 = mapper.readValue(bytes, new TypeReference<Response>() {});
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        HttpHeaders local4 = input.getHeaders();
        HttpHeaders local5 = new HttpHeaders();
        local5.putAll(local4);
        ResponseEntity<Response> output6 = new ResponseEntity<Response>(local3, local5, HttpStatus.CREATED);
        return output6;
    }

    public ResponseEntity<Response> postApiV1PriceservicePrices(PriceInfo priceinfo7, HttpHeaders httpheaders8) {
        PriceConfig local0;
        if (priceinfo7 != null) {
            PriceConfig local1 = null;
            try  {
                com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
                mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
                byte[] bytes = mapper.writeValueAsBytes(priceinfo7);
                local1 = mapper.readValue(bytes, new TypeReference<PriceConfig>() {});
            } catch (Exception e) {
                System.err.println(e.toString());
            }
            local0 = local1;
        } else
            local0 = null;

        HttpHeaders local2;
        if (httpheaders8 != null) {
            HttpHeaders local3 = new HttpHeaders();
            local3.putAll(httpheaders8);
            local2 = local3;
        } else
            local2 = null;

        HttpEntity<?> input = tspriceserviceApi.postApiV1PriceservicePrices(local0, local2);
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

    public ResponseEntity<Response> deleteApiV1PriceservicePricesPathvariable(String string9, HttpHeaders httpheaders10) {
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

        HttpEntity input = tspriceserviceApi.deleteApiV1PriceservicePricesPathvariable(local0, local1);
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

    public ResponseEntity<Response> putApiV1PriceservicePrices(PriceInfo priceinfo8, HttpHeaders httpheaders9) {
        PriceConfig local0;
        if (priceinfo8 != null) {
            PriceConfig local1 = null;
            try  {
                com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
                mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                mapper.registerModule(new com.fasterxml.jackson.datatype.jdk8.Jdk8Module());
                byte[] bytes = mapper.writeValueAsBytes(priceinfo8);
                local1 = mapper.readValue(bytes, new TypeReference<PriceConfig>() {});
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

        HttpEntity input = tspriceserviceApi.putApiV1PriceservicePrices(local0, local2);
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