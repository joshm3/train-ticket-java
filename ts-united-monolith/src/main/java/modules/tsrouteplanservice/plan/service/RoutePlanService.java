package modules.tsrouteplanservice.plan.service;
import modules.tscommon.edu.fudan.common.entity.RoutePlanInfo;
import modules.tscommon.edu.fudan.common.util.Response;
import org.springframework.http.HttpHeaders;
/**
 *
 * @author fdse
 */
public interface RoutePlanService {
    /**
     * search the cheapest result with route plan info
     *
     * @param info
     * 		route plan info
     * @param headers
    		headers
     * @return Response
     */
    Response searchCheapestResult(RoutePlanInfo info, HttpHeaders headers);

    /**
     * search the quickest result with route plan info
     *
     * @param info
     * 		route plan info
     * @param headers
    		headers
     * @return Response
     */
    Response searchQuickestResult(RoutePlanInfo info, HttpHeaders headers);

    /**
     * search min stop-station with route plan info
     *
     * @param info
     * 		route plan info
     * @param headers
    		headers
     * @return Response
     */
    Response searchMinStopStations(RoutePlanInfo info, HttpHeaders headers);
}