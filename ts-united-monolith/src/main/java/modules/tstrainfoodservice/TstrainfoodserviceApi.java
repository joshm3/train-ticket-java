package modules.tstrainfoodservice;
import modules.tstrainfoodservice.trainFood.controller.TrainFoodController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
@Component
public class TstrainfoodserviceApi {
    @Autowired
    TrainFoodController trainFoodController;

    public HttpEntity getApiV1TrainfoodserviceTrainfoodsPathvariable(String tripId, HttpHeaders headers) {
        return trainFoodController.getTrainFoodOfTrip(tripId, headers);
    }
}