package modules.tsfooddeliveryservice.food_delivery.service;
import modules.tscommon.edu.fudan.common.util.Response;
import modules.tsfooddeliveryservice.food_delivery.entity.DeliveryInfo;
import modules.tsfooddeliveryservice.food_delivery.entity.FoodDeliveryOrder;
import modules.tsfooddeliveryservice.food_delivery.entity.SeatInfo;
import modules.tsfooddeliveryservice.food_delivery.entity.TripOrderInfo;
import org.springframework.http.HttpHeaders;
public interface FoodDeliveryService {
    Response createFoodDeliveryOrder(FoodDeliveryOrder fd, HttpHeaders headers);

    Response deleteFoodDeliveryOrder(String id, HttpHeaders headers);

    Response getFoodDeliveryOrderById(String id, HttpHeaders headers);

    Response getAllFoodDeliveryOrders(HttpHeaders headers);

    Response getFoodDeliveryOrderByStoreId(String storeId, HttpHeaders headers);

    Response updateTripId(TripOrderInfo tripOrderInfo, HttpHeaders headers);

    Response updateSeatNo(SeatInfo seatInfo, HttpHeaders headers);

    Response updateDeliveryTime(DeliveryInfo deliveryInfo, HttpHeaders headers);
}