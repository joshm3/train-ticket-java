package modules.tsinsidepaymentservice.inside_payment.repository;
import java.util.List;
import modules.tsinsidepaymentservice.inside_payment.entity.MoneyFromtsinsidepaymentservice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author fdse
 */
@Repository("addMoneyRepositoryFromtsinsidepaymentservice")
public interface AddMoneyRepository extends CrudRepository<MoneyFromtsinsidepaymentservice, String> {
    /**
     * find by user id
     *
     * @param userId
     * 		user id
     * @return List<Money>
     */
    List<MoneyFromtsinsidepaymentservice> findByUserId(String userId);

    /**
     * find all
     *
     * @return List<Money>
     */
    @Override
    List<MoneyFromtsinsidepaymentservice> findAll();
}