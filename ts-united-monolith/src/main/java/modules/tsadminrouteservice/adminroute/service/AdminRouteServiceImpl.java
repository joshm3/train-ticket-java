package modules.tsadminrouteservice.adminroute.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import modules.tsadminrouteservice.TsadminrouteserviceClient;
import modules.tscommon.edu.fudan.common.entity.Route;
import modules.tscommon.edu.fudan.common.entity.RouteInfo;
import modules.tscommon.edu.fudan.common.util.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
/**
 *
 * @author fdse
 */
@Service
public class AdminRouteServiceImpl implements AdminRouteService {
    @Autowired
    TsadminrouteserviceClient tsadminrouteserviceClient;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    public static final Logger logger = LoggerFactory.getLogger(AdminRouteServiceImpl.class);

    private String getServiceUrl(String serviceName) {
        return "http://" + serviceName;
    }

    @Override
    public Response getAllRoutes(HttpHeaders headers) {
        HttpEntity requestEntity = new HttpEntity(null);
        String route_service_url = getServiceUrl("ts-route-service");
        ResponseEntity<Response> re = tsadminrouteserviceClient.getApiV1RouteserviceRoutes(null);
        if (re.getStatusCode() != HttpStatus.ACCEPTED) {
            logger.error("[getAllRoutes][receive response][Get routes error][response code: {}]", re.getStatusCodeValue());
        }
        return re.getBody();
    }

    @Override
    public Response createAndModifyRoute(RouteInfo request, HttpHeaders headers) {
        // check stations
        String start = request.getStartStation();
        String end = request.getEndStation();
        List<String> stations = request.getStations();
        if ((!stations.contains(start)) || (!stations.contains(end))) {
            logger.error("[createAndModifyRoute][check stations][start or end not included in stationList][start: {}, end: {}]", start, end);
            return new Response(0, "start or end station not include in stationList.", null);
        }
        Response response = checkStationsExists(stations, headers);
        if (response.getStatus() == 0) {
            return response;
        }
        HttpEntity requestEntity = new HttpEntity(request, null);
        String route_service_url = getServiceUrl("ts-route-service");
        ResponseEntity<Response<Route>> re = tsadminrouteserviceClient.postApiV1RouteserviceRoutes(request, null);
        if (re.getStatusCode() != HttpStatus.ACCEPTED) {
            logger.error("[createAndModifyRoute][receive response][Get status error][response code: {}]", re.getStatusCodeValue());
        }
        return re.getBody();
    }

    @Override
    public Response deleteRoute(String routeId, HttpHeaders headers) {
        HttpEntity requestEntity = new HttpEntity(null);
        String route_service_url = getServiceUrl("ts-route-service");
        ResponseEntity<Response> re = tsadminrouteserviceClient.deleteApiV1RouteserviceRoutesPathvariable(routeId, null);
        if (re.getStatusCode() != HttpStatus.ACCEPTED) {
            logger.error("[deleteRoute][response response][Delete error][response code: {}]", re.getStatusCodeValue());
        }
        return re.getBody();
    }

    public Response checkStationsExists(List<String> stationNames, HttpHeaders headers) {
        logger.info("[checkStationsExists][Check Stations Exists][stationNames: {}]", stationNames);
        HttpEntity requestEntity = new HttpEntity(stationNames, null);
        String station_service_url = getServiceUrl("ts-station-service");
        ResponseEntity<Response> re = tsadminrouteserviceClient.postApiV1StationserviceStationsIdlist(stationNames, null);
        Response<Map<String, String>> r = re.getBody();
        if (r.getStatus() == 0) {
            return r;
        }
        Map<String, String> stationMap = r.getData();
        List<String> notExists = new ArrayList<>();
        for (Map.Entry<String, String> s : stationMap.entrySet()) {
            if (s.getValue() == null) {
                // station not exist
                notExists.add(s.getKey());
            }
        }
        if (notExists.size() > 0) {
            return new Response(0, "some station not exists", notExists);
        }
        return new Response(1, "check stations Exist succeed", null);
    }
}