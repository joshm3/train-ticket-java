package modules.tsinsidepaymentservice.inside_payment.repository;
import java.util.List;
import java.util.Optional;
import modules.tsinsidepaymentservice.inside_payment.entity.PaymentFromtsinsidepaymentservice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author fdse
 */
@Repository("paymentRepositoryFromtsinsidepaymentservice")
public interface PaymentRepository extends CrudRepository<PaymentFromtsinsidepaymentservice, String> {
    /**
     * find by id
     *
     * @param id
    		id
     * @return Payment
     */
    Optional<PaymentFromtsinsidepaymentservice> findById(String id);

    /**
     * find by order id
     *
     * @param orderId
     * 		order id
     * @return List<Payment>
     */
    List<PaymentFromtsinsidepaymentservice> findByOrderId(String orderId);

    /**
     * find all
     *
     * @return List<Payment>
     */
    @Override
    List<PaymentFromtsinsidepaymentservice> findAll();

    /**
     * find by user id
     *
     * @param userId
     * 		user id
     * @return List<Payment>
     */
    List<PaymentFromtsinsidepaymentservice> findByUserId(String userId);
}