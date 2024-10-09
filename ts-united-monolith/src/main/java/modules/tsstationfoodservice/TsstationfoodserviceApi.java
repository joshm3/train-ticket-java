package modules.tsstationfoodservice;
import java.util.List;
import modules.tsstationfoodservice.food.controller.StationFoodController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
@Component
public class TsstationfoodserviceApi {
    @Autowired
    StationFoodController stationFoodController;

    public HttpEntity getApiV1StationfoodserviceStationfoodstoresBystoreidPathvariable(String stationFoodStoreId, HttpHeaders headers) {
        return stationFoodController.getFoodListByStationFoodStoreId(stationFoodStoreId, headers);
    }

    public HttpEntity postApiV1StationfoodserviceStationfoodstores(List<String> stationNameList) {
        return stationFoodController.getFoodStoresByStationNames(stationNameList);
    }
}