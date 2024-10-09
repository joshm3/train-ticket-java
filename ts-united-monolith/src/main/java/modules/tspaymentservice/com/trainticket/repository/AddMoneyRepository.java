package modules.tspaymentservice.com.trainticket.repository;
import modules.tspaymentservice.com.trainticket.entity.Money;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author fdse
 */
@Repository
public interface AddMoneyRepository extends CrudRepository<Money, String> {}