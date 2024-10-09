package modules.tsorderservice.order.repository;
import java.util.ArrayList;
import java.util.Optional;
import modules.tsorderservice.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author fdse
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, String> {
    @Override
    Optional<Order> findById(String id);

    @Override
    ArrayList<Order> findAll();

    ArrayList<Order> findByAccountId(String accountId);

    ArrayList<Order> findByTravelDateAndTrainNumber(String travelDate, String trainNumber);

    @Override
    void deleteById(String id);
}