package modules.tstrainservice.train.repository;
import java.util.List;
import java.util.Optional;
import modules.tstrainservice.train.entity.TrainType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TrainTypeRepository extends CrudRepository<TrainType, String> {
    Optional<TrainType> findById(String id);

    @Override
    List<TrainType> findAll();

    void deleteById(String id);

    TrainType findByName(String name);

    @Query(value = "SELECT * from train_type where name in ?1", nativeQuery = true)
    List<TrainType> findByNames(List<String> names);
}