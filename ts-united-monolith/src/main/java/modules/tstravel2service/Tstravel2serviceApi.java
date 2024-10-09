package modules.tstravel2service;
import java.util.ArrayList;
import modules.tscommon.edu.fudan.common.entity.TravelInfo;
import modules.tscommon.edu.fudan.common.entity.TripAllDetailInfo;
import modules.tscommon.edu.fudan.common.entity.TripInfo;
import modules.tstravel2service.travel2.controller.Travel2Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
@Component
public class Tstravel2serviceApi {
    @Autowired
    Travel2Controller travel2Controller;

    public HttpEntity postApiV1Travel2serviceTrip_detail(TripAllDetailInfo gtdi, HttpHeaders headers) {
        return travel2Controller.getTripAllDetailInfo(gtdi, headers);
    }

    public HttpEntity getApiV1Travel2serviceAdmin_trip(HttpHeaders headers) {
        return travel2Controller.adminQueryAll(headers);
    }

    public HttpEntity postApiV1Travel2serviceTripsRoutes(ArrayList<String> routeIds, HttpHeaders headers) {
        return travel2Controller.getTripsByRouteId(routeIds, headers);
    }

    public HttpEntity getApiV1Travel2serviceRoutesPathvariable(String tripId, HttpHeaders headers) {
        return travel2Controller.getRouteByTripId(tripId, headers);
    }

    public HttpEntity putApiV1Travel2serviceTrips(TravelInfo info, HttpHeaders headers) {
        return travel2Controller.updateTrip(info, headers);
    }

    public HttpEntity deleteApiV1Travel2serviceTripsPathvariable(String tripId, HttpHeaders headers) {
        return travel2Controller.deleteTrip(tripId, headers);
    }

    public HttpEntity<?> postApiV1Travel2serviceTrips(TravelInfo routeIds, HttpHeaders headers) {
        return travel2Controller.createTrip(routeIds, headers);
    }

    public HttpEntity postApiV1Travel2serviceTripsLeft(TripInfo info, HttpHeaders headers) {
        return travel2Controller.queryInfo(info, headers);
    }
}