package modules.tstravel2service.travel2.service;
import java.util.ArrayList;
import modules.tscommon.edu.fudan.common.entity.TravelInfo;
import modules.tscommon.edu.fudan.common.entity.TripAllDetailInfo;
import modules.tscommon.edu.fudan.common.entity.TripInfo;
import modules.tscommon.edu.fudan.common.util.Response;
import org.springframework.http.HttpHeaders;
/**
 *
 * @author Chenjie Xu
 * @date 2017/6/7.
 */
public interface TravelService {
    Response create(TravelInfo info, HttpHeaders headers);

    Response retrieve(String tripId, HttpHeaders headers);

    Response update(TravelInfo info, HttpHeaders headers);

    Response delete(String tripId, HttpHeaders headers);

    Response query(TripInfo info, HttpHeaders headers);

    Response queryByBatch(TripInfo info, HttpHeaders headers);

    Response getTripAllDetailInfo(TripAllDetailInfo gtdi, HttpHeaders headers);

    Response getRouteByTripId(String tripId, HttpHeaders headers);

    Response getTrainTypeByTripId(String tripId, HttpHeaders headers);

    Response queryAll(HttpHeaders headers);

    Response getTripByRoute(ArrayList<String> routeIds, HttpHeaders headers);

    Response adminQueryAll(HttpHeaders headers);
}