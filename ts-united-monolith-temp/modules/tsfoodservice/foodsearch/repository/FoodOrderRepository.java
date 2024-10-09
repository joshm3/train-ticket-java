package modules.tsfoodservice.foodsearch.repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import modules.tsfoodservice.foodsearch.entity.FoodOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface FoodOrderRepository extends CrudRepository<FoodOrder, String> {
    Optional<FoodOrder> findById(String id);

    FoodOrder findByOrderId(String orderId);

    @Override
    List<FoodOrder> findAll();

    void deleteById(UUID id);

    void deleteFoodOrderByOrderId(String id);
}