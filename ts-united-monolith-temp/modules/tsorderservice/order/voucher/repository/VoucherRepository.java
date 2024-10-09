package modules.tsorderservice.order.voucher.repository;
import modules.tsorderservice.order.voucher.entity.Voucher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author fdse
 */
@Repository
public interface VoucherRepository extends CrudRepository<Voucher, Long> {
    Voucher findByOrderId(String orderId);
}