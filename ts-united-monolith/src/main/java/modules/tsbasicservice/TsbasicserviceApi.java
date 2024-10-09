package modules.tsbasicservice;
import java.util.List;
import modules.tsbasicservice.fdse.microservice.controller.BasicController;
import modules.tscommon.edu.fudan.common.entity.Travel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
@Component
public class TsbasicserviceApi {
    @Autowired
    BasicController basicController;

    public HttpEntity postApiV1BasicserviceBasicTravel(Travel info, HttpHeaders headers) {
        return basicController.queryForTravel(info, headers);
    }

    public HttpEntity postApiV1BasicserviceBasicTravels(List<Travel> infos, HttpHeaders headers) {
        return basicController.queryForTravels(infos, headers);
    }
}