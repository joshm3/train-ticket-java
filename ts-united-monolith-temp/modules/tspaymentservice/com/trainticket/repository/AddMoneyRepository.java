package modules.tspaymentservice.com.trainticket.repository;
import modules.tspaymentservice.com.trainticket.entity.Money;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author fdse
 */
public interface AddMoneyRepository extends CrudRepository<Money, String> {}