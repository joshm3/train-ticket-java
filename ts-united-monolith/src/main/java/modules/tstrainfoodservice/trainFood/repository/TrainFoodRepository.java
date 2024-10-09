package modules.tstrainfoodservice.trainFood.repository;
import java.util.List;
import java.util.UUID;
import modules.tstrainfoodservice.trainFood.entity.TrainFood;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TrainFoodRepository extends CrudRepository<TrainFood, String> {
    TrainFood findById(UUID id);

    @Override
    List<TrainFood> findAll();

    TrainFood findByTripId(String tripId);

    void deleteById(UUID id);
}