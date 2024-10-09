package modules.tsrouteplanservice.plan.controller;
import modules.tscommon.edu.fudan.common.entity.RoutePlanInfo;
import modules.tsrouteplanservice.plan.service.RoutePlanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.ResponseEntity.ok;
/**
 *
 * @author fdse
 */
@RestController
@RequestMapping("/api/v1/routeplanservice")
public class RoutePlanController {
    @Autowired
    private RoutePlanService routePlanService;

    private static final Logger LOGGER = LoggerFactory.getLogger(RoutePlanController.class);

    @GetMapping(path = "/welcome")
    public String home() {
        return "Welcome to [ RoutePlan Service ] !";
    }

    @PostMapping("/routePlan/cheapestRoute")
    public HttpEntity getCheapestRoutes(@RequestBody
    RoutePlanInfo info, @RequestHeader
    HttpHeaders headers) {
        RoutePlanController.LOGGER.info("[searchCheapestResult][Get Cheapest Routes][From: {}, To: {}, Num: {}, Date: {}]", info.getStartStation(), info.getEndStation(), +info.getNum(), info.getTravelDate());
        return ok(routePlanService.searchCheapestResult(info, headers));
    }

    @PostMapping("/routePlan/quickestRoute")
    public HttpEntity getQuickestRoutes(@RequestBody
    RoutePlanInfo info, @RequestHeader
    HttpHeaders headers) {
        RoutePlanController.LOGGER.info("[searchQuickestResult][Get Quickest Routes][From: {}, To: {}, Num: {}, Date: {}]", info.getStartStation(), info.getEndStation(), info.getNum(), info.getTravelDate());
        return ok(routePlanService.searchQuickestResult(info, headers));
    }

    @PostMapping("/routePlan/minStopStations")
    public HttpEntity getMinStopStations(@RequestBody
    RoutePlanInfo info, @RequestHeader
    HttpHeaders headers) {
        RoutePlanController.LOGGER.info("[searchMinStopStations][Get Min Stop Stations][From: {}, To: {}, Num: {}, Date: {}]", info.getStartStation(), info.getEndStation(), info.getNum(), info.getTravelDate());
        return ok(routePlanService.searchMinStopStations(info, headers));
    }
}