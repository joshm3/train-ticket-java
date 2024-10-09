package modules.tsfooddeliveryservice.food_delivery.repository;
import java.util.List;
import modules.tsfooddeliveryservice.food_delivery.entity.FoodDeliveryOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface FoodDeliveryOrderRepository extends CrudRepository<FoodDeliveryOrder, String> {
    List<FoodDeliveryOrder> findByStationFoodStoreId(String stationFoodStoreId);

    @Override
    List<FoodDeliveryOrder> findAll();
}