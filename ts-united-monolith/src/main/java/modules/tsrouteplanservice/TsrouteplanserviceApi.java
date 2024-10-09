package modules.tsrouteplanservice;
import modules.tscommon.edu.fudan.common.entity.RoutePlanInfo;
import modules.tsrouteplanservice.plan.controller.RoutePlanController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
@Component
public class TsrouteplanserviceApi {
    @Autowired
    RoutePlanController routePlanController;

    public HttpEntity postApiV1RouteplanserviceRouteplanQuickestroute(RoutePlanInfo info, HttpHeaders headers) {
        return routePlanController.getQuickestRoutes(info, headers);
    }

    public HttpEntity postApiV1RouteplanserviceRouteplanCheapestroute(RoutePlanInfo info, HttpHeaders headers) {
        return routePlanController.getCheapestRoutes(info, headers);
    }

    public HttpEntity postApiV1RouteplanserviceRouteplanMinstopstations(RoutePlanInfo info, HttpHeaders headers) {
        return routePlanController.getMinStopStations(info, headers);
    }
}