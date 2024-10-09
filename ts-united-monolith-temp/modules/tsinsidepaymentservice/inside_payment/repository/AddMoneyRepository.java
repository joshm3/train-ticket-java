package modules.tsinsidepaymentservice.inside_payment.repository;
import java.util.List;
import modules.tsinsidepaymentservice.inside_payment.entity.Money;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author fdse
 */
public interface AddMoneyRepository extends CrudRepository<Money, String> {
    /**
     * find by user id
     *
     * @param userId
     * 		user id
     * @return List<Money>
     */
    List<Money> findByUserId(String userId);

    /**
     * find all
     *
     * @return List<Money>
     */
    @Override
    List<Money> findAll();
}