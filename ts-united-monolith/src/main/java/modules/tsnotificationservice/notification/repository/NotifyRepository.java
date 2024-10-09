package modules.tsnotificationservice.notification.repository;
import java.util.List;
import java.util.Optional;
import modules.tsnotificationservice.notification.entity.NotifyInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface NotifyRepository extends CrudRepository<NotifyInfo, String> {
    Optional<NotifyInfo> findById(String id);

    @Override
    List<NotifyInfo> findAll();

    void deleteById(String id);
}