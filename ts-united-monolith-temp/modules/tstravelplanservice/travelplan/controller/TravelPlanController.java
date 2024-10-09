package modules.tstravelplanservice.travelplan.controller;
import modules.tscommon.edu.fudan.common.entity.TripInfo;
import modules.tstravelplanservice.travelplan.entity.TransferTravelInfo;
import modules.tstravelplanservice.travelplan.service.TravelPlanService;
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
@RequestMapping("api/v1/travelplanservice")
public class TravelPlanController {
    @Autowired
    TravelPlanService travelPlanService;

    private static final Logger LOGGER = LoggerFactory.getLogger(TravelPlanController.class);

    @GetMapping(path = "/welcome")
    public String home() {
        return "Welcome to [ TravelPlan Service ] !";
    }

    @PostMapping("/travelPlan/transferResult")
    public HttpEntity getTransferResult(@RequestBody
    TransferTravelInfo info, @RequestHeader
    HttpHeaders headers) {
        TravelPlanController.LOGGER.info("[getTransferSearch][Search Transit][start: {},end: {}]", info.getStartStation(), info.getEndStation());
        return ok(travelPlanService.getTransferSearch(info, headers));
    }

    @PostMapping("/travelPlan/cheapest")
    public HttpEntity getByCheapest(@RequestBody
    TripInfo queryInfo, @RequestHeader
    HttpHeaders headers) {
        TravelPlanController.LOGGER.info("[getCheapest][Search Cheapest][start: {},end: {},time: {}]", queryInfo.getStartPlace(), queryInfo.getEndPlace(), queryInfo.getDepartureTime());
        return ok(travelPlanService.getCheapest(queryInfo, headers));
    }

    @PostMapping("/travelPlan/quickest")
    public HttpEntity getByQuickest(@RequestBody
    TripInfo queryInfo, @RequestHeader
    HttpHeaders headers) {
        TravelPlanController.LOGGER.info("[getQuickest][Search Quickest][start: {},end: {},time: {}]", queryInfo.getStartPlace(), queryInfo.getEndPlace(), queryInfo.getDepartureTime());
        return ok(travelPlanService.getQuickest(queryInfo, headers));
    }

    @PostMapping("/travelPlan/minStation")
    public HttpEntity getByMinStation(@RequestBody
    TripInfo queryInfo, @RequestHeader
    HttpHeaders headers) {
        TravelPlanController.LOGGER.info("[getMinStation][Search Min Station][start: {},end: {},time: {}]", queryInfo.getStartPlace(), queryInfo.getEndPlace(), queryInfo.getDepartureTime());
        return ok(travelPlanService.getMinStation(queryInfo, headers));
    }
}