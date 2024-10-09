package modules.tsstationfoodservice.food.repository;
import java.util.List;
import java.util.Optional;
import modules.tsstationfoodservice.food.entity.StationFoodStore;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface StationFoodRepository extends CrudRepository<StationFoodStore, String> {
    @Override
    Optional<StationFoodStore> findById(String id);

    List<StationFoodStore> findByStationName(String stationName);

    List<StationFoodStore> findByStationNameIn(List<String> stationNames);

    @Override
    List<StationFoodStore> findAll();

    @Override
    void deleteById(String id);
}