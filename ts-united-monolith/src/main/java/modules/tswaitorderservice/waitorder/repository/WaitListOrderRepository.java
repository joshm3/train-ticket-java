package modules.tswaitorderservice.waitorder.repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import modules.tswaitorderservice.waitorder.entity.WaitListOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface WaitListOrderRepository extends CrudRepository<WaitListOrder, String> {
    @Override
    Optional<WaitListOrder> findById(String id);

    @Override
    List<WaitListOrder> findAll();

    ArrayList<WaitListOrder> findByAccountId(String accountId);

    @Override
    void deleteById(String id);
}