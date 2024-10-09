package modules.tsbasicservice.fdse.microservice.controller;
import java.util.List;
import modules.tsbasicservice.fdse.microservice.service.BasicService;
import modules.tscommon.edu.fudan.common.entity.Travel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.ResponseEntity.ok;
/**
 *
 * @author Chenjie
 * @date 2017/6/6.
 */
@RestController
@RequestMapping("/api/v1/basicservice")
public class BasicController {
    @Autowired
    BasicService service;

    private static final Logger logger = LoggerFactory.getLogger(BasicController.class);

    @GetMapping(path = "/welcome")
    public String home(@RequestHeader
    HttpHeaders headers) {
        return "Welcome to [ Basic Service ] !";
    }

    @PostMapping("/basic/travel")
    public HttpEntity queryForTravel(@RequestBody
    Travel info, @RequestHeader
    HttpHeaders headers) {
        // TravelResult
        logger.info("[queryForTravel][Query for travel][Travel: {}]", info.toString());
        return ok(service.queryForTravel(info, headers));
    }

    @PostMapping("/basic/travels")
    public HttpEntity queryForTravels(@RequestBody
    List<Travel> infos, @RequestHeader
    HttpHeaders headers) {
        // TravelResult
        logger.info("[queryForTravels][Query for travels][Travels: {}]", infos);
        return ok(service.queryForTravels(infos, headers));
    }

    @GetMapping("/basic/{stationName}")
    public HttpEntity queryForStationId(@PathVariable
    String stationName, @RequestHeader
    HttpHeaders headers) {
        // String id
        logger.info("[queryForStationId][Query for stationId by stationName][stationName: {}]", stationName);
        return ok(service.queryForStationId(stationName, headers));
    }
}