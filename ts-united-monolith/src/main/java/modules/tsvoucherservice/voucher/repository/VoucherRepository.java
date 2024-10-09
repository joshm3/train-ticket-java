package modules.tsvoucherservice.voucher.repository;
import modules.tsvoucherservice.voucher.entity.VoucherFromtsvoucherservice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author fdse
 */
@Repository("voucherRepositoryFromtsvoucherservice")
public interface VoucherRepository extends CrudRepository<VoucherFromtsvoucherservice, Long> {
    VoucherFromtsvoucherservice findByOrderId(String orderId);
}