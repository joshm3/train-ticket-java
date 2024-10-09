package modules.tsconsignservice;
import modules.tsconsignservice.consign.controller.ConsignController;
import modules.tsconsignservice.consign.entity.Consign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
@Component
public class TsconsignserviceApi {
    @Autowired
    ConsignController consignController;

    public HttpEntity postApiV1ConsignserviceConsigns(Consign request, HttpHeaders headers) {
        return consignController.insertConsign(request, headers);
    }
}