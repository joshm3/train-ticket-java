package modules.tsstationservice;
import java.util.List;
import modules.tscommon.edu.fudan.common.util.Response;
import modules.tsstationservice.fdse.microservice.controller.StationController;
import modules.tsstationservice.fdse.microservice.entity.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
@Component
public class TsstationserviceApi {
    @Autowired
    StationController stationController;

    public HttpEntity postApiV1StationserviceStationsIdlist(List<String> stationNameList, HttpHeaders headers) {
        return stationController.queryForIdBatch(stationNameList, headers);
    }

    public HttpEntity getApiV1StationserviceStations(HttpHeaders headers) {
        return stationController.query(headers);
    }

    public HttpEntity putApiV1StationserviceStations(Station station, HttpHeaders headers) {
        return stationController.update(station, headers);
    }

    public ResponseEntity<Response> deleteApiV1StationserviceStationsPathvariable(String stationsId, HttpHeaders headers) {
        return stationController.delete(stationsId, headers);
    }

    public HttpEntity getApiV1StationserviceStationsIdPathvariable(String stationName, HttpHeaders headers) {
        return stationController.queryForStationId(stationName, headers);
    }

    public ResponseEntity<Response> postApiV1StationserviceStations(Station station, HttpHeaders headers) {
        return stationController.create(station, headers);
    }

    public HttpEntity postApiV1StationserviceStationsNamelist(List<String> stationIdList, HttpHeaders headers) {
        return stationController.queryForNameBatch(stationIdList, headers);
    }
}