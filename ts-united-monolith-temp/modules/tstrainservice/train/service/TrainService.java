package modules.tstrainservice.train.service;
import java.util.List;
import modules.tstrainservice.train.entity.TrainType;
import org.springframework.http.HttpHeaders;
public interface TrainService {
    // CRUD
    boolean create(TrainType trainType, HttpHeaders headers);

    TrainType retrieve(String id, HttpHeaders headers);

    TrainType retrieveByName(String name, HttpHeaders headers);

    List<TrainType> retrieveByNames(List<String> name, HttpHeaders headers);

    boolean update(TrainType trainType, HttpHeaders headers);

    boolean delete(String id, HttpHeaders headers);

    List<TrainType> query(HttpHeaders headers);
}