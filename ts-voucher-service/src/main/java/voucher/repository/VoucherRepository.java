package voucher.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import voucher.entity.Voucher;

import java.util.List;
import java.util.UUID;

/**
 * @author fdse
 */
@Repository
public interface VoucherRepository extends CrudRepository<Voucher, Long> {

    Voucher findByOrderId(String orderId);
}
