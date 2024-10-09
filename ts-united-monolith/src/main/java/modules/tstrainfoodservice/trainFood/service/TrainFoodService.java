package modules.tstrainfoodservice.trainFood.service;
import modules.tscommon.edu.fudan.common.util.Response;
import modules.tstrainfoodservice.trainFood.entity.TrainFood;
import org.springframework.http.HttpHeaders;
public interface TrainFoodService {
    TrainFood createTrainFood(TrainFood tf, HttpHeaders headers);

    Response listTrainFood(HttpHeaders headers);

    Response listTrainFoodByTripId(String tripId, HttpHeaders headers);
}