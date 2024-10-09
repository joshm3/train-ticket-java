package modules.tsvoucherservice.voucher.repository;
import modules.tsvoucherservice.voucher.entity.Voucher;
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