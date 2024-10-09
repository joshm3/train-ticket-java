package modules.tstravelservice.travel.controller;
import java.util.ArrayList;
import modules.tscommon.edu.fudan.common.entity.TravelInfo;
import modules.tscommon.edu.fudan.common.entity.TripAllDetailInfo;
import modules.tscommon.edu.fudan.common.entity.TripInfo;
import modules.tscommon.edu.fudan.common.entity.TripResponse;
import modules.tstravelservice.travel.service.TravelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.ResponseEntity.ok;
/**
 *
 * @author fdse
 */
@RestController
@RequestMapping("/api/v1/travelservice")
public class TravelController {
    @Autowired
    private TravelService travelService;

    private static final Logger LOGGER = LoggerFactory.getLogger(TravelController.class);

    @GetMapping(path = "/welcome")
    public String home(@RequestHeader
    HttpHeaders headers) {
        return "Welcome to [ Travel Service ] !";
    }

    @GetMapping("/train_types/{tripId}")
    public HttpEntity getTrainTypeByTripId(@PathVariable
    String tripId, @RequestHeader
    HttpHeaders headers) {
        // TrainType
        TravelController.LOGGER.info("[getTrainTypeByTripId][Get train Type by Trip id][TripId: {}]", tripId);
        return ok(travelService.getTrainTypeByTripId(tripId, headers));
    }

    @GetMapping("/routes/{tripId}")
    public HttpEntity getRouteByTripId(@PathVariable
    String tripId, @RequestHeader
    HttpHeaders headers) {
        TravelController.LOGGER.info("[getRouteByTripId][Get Route By Trip ID][TripId: {}]", tripId);
        // Route
        return ok(travelService.getRouteByTripId(tripId, headers));
    }

    @PostMapping("/trips/routes")
    public HttpEntity getTripsByRouteId(@RequestBody
    ArrayList<String> routeIds, @RequestHeader
    HttpHeaders headers) {
        // ArrayList<ArrayList<Trip>>
        TravelController.LOGGER.info("[getTripByRoute][Get Trips by Route ids][RouteIds: {}]", routeIds.size());
        return ok(travelService.getTripByRoute(routeIds, headers));
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/trips")
    public HttpEntity<?> createTrip(@RequestBody
    TravelInfo routeIds, @RequestHeader
    HttpHeaders headers) {
        // null
        TravelController.LOGGER.info("[create][Create trip][TripId: {}]", routeIds.getTripId());
        return new ResponseEntity<>(travelService.create(routeIds, headers), HttpStatus.CREATED);
    }

    /**
     * Return Trip only, no left ticket information
     *
     * @param tripId
     * 		trip id
     * @param headers
     * 		headers
     * @return HttpEntity
     */
    @CrossOrigin(origins = "*")
    @GetMapping("/trips/{tripId}")
    public HttpEntity retrieve(@PathVariable
    String tripId, @RequestHeader
    HttpHeaders headers) {
        // Trip
        TravelController.LOGGER.info("[retrieve][Retrieve trip][TripId: {}]", tripId);
        return ok(travelService.retrieve(tripId, headers));
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/trips")
    public HttpEntity updateTrip(@RequestBody
    TravelInfo info, @RequestHeader
    HttpHeaders headers) {
        // Trip
        TravelController.LOGGER.info("[update][Update trip][TripId: {}]", info.getTripId());
        return ok(travelService.update(info, headers));
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/trips/{tripId}")
    public HttpEntity deleteTrip(@PathVariable
    String tripId, @RequestHeader
    HttpHeaders headers) {
        // string
        TravelController.LOGGER.info("[delete][Delete trip][TripId: {}]", tripId);
        return ok(travelService.delete(tripId, headers));
    }

    /**
     * Return Trips and the remaining tickets
     *
     * @param info
     * 		trip info
     * @param headers
     * 		headers
     * @return HttpEntity
     */
    @CrossOrigin(origins = "*")
    @PostMapping("/trips/left")
    public HttpEntity queryInfo(@RequestBody
    TripInfo info, @RequestHeader
    HttpHeaders headers) {
        if (((((info.getStartPlace() == null) || (info.getStartPlace().length() == 0)) || (info.getEndPlace() == null)) || (info.getEndPlace().length() == 0)) || (info.getDepartureTime() == null)) {
            TravelController.LOGGER.info("[query][Travel Query Fail][Something null]");
            ArrayList<TripResponse> errorList = new ArrayList<>();
            return ok(errorList);
        }
        TravelController.LOGGER.info("[query][Query TripResponse]");
        return ok(travelService.queryByBatch(info, headers));
    }

    /**
     * Return Trips and the remaining tickets
     *
     * @param info
     * 		trip info
     * @param headers
     * 		headers
     * @return HttpEntity
     */
    @CrossOrigin(origins = "*")
    @PostMapping("/trips/left_parallel")
    public HttpEntity queryInfoInparallel(@RequestBody
    TripInfo info, @RequestHeader
    HttpHeaders headers) {
        if (((((info.getStartPlace() == null) || (info.getStartPlace().length() == 0)) || (info.getEndPlace() == null)) || (info.getEndPlace().length() == 0)) || (info.getDepartureTime() == null)) {
            TravelController.LOGGER.info("[queryInParallel][Travel Query Fail][Something null]");
            ArrayList<TripResponse> errorList = new ArrayList<>();
            return ok(errorList);
        }
        TravelController.LOGGER.info("[queryInParallel][Query TripResponse]");
        return ok(travelService.queryInParallel(info, headers));
    }

    /**
     * Return a Trip and the remaining
     *
     * @param gtdi
     * 		trip all detail info
     * @param headers
     * 		headers
     * @return HttpEntity
     */
    @CrossOrigin(origins = "*")
    @PostMapping("/trip_detail")
    public HttpEntity getTripAllDetailInfo(@RequestBody
    TripAllDetailInfo gtdi, @RequestHeader
    HttpHeaders headers) {
        // TripAllDetailInfo
        // TripAllDetail tripAllDetail
        TravelController.LOGGER.info("[getTripAllDetailInfo][Get trip detail][TripId: {}]", gtdi.getTripId());
        return ok(travelService.getTripAllDetailInfo(gtdi, headers));
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/trips")
    public HttpEntity queryAll(@RequestHeader
    HttpHeaders headers) {
        // List<Trip>
        TravelController.LOGGER.info("[queryAll][Query all trips]");
        return ok(travelService.queryAll(headers));
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/admin_trip")
    public HttpEntity adminQueryAll(@RequestHeader
    HttpHeaders headers) {
        // ArrayList<AdminTrip>
        TravelController.LOGGER.info("[adminQueryAll][Admin query all trips]");
        return ok(travelService.adminQueryAll(headers));
    }
}