package modules.tstrainservice;
import java.util.List;
import modules.tstrainservice.train.controller.TrainController;
import modules.tstrainservice.train.entity.TrainType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
@Component
public class TstrainserviceApi {
    @Autowired
    TrainController trainController;

    public HttpEntity getApiV1TrainserviceTrainsBynamePathvariable(String name, HttpHeaders headers) {
        return trainController.retrieveByName(name, headers);
    }

    public HttpEntity postApiV1TrainserviceTrainsBynames(List<String> names, HttpHeaders headers) {
        return trainController.retrieveByName(names, headers);
    }

    public HttpEntity getApiV1TrainserviceTrains(HttpHeaders headers) {
        return trainController.query(headers);
    }

    public HttpEntity putApiV1TrainserviceTrains(TrainType trainType, HttpHeaders headers) {
        return trainController.update(trainType, headers);
    }

    public HttpEntity deleteApiV1TrainserviceTrainsPathvariable(String id, HttpHeaders headers) {
        return trainController.delete(id, headers);
    }

    public HttpEntity postApiV1TrainserviceTrains(TrainType trainType, HttpHeaders headers) {
        return trainController.create(trainType, headers);
    }
}