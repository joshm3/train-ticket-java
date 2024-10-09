package modules.tsadminbasicinfoservice.adminbasic.service;
import modules.tsadminbasicinfoservice.TsadminbasicinfoserviceClient;
import modules.tsadminbasicinfoservice.adminbasic.entity.PriceInfo;
import modules.tscommon.edu.fudan.common.entity.Config;
import modules.tscommon.edu.fudan.common.entity.Contacts;
import modules.tscommon.edu.fudan.common.entity.Station;
import modules.tscommon.edu.fudan.common.entity.TrainType;
import modules.tscommon.edu.fudan.common.util.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
/**
 *
 * @author fdse
 */
@Service
public class AdminBasicInfoServiceImpl implements AdminBasicInfoService {
    @Autowired
    TsadminbasicinfoserviceClient tsadminbasicinfoserviceClient;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminBasicInfoServiceImpl.class);

    private String getServiceUrl(String serviceName) {
        return "http://" + serviceName;
    }

    @Override
    public Response getAllContacts(HttpHeaders headers) {
        Response result;
        HttpEntity requestEntity = new HttpEntity(headers);
        String contacts_service_url = getServiceUrl("ts-contacts-service");
        ResponseEntity<Response> re = tsadminbasicinfoserviceClient.getApiV1ContactserviceContacts(headers);
        result = re.getBody();
        return result;
    }

    @Override
    public Response deleteContact(String contactsId, HttpHeaders headers) {
        Response result;
        HttpEntity requestEntity = new HttpEntity(headers);
        String contacts_service_url = getServiceUrl("ts-contacts-service");
        ResponseEntity<Response> re = tsadminbasicinfoserviceClient.deleteApiV1ContactserviceContactsPathvariable(contactsId, headers);
        result = re.getBody();
        return result;
    }

    @Override
    public Response modifyContact(Contacts mci, HttpHeaders headers) {
        Response result;
        HttpEntity requestEntity = new HttpEntity(mci, headers);
        String contacts_service_url = getServiceUrl("ts-contacts-service");
        ResponseEntity<Response> re = tsadminbasicinfoserviceClient.putApiV1ContactserviceContacts(mci, headers);
        result = re.getBody();
        return result;
    }

    @Override
    public Response addContact(Contacts c, HttpHeaders headers) {
        Response result;
        HttpEntity requestEntity = new HttpEntity(c, headers);
        String contacts_service_url = getServiceUrl("ts-contacts-service");
        ResponseEntity<Response> re = tsadminbasicinfoserviceClient.postApiV1ContactserviceContactsAdmin(c, headers);
        result = re.getBody();
        return result;
    }

    @Override
    public Response getAllStations(HttpHeaders headers) {
        HttpEntity requestEntity = new HttpEntity(headers);
        String station_service_url = getServiceUrl("ts-station-service");
        String stations = station_service_url + "/api/v1/stationservice/stations";
        ResponseEntity<Response> re = tsadminbasicinfoserviceClient.getApiV1StationserviceStations(headers);
        return re.getBody();
    }

    @Override
    public Response addStation(Station s, HttpHeaders headers) {
        Response result;
        HttpEntity requestEntity = new HttpEntity(s, headers);
        String station_service_url = getServiceUrl("ts-station-service");
        String stations = station_service_url + "/api/v1/stationservice/stations";
        ResponseEntity<Response> re = tsadminbasicinfoserviceClient.postApiV1StationserviceStations(s, headers);
        result = re.getBody();
        return result;
    }

    @Override
    public Response deleteStation(String id, HttpHeaders headers) {
        Response result;
        HttpEntity requestEntity = new HttpEntity(headers);
        String station_service_url = getServiceUrl("ts-station-service");
        String path = (station_service_url + "/api/v1/stationservice/stations/") + id;
        ResponseEntity<Response> re = tsadminbasicinfoserviceClient.deleteApiV1StationserviceStationsPathvariable(id, headers);
        result = re.getBody();
        return result;
    }

    @Override
    public Response modifyStation(Station s, HttpHeaders headers) {
        Response result;
        HttpEntity requestEntity = new HttpEntity(s, headers);
        String station_service_url = getServiceUrl("ts-station-service");
        String stations = station_service_url + "/api/v1/stationservice/stations";
        ResponseEntity<Response> re = tsadminbasicinfoserviceClient.putApiV1StationserviceStations(s, headers);
        result = re.getBody();
        return result;
    }

    @Override
    public Response getAllTrains(HttpHeaders headers) {
        HttpEntity requestEntity = new HttpEntity(headers);
        String train_service_url = getServiceUrl("ts-train-service");
        String trains = train_service_url + "/api/v1/trainservice/trains";
        ResponseEntity<Response> re = tsadminbasicinfoserviceClient.getApiV1TrainserviceTrains(headers);
        return re.getBody();
    }

    @Override
    public Response addTrain(TrainType t, HttpHeaders headers) {
        Response result;
        HttpEntity requestEntity = new HttpEntity(t, headers);
        String train_service_url = getServiceUrl("ts-train-service");
        String trains = train_service_url + "/api/v1/trainservice/trains";
        ResponseEntity<Response> re = tsadminbasicinfoserviceClient.postApiV1TrainserviceTrains(t, headers);
        result = re.getBody();
        return result;
    }

    @Override
    public Response deleteTrain(String id, HttpHeaders headers) {
        Response result;
        HttpEntity requestEntity = new HttpEntity(headers);
        String train_service_url = getServiceUrl("ts-train-service");
        ResponseEntity<Response> re = tsadminbasicinfoserviceClient.deleteApiV1TrainserviceTrainsPathvariable(id, headers);
        result = re.getBody();
        return result;
    }

    @Override
    public Response modifyTrain(TrainType t, HttpHeaders headers) {
        Response result;
        HttpEntity requestEntity = new HttpEntity(t, headers);
        String train_service_url = getServiceUrl("ts-train-service");
        String trains = train_service_url + "/api/v1/trainservice/trains";
        ResponseEntity<Response> re = tsadminbasicinfoserviceClient.putApiV1TrainserviceTrains(t, headers);
        result = re.getBody();
        return result;
    }

    @Override
    public Response getAllConfigs(HttpHeaders headers) {
        HttpEntity requestEntity = new HttpEntity(headers);
        String config_service_url = getServiceUrl("ts-config-service");
        String configs = config_service_url + "/api/v1/configservice/configs";
        ResponseEntity<Response> re = tsadminbasicinfoserviceClient.getApiV1ConfigserviceConfigs(headers);
        return re.getBody();
    }

    @Override
    public Response addConfig(Config c, HttpHeaders headers) {
        HttpEntity requestEntity = new HttpEntity(c, headers);
        String config_service_url = getServiceUrl("ts-config-service");
        String configs = config_service_url + "/api/v1/configservice/configs";
        ResponseEntity<Response> re = tsadminbasicinfoserviceClient.postApiV1ConfigserviceConfigs(c, headers);
        return re.getBody();
    }

    @Override
    public Response deleteConfig(String name, HttpHeaders headers) {
        HttpEntity requestEntity = new HttpEntity(headers);
        String config_service_url = getServiceUrl("ts-config-service");
        ResponseEntity<Response> re = tsadminbasicinfoserviceClient.deleteApiV1ConfigserviceConfigsPathvariable(name, headers);
        return re.getBody();
    }

    @Override
    public Response modifyConfig(Config c, HttpHeaders headers) {
        HttpEntity requestEntity = new HttpEntity(c, headers);
        String config_service_url = getServiceUrl("ts-config-service");
        String configs = config_service_url + "/api/v1/configservice/configs";
        ResponseEntity<Response> re = tsadminbasicinfoserviceClient.putApiV1ConfigserviceConfigs(c, headers);
        return re.getBody();
    }

    @Override
    public Response getAllPrices(HttpHeaders headers) {
        HttpEntity requestEntity = new HttpEntity(headers);
        String price_service_url = getServiceUrl("ts-price-service");
        String prices = price_service_url + "/api/v1/priceservice/prices";
        ResponseEntity<Response> re = tsadminbasicinfoserviceClient.getApiV1PriceservicePrices(headers);
        return re.getBody();
    }

    @Override
    public Response addPrice(PriceInfo pi, HttpHeaders headers) {
        HttpEntity requestEntity = new HttpEntity(pi, headers);
        String price_service_url = getServiceUrl("ts-price-service");
        String prices = price_service_url + "/api/v1/priceservice/prices";
        ResponseEntity<Response> re = tsadminbasicinfoserviceClient.postApiV1PriceservicePrices(pi, headers);
        return re.getBody();
    }

    @Override
    public Response deletePrice(String pricesId, HttpHeaders headers) {
        HttpEntity requestEntity = new HttpEntity(headers);
        String price_service_url = getServiceUrl("ts-price-service");
        String path = (price_service_url + "/api/v1/priceservice/prices/") + pricesId;
        ResponseEntity<Response> re = tsadminbasicinfoserviceClient.deleteApiV1PriceservicePricesPathvariable(pricesId, headers);
        return re.getBody();
    }

    @Override
    public Response modifyPrice(PriceInfo pi, HttpHeaders headers) {
        HttpEntity requestEntity = new HttpEntity(pi, headers);
        String price_service_url = getServiceUrl("ts-price-service");
        String prices = price_service_url + "/api/v1/priceservice/prices";
        ResponseEntity<Response> re = tsadminbasicinfoserviceClient.putApiV1PriceservicePrices(pi, headers);
        return re.getBody();
    }
}