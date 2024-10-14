package modules.tstravelservice;
import java.util.ArrayList;
import modules.tscommon.edu.fudan.common.entity.TravelInfo;
import modules.tscommon.edu.fudan.common.entity.TripAllDetailInfo;
import modules.tscommon.edu.fudan.common.entity.TripInfo;
import modules.tstravelservice.travel.controller.TravelController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
@Component
public class TstravelserviceApi {
    @Autowired
    TravelController travelController;

    public HttpEntity putApiV1TravelserviceTrips(TravelInfo info, HttpHeaders headers) {
        return travelController.updateTrip(info, headers);
    }

    public HttpEntity deleteApiV1TravelserviceTripsPathvariable(String tripId, HttpHeaders headers) {
        return travelController.deleteTrip(tripId, headers);
    }

    public HttpEntity<?> postApiV1TravelserviceTrips(TravelInfo routeIds, HttpHeaders headers) {
        return travelController.createTrip(routeIds, headers);
    }

    public HttpEntity postApiV1TravelserviceTripsLeft(TripInfo info, HttpHeaders headers) {
        return travelController.queryInfo(info, headers);
    }

    public HttpEntity postApiV1TravelserviceTrip_detail(TripAllDetailInfo gtdi, HttpHeaders headers) {
        return travelController.getTripAllDetailInfo(gtdi, headers);
    }

    public HttpEntity getApiV1TravelserviceAdmin_trip(HttpHeaders headers) {
        return travelController.adminQueryAll(headers);
    }

    public HttpEntity postApiV1TravelserviceTripsRoutes(ArrayList<String> routeIds, HttpHeaders headers) {
        return travelController.getTripsByRouteId(routeIds, headers);
    }

    public HttpEntity getApiV1TravelserviceRoutesPathvariable(String tripId, HttpHeaders headers) {
        return travelController.getRouteByTripId(tripId, headers);
    }
}