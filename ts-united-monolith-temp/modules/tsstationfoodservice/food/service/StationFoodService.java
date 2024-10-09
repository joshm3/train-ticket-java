package modules.tsstationfoodservice.food.service;
import java.util.List;
import modules.tscommon.edu.fudan.common.util.Response;
import modules.tsstationfoodservice.food.entity.StationFoodStore;
import org.springframework.http.HttpHeaders;
public interface StationFoodService {
    // create data
    Response createFoodStore(StationFoodStore fs, HttpHeaders headers);

    // TrainFood createTrainFood(TrainFood tf, HttpHeaders headers);
    // query all food
    Response listFoodStores(HttpHeaders headers);

    // Response listTrainFood(HttpHeaders headers);
    // query according id
    Response listFoodStoresByStationName(String stationName, HttpHeaders headers);

    // Response listTrainFoodByTripId(String tripId, HttpHeaders headers);
    Response getStaionFoodStoreById(String id);

    Response getFoodStoresByStationNames(List<String> stationNames);
}