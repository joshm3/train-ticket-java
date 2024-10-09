package modules.tsfoodservice;
import modules.tsfoodservice.foodsearch.controller.FoodController;
import modules.tsfoodservice.foodsearch.entity.FoodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
@Component
public class TsfoodserviceApi {
    @Autowired
    FoodController foodController;

    public HttpEntity postApiV1FoodserviceOrders(FoodOrder addFoodOrder, HttpHeaders headers) {
        return foodController.createFoodOrder(addFoodOrder, headers);
    }
}