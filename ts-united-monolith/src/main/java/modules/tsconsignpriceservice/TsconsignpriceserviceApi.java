package modules.tsconsignpriceservice;
import modules.tsconsignpriceservice.consignprice.controller.ConsignPriceController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
@Component
public class TsconsignpriceserviceApi {
    @Autowired
    ConsignPriceController consignPriceController;

    public HttpEntity getApiV1ConsignpriceserviceConsignpricePathvariablePathvariable(String weight, String isWithinRegion, HttpHeaders headers) {
        return consignPriceController.getPriceByWeightAndRegion(weight, isWithinRegion, headers);
    }
}