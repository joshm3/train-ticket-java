package modules.tstravelplanservice.travelplan.service;
import modules.tscommon.edu.fudan.common.entity.TripInfo;
import modules.tscommon.edu.fudan.common.util.Response;
import modules.tstravelplanservice.travelplan.entity.TransferTravelInfo;
import org.springframework.http.HttpHeaders;
/**
 *
 * @author fdse
 */
public interface TravelPlanService {
    Response getTransferSearch(TransferTravelInfo info, HttpHeaders headers);

    Response getCheapest(TripInfo info, HttpHeaders headers);

    Response getQuickest(TripInfo info, HttpHeaders headers);

    Response getMinStation(TripInfo info, HttpHeaders headers);
}