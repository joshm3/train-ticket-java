package modules.tsinsidepaymentservice.inside_payment.repository;
import java.util.List;
import java.util.Optional;
import modules.tsinsidepaymentservice.inside_payment.entity.Payment;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author fdse
 */
public interface PaymentRepository extends CrudRepository<Payment, String> {
    /**
     * find by id
     *
     * @param id
     * 		id
     * @return Payment
     */
    Optional<Payment> findById(String id);

    /**
     * find by order id
     *
     * @param orderId
     * 		order id
     * @return List<Payment>
     */
    List<Payment> findByOrderId(String orderId);

    /**
     * find all
     *
     * @return List<Payment>
     */
    @Override
    List<Payment> findAll();

    /**
     * find by user id
     *
     * @param userId
     * 		user id
     * @return List<Payment>
     */
    List<Payment> findByUserId(String userId);
}