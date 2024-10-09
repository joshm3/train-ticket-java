package modules.tstravel2service.travel2.service;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;
import javax.transaction.Transactional;
import modules.tscommon.edu.fudan.common.entity.Route;
import modules.tscommon.edu.fudan.common.entity.Seat;
import modules.tscommon.edu.fudan.common.entity.SeatClass;
import modules.tscommon.edu.fudan.common.entity.TrainType;
import modules.tscommon.edu.fudan.common.entity.TravelInfo;
import modules.tscommon.edu.fudan.common.entity.TravelResult;
import modules.tscommon.edu.fudan.common.entity.TripAllDetailInfo;
import modules.tscommon.edu.fudan.common.entity.TripId;
import modules.tscommon.edu.fudan.common.entity.TripInfo;
import modules.tscommon.edu.fudan.common.entity.TripResponse;
import modules.tscommon.edu.fudan.common.util.JsonUtils;
import modules.tscommon.edu.fudan.common.util.Response;
import modules.tscommon.edu.fudan.common.util.StringUtils;
import modules.tstravel2service.Tstravel2serviceClient;
import modules.tstravel2service.travel2.entity.AdminTrip;
import modules.tstravel2service.travel2.entity.Travel;
import modules.tstravel2service.travel2.entity.TripAllDetail;
import modules.tstravel2service.travel2.entity.TripFromtstravel2service;
import modules.tstravel2service.travel2.repository.TripRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
/**
 *
 * @author fdse
 */
@Service("travelServiceImplFromtstravel2service")
public class TravelServiceImpl implements TravelService {
    @Autowired
    Tstravel2serviceClient tstravel2serviceClient;

    @Autowired
    TripRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    private static final Logger LOGGER = LoggerFactory.getLogger(TravelServiceImpl.class);

    private String getServiceUrl(String serviceName) {
        return "http://" + serviceName;
    }

    String success = "Success";

    String noCnontent = "No Content";

    @Override
    public Response getRouteByTripId(String tripId, HttpHeaders headers) {
        TripId tripId1 = new TripId(tripId);
        TripFromtstravel2service trip = repository.findByTripId(tripId1);
        if (trip == null) {
            TravelServiceImpl.LOGGER.error("[getRouteByTripId][Get Route By Trip ID Fail][Trip Not Found][TripId: {}]", tripId);
            return new Response(0, "\"[Get Route By Trip ID] Trip Not Found:\" + tripId", null);
        } else {
            Route route = getRouteByRouteId(trip.getRouteId(), headers);
            if (route == null) {
                TravelServiceImpl.LOGGER.error("[getRouteByTripId][Get route by Trip id error][Route not found][RouteId: {}]", trip.getRouteId());
                return new Response(0, "\"[Get Route By Trip ID] Route Not Found:\" + trip.getRouteId()", null);
            } else {
                TravelServiceImpl.LOGGER.info("[getRouteByTripId][Get Route By Trip ID Success]");
                return new Response(1, "[Get Route By Trip ID] Success", route);
            }
        }
    }

    @Override
    public Response getTrainTypeByTripId(String tripId, HttpHeaders headers) {
        TripId tripId1 = new TripId(tripId);
        TrainType trainType = null;
        TripFromtstravel2service trip = repository.findByTripId(tripId1);
        if (trip != null) {
            trainType = getTrainTypeByName(trip.getTrainTypeName(), headers);
        } else {
            TravelServiceImpl.LOGGER.error("[getTrainTypeByTripId[]Get Train Type by Trip id error][Trip not found][TripId: {}]", tripId);
        }
        if (trainType != null) {
            return new Response(1, "Success query Train by trip id", trainType);
        } else {
            TravelServiceImpl.LOGGER.error("[getTrainTypeByTripId][Get Train Type by Trip id error][Train Type not found][TripId: {}]", tripId);
            return new Response(0, noCnontent, null);
        }
    }

    @Override
    public Response getTripByRoute(ArrayList<String> routeIds, HttpHeaders headers) {
        ArrayList<ArrayList<TripFromtstravel2service>> tripList = new ArrayList<>();
        for (String routeId : routeIds) {
            ArrayList<TripFromtstravel2service> tempTripList = repository.findByRouteId(routeId);
            if (tempTripList == null) {
                tempTripList = new ArrayList<>();
            }
            tripList.add(tempTripList);
        }
        if (!tripList.isEmpty()) {
            return new Response(1, success, tripList);
        } else {
            TravelServiceImpl.LOGGER.warn("[getTripByRoute][Get Trips by Route ids warn][Trips not found][RouteIdNumber: {}]", routeIds.size());
            return new Response(0, noCnontent, null);
        }
    }

    @Override
    public Response create(TravelInfo info, HttpHeaders headers) {
        TripId ti = new TripId(info.getTripId());
        if (repository.findByTripId(ti) == null) {
            TripFromtstravel2service trip = new TripFromtstravel2service(ti, info.getTrainTypeName(), info.getStartStationName(), info.getStationsName(), info.getTerminalStationName(), info.getStartTime(), info.getEndTime());
            trip.setRouteId(info.getRouteId());
            repository.save(trip);
            return new Response(1, ("Create trip info:" + ti.toString()) + ".", null);
        } else {
            TravelServiceImpl.LOGGER.error("[getTripByRoute][Create trip error][Trip already exists][TripId: {}]", info.getTripId());
            return new Response(1, ("Trip " + info.getTripId()) + " already exists", null);
        }
    }

    @Override
    public Response retrieve(String tripId, HttpHeaders headers) {
        TripId ti = new TripId(tripId);
        TripFromtstravel2service trip = repository.findByTripId(ti);
        if (trip != null) {
            return new Response(1, "Search Trip Success by Trip Id " + tripId, trip);
        } else {
            TravelServiceImpl.LOGGER.error("[retrieve][Retrieve trip error][Trip not found][TripId: {}]", tripId);
            return new Response(0, "No Content according to tripId" + tripId, null);
        }
    }

    @Override
    public Response update(TravelInfo info, HttpHeaders headers) {
        TripId ti = new TripId(info.getTripId());
        TripFromtstravel2service t = repository.findByTripId(ti);
        if (t != null) {
            t.setStartStationName(info.getTrainTypeName());
            t.setStartStationName(info.getStartStationName());
            t.setStationsName(info.getStationsName());
            t.setTerminalStationName(info.getTerminalStationName());
            t.setStartTime(info.getStartTime());
            t.setEndTime(info.getEndTime());
            t.setRouteId(info.getRouteId());
            repository.save(t);
            return new Response(1, "Update trip info:" + ti.toString(), t);
        } else {
            TravelServiceImpl.LOGGER.error("[update][Update trip error][Trip not found][TripId: {}]", info.getTripId());
            return new Response(1, ("Trip" + info.getTripId()) + "doesn 't exists", null);
        }
    }

    @Override
    @Transactional
    public Response delete(String tripId, HttpHeaders headers) {
        TripId ti = new TripId(tripId);
        if (repository.findByTripId(ti) != null) {
            repository.deleteByTripId(ti);
            return new Response(1, ("Delete trip:" + tripId) + ".", tripId);
        } else {
            TravelServiceImpl.LOGGER.error("[delete][Delete trip error][Trip not found][TripId: {}]", tripId);
            return new Response(0, ("Trip " + tripId) + " doesn't exist.", null);
        }
    }

    @Override
    public Response queryByBatch(TripInfo info, HttpHeaders headers) {
        // Gets the start and arrival stations of the train number to query. The originating and arriving stations received here are both station names, so two requests need to be sent to convert to station ids
        String startPlaceName = info.getStartPlace();
        String endPlaceName = info.getEndPlace();
        // This is the final result
        List<TripResponse> list = new ArrayList<>();
        // Check all train info
        List<TripFromtstravel2service> allTripList = repository.findAll();
        list = getTicketsByBatch(allTripList, startPlaceName, endPlaceName, info.getDepartureTime(), headers);
        return new Response(1, success, list);
    }

    @Override
    public Response query(TripInfo info, HttpHeaders headers) {
        // Gets the start and arrival stations of the train number to query. The originating and arriving stations received here are both station names, so two requests need to be sent to convert to station ids
        String StartPlaceName = info.getStartPlace();
        String endPlaceName = info.getEndPlace();
        // This is the final result
        ArrayList<TripResponse> list = new ArrayList<>();
        // Check all train info
        ArrayList<TripFromtstravel2service> allTripList = repository.findAll();
        if (allTripList != null) {
            for (TripFromtstravel2service tempTrip : allTripList) {
                // Get the detailed route list of this train
                TripResponse response = getTickets(tempTrip, null, StartPlaceName, endPlaceName, info.getDepartureTime(), headers);
                if (response == null) {
                    TravelServiceImpl.LOGGER.warn("[query][Query trip error][Tickets not found][start: {},end: {},time: {}]", StartPlaceName, endPlaceName, info.getDepartureTime());
                } else {
                    list.add(response);
                }
            }
        }
        return new Response(1, "Success Query", list);
    }

    @Override
    public Response getTripAllDetailInfo(TripAllDetailInfo gtdi, HttpHeaders headers) {
        TripAllDetail gtdr = new TripAllDetail();
        TravelServiceImpl.LOGGER.debug("[getTripAllDetailInfo][gtdi info: {}]", gtdi.toString());
        TripFromtstravel2service trip = repository.findByTripId(new TripId(gtdi.getTripId()));
        if (trip == null) {
            gtdr.setTripResponse(null);
            gtdr.setTrip(null);
            TravelServiceImpl.LOGGER.error("[getTripAllDetailInfo][Get trip detail error][Trip not found][TripId: {}]", gtdi.getTripId());
            return new Response(0, "Trip not found", gtdr);
        } else {
            String endPlaceName = gtdi.getTo();
            String StartPlaceName = gtdi.getFrom();
            TripResponse tripResponse = getTickets(trip, null, gtdi.getFrom(), gtdi.getTo(), gtdi.getTravelDate(), headers);
            if (tripResponse == null) {
                gtdr.setTrip(null);
                gtdr.setTripResponse(null);
                TravelServiceImpl.LOGGER.warn("[getTripAllDetailInfo][Query trip error][Tickets not found][start: {},end: {}]", gtdi.getTo(), gtdi.getFrom());
                return new Response(0, "getTickets failed", gtdr);
            } else {
                gtdr.setTripResponse(tripResponse);
                gtdr.setTrip(repository.findByTripId(new TripId(gtdi.getTripId())));
            }
        }
        return new Response(1, success, gtdr);
    }

    private List<TripResponse> getTicketsByBatch(List<TripFromtstravel2service> trips, String startPlaceName, String endPlaceName, String departureTime, HttpHeaders headers) {
        List<TripResponse> responses = new ArrayList<>();
        // Determine if the date checked is the same day and after
        if (!afterToday(departureTime)) {
            TravelServiceImpl.LOGGER.info("[getTickets][depaturetime not vailid][departuretime: {}]", departureTime);
            return responses;
        }
        List<Travel> infos = new ArrayList<>();
        Map<String, TripFromtstravel2service> tripMap = new HashMap<>();
        for (TripFromtstravel2service trip : trips) {
            Travel query = new Travel();
            query.setTrip(trip);
            query.setStartPlace(startPlaceName);
            query.setEndPlace(endPlaceName);
            query.setDepartureTime(departureTime);
            infos.add(query);
            tripMap.put(trip.getTripId().toString(), trip);
        }
        TravelServiceImpl.LOGGER.info("[getTicketsByBatch][before get basic][trips: {}]", trips);
        HttpEntity requestEntity = new HttpEntity(infos, null);
        String basic_service_url = getServiceUrl("ts-basic-service");
        ResponseEntity<Response> re = tstravel2serviceClient.postApiV1BasicserviceBasicTravels(infos, null);
        Response r = re.getBody();
        if (r.getStatus() == 0) {
            TravelServiceImpl.LOGGER.info("[getTicketsByBatch][Ts-basic-service response status is 0][response is: {}]", r);
            return responses;
        }
        Map<String, TravelResult> trMap;
        ObjectMapper mapper = new ObjectMapper();
        try {
            trMap = mapper.readValue(JsonUtils.object2Json(r.getData()), new TypeReference<Map<String, TravelResult>>() {});
        } catch (Exception e) {
            TravelServiceImpl.LOGGER.warn("[getTicketsByBatch][Ts-basic-service convert data failed][Fail msg: {}]", e.getMessage());
            return responses;
        }
        for (Map.Entry<String, TravelResult> trEntry : trMap.entrySet()) {
            // Set the returned ticket information
            String tripNumber = trEntry.getKey();
            TravelResult tr = trEntry.getValue();
            TripFromtstravel2service trip = tripMap.get(tripNumber);
            TripResponse response = setResponse(trip, tr, startPlaceName, endPlaceName, departureTime, headers);
            responses.add(response);
        }
        return responses;
    }

    private TripResponse getTickets(TripFromtstravel2service trip, Route route1, String startPlaceName, String endPlaceName, String departureTime, HttpHeaders headers) {
        // Determine if the date checked is the same day and after
        if (!afterToday(departureTime)) {
            return null;
        }
        Travel query = new Travel();
        query.setTrip(trip);
        query.setStartPlace(startPlaceName);
        query.setEndPlace(endPlaceName);
        query.setDepartureTime(departureTime);
        HttpEntity requestEntity = new HttpEntity(query, null);
        String basic_service_url = getServiceUrl("ts-basic-service");
        ResponseEntity<Response<TravelResult>> re = tstravel2serviceClient.postApiV1BasicserviceBasicTravel(query, null);
        Response r = re.getBody();
        if (r.getStatus() == 0) {
            TravelServiceImpl.LOGGER.info("[getTickets][Ts-basic-service response status is 0][response is: {}]", r);
            return null;
        }
        TravelResult resultForTravel = re.getBody().getData();
        // Set the returned ticket information
        return setResponse(trip, resultForTravel, startPlaceName, endPlaceName, departureTime, headers);
    }

    private TripResponse setResponse(TripFromtstravel2service trip, TravelResult tr, String startPlaceName, String endPlaceName, String departureTime, HttpHeaders headers) {
        // Set the returned ticket information
        TripResponse response = new TripResponse();
        response.setConfortClass(50);
        response.setEconomyClass(50);
        Route route = tr.getRoute();
        List<String> stationList = route.getStations();
        int firstClassTotalNum = tr.getTrainType().getConfortClass();
        int secondClassTotalNum = tr.getTrainType().getEconomyClass();
        int first = getRestTicketNumber(departureTime, trip.getTripId().toString(), startPlaceName, endPlaceName, SeatClass.FIRSTCLASS.getCode(), firstClassTotalNum, stationList, headers);
        int second = getRestTicketNumber(departureTime, trip.getTripId().toString(), startPlaceName, endPlaceName, SeatClass.SECONDCLASS.getCode(), secondClassTotalNum, stationList, headers);
        response.setConfortClass(first);
        response.setEconomyClass(second);
        response.setStartStation(startPlaceName);
        response.setTerminalStation(endPlaceName);
        // Calculate the distance from the starting point
        int indexStart = route.getStations().indexOf(startPlaceName);
        int indexEnd = route.getStations().indexOf(endPlaceName);
        int distanceStart = route.getDistances().get(indexStart) - route.getDistances().get(0);
        int distanceEnd = route.getDistances().get(indexEnd) - route.getDistances().get(0);
        TrainType trainType = tr.getTrainType();
        // Train running time is calculated according to the average running speed of the train
        int minutesStart = (60 * distanceStart) / trainType.getAverageSpeed();
        int minutesEnd = (60 * distanceEnd) / trainType.getAverageSpeed();
        Calendar calendarStart = Calendar.getInstance();
        calendarStart.setTime(StringUtils.String2Date(trip.getStartTime()));
        calendarStart.add(Calendar.MINUTE, minutesStart);
        response.setStartTime(StringUtils.Date2String(calendarStart.getTime()));
        TravelServiceImpl.LOGGER.info("[getTickets][Calculate distance][calculate time?{}  time: {}]", minutesStart, calendarStart.getTime());
        Calendar calendarEnd = Calendar.getInstance();
        calendarEnd.setTime(StringUtils.String2Date(trip.getStartTime()));
        calendarEnd.add(Calendar.MINUTE, minutesEnd);
        response.setEndTime(StringUtils.Date2String(calendarEnd.getTime()));
        TravelServiceImpl.LOGGER.info("[getTickets][Calculate distance][calculate time?{}  time: {}]", minutesEnd, calendarEnd.getTime());
        response.setTripId(trip.getTripId());
        response.setTrainTypeName(trip.getTrainTypeName());
        response.setPriceForConfortClass(tr.getPrices().get("confortClass"));
        response.setPriceForEconomyClass(tr.getPrices().get("economyClass"));
        return response;
    }

    @Override
    public Response queryAll(HttpHeaders headers) {
        List<TripFromtstravel2service> tripList = repository.findAll();
        if ((tripList != null) && (!tripList.isEmpty())) {
            return new Response(1, success, tripList);
        }
        TravelServiceImpl.LOGGER.warn("[queryAll][Query all trips warn][{}]", "No Content");
        return new Response(0, noCnontent, null);
    }

    private static boolean afterToday(String date) {
        Calendar calDateA = Calendar.getInstance();
        Date today = new Date();
        calDateA.setTime(today);
        Calendar calDateB = Calendar.getInstance();
        calDateB.setTime(StringUtils.String2Date(date));
        if (calDateA.get(Calendar.YEAR) > calDateB.get(Calendar.YEAR)) {
            return false;
        } else if (calDateA.get(Calendar.YEAR) == calDateB.get(Calendar.YEAR)) {
            if (calDateA.get(Calendar.MONTH) > calDateB.get(Calendar.MONTH)) {
                return false;
            } else if (calDateA.get(Calendar.MONTH) == calDateB.get(Calendar.MONTH)) {
                return calDateA.get(Calendar.DAY_OF_MONTH) <= calDateB.get(Calendar.DAY_OF_MONTH);
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    private TrainType getTrainTypeByName(String trainTypeName, HttpHeaders headers) {
        HttpEntity requestEntity = new HttpEntity(null);
        String train_service_url = getServiceUrl("ts-train-service");
        ResponseEntity<Response<TrainType>> re = tstravel2serviceClient.getApiV1TrainserviceTrainsBynamePathvariable(trainTypeName, null);
        return re.getBody().getData();
    }

    private Route getRouteByRouteId(String routeId, HttpHeaders headers) {
        TravelServiceImpl.LOGGER.debug("[getRouteByRouteId][Get Route By Id][Route ID?{}]", routeId);
        HttpEntity requestEntity = new HttpEntity(null);
        String route_service_url = getServiceUrl("ts-route-service");
        ResponseEntity<Response> re = tstravel2serviceClient.getApiV1RouteserviceRoutesPathvariable(routeId, null);
        Response result = re.getBody();
        if (result.getStatus() == 0) {
            TravelServiceImpl.LOGGER.error("[getRouteByRouteId][Get Route By Id Fail][Route not found][RouteId: {}]", routeId);
            return null;
        } else {
            TravelServiceImpl.LOGGER.info("[getRouteByRouteId][Get Route By Id Success]");
            return JsonUtils.conveterObject(result.getData(), Route.class);
        }
    }

    private int getRestTicketNumber(String travelDate, String trainNumber, String startStationName, String endStationName, int seatType, int totalNum, List<String> stationList, HttpHeaders headers) {
        Seat seatRequest = new Seat();
        seatRequest.setDestStation(endStationName);
        seatRequest.setStartStation(startStationName);
        seatRequest.setTrainNumber(trainNumber);
        seatRequest.setTravelDate(travelDate);
        seatRequest.setSeatType(seatType);
        seatRequest.setTotalNum(totalNum);
        seatRequest.setStations(stationList);
        TravelServiceImpl.LOGGER.info("[getRestTicketNumber][Seat request][request: {}]", seatRequest.toString());
        HttpEntity requestEntity = new HttpEntity(seatRequest, null);
        String seat_service_url = getServiceUrl("ts-seat-service");
        ResponseEntity<Response<Integer>> re = tstravel2serviceClient.postApiV1SeatserviceSeatsLeft_tickets(seatRequest, null);
        TravelServiceImpl.LOGGER.info("[getRestTicketNumber][Get Rest tickets num][num is: {}]", re.getBody().toString());
        return re.getBody().getData();
    }

    @Override
    public Response adminQueryAll(HttpHeaders headers) {
        List<TripFromtstravel2service> trips = repository.findAll();
        ArrayList<AdminTrip> adminTrips = new ArrayList<>();
        if (trips != null) {
            for (TripFromtstravel2service trip : trips) {
                AdminTrip adminTrip = new AdminTrip();
                adminTrip.setRoute(getRouteByRouteId(trip.getRouteId(), headers));
                adminTrip.setTrainType(getTrainTypeByName(trip.getTrainTypeName(), headers));
                adminTrip.setTrip(trip);
                adminTrips.add(adminTrip);
            }
        }
        if (!adminTrips.isEmpty()) {
            return new Response(1, "Travel Service Admin Query All Travel Success", adminTrips);
        } else {
            TravelServiceImpl.LOGGER.warn("[adminQueryAll][Admin query all trips warn][{}]", "No Content");
            return new Response(0, noCnontent, null);
        }
    }
}