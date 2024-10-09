package modules.tsfoodservice.foodsearch.service;
import java.util.List;
import modules.tscommon.edu.fudan.common.util.Response;
import modules.tsfoodservice.foodsearch.entity.FoodOrder;
import org.springframework.http.HttpHeaders;
public interface FoodService {
    Response createFoodOrder(FoodOrder afoi, HttpHeaders headers);

    Response createFoodOrdersInBatch(List<FoodOrder> orders, HttpHeaders headers);

    Response deleteFoodOrder(String orderId, HttpHeaders headers);

    Response findByOrderId(String orderId, HttpHeaders headers);

    Response updateFoodOrder(FoodOrder updateFoodOrder, HttpHeaders headers);

    Response findAllFoodOrder(HttpHeaders headers);

    Response getAllFood(String date, String startStation, String endStation, String tripId, HttpHeaders headers);
}