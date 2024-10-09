package modules.tspriceservice;
import java.util.List;
import modules.tspriceservice.price.controller.PriceController;
import modules.tspriceservice.price.entity.PriceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
@Component
public class TspriceserviceApi {
    @Autowired
    PriceController priceController;

    public HttpEntity getApiV1PriceservicePricesPathvariablePathvariable(String routeId, String trainType, HttpHeaders headers) {
        return priceController.query(routeId, trainType, headers);
    }

    public HttpEntity postApiV1PriceservicePricesByrouteidsandtraintypes(List<String> ridsAndTts, HttpHeaders headers) {
        return priceController.query(ridsAndTts, headers);
    }

    public HttpEntity deleteApiV1PriceservicePricesPathvariable(String pricesId, HttpHeaders headers) {
        return priceController.delete(pricesId, headers);
    }

    public HttpEntity putApiV1PriceservicePrices(PriceConfig info, HttpHeaders headers) {
        return priceController.update(info, headers);
    }

    public HttpEntity getApiV1PriceservicePrices(HttpHeaders headers) {
        return priceController.queryAll(headers);
    }

    public HttpEntity<?> postApiV1PriceservicePrices(PriceConfig info, HttpHeaders headers) {
        return priceController.create(info, headers);
    }
}