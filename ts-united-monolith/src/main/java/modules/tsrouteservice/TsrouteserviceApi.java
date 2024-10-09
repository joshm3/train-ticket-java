package modules.tsrouteservice;
import java.util.List;
import modules.tscommon.edu.fudan.common.util.Response;
import modules.tsrouteservice.route.controller.RouteController;
import modules.tsrouteservice.route.entity.RouteInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
@Component
public class TsrouteserviceApi {
    @Autowired
    RouteController routeController;

    public ResponseEntity<Response> postApiV1RouteserviceRoutes(RouteInfo createAndModifyRouteInfo, HttpHeaders headers) {
        return routeController.createAndModifyRoute(createAndModifyRouteInfo, headers);
    }

    public HttpEntity getApiV1RouteserviceRoutes(HttpHeaders headers) {
        return routeController.queryAll(headers);
    }

    public HttpEntity getApiV1RouteserviceRoutesPathvariablePathvariable(String start, String end, HttpHeaders headers) {
        return routeController.queryByStartAndTerminal(start, end, headers);
    }

    public HttpEntity deleteApiV1RouteserviceRoutesPathvariable(String routeId, HttpHeaders headers) {
        return routeController.deleteRoute(routeId, headers);
    }

    public HttpEntity postApiV1RouteserviceRoutesByids(List<String> routeIds, HttpHeaders headers) {
        return routeController.queryByIds(routeIds, headers);
    }

    public HttpEntity getApiV1RouteserviceRoutesPathvariable(String routeId, HttpHeaders headers) {
        return routeController.queryById(routeId, headers);
    }
}