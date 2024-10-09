package modules.tsassuranceservice;
import modules.tsassuranceservice.assurance.controller.AssuranceController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
@Component
public class TsassuranceserviceApi {
    @Autowired
    AssuranceController assuranceController;

    public HttpEntity getApiV1AssuranceserviceAssurancesPathvariablePathvariable(int typeIndex, String orderId, HttpHeaders headers) {
        return assuranceController.createNewAssurance(typeIndex, orderId, headers);
    }
}