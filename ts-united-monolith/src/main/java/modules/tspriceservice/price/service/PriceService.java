package modules.tspriceservice.price.service;
import java.util.List;
import modules.tscommon.edu.fudan.common.util.Response;
import modules.tspriceservice.price.entity.PriceConfig;
import org.springframework.http.HttpHeaders;
/**
 *
 * @author fdse
 */
public interface PriceService {
    Response createNewPriceConfig(PriceConfig priceConfig, HttpHeaders headers);

    PriceConfig findById(String id, HttpHeaders headers);

    Response findByRouteIdsAndTrainTypes(List<String> ridsAndTts, HttpHeaders headers);

    Response findByRouteIdAndTrainType(String routeId, String trainType, HttpHeaders headers);

    Response findAllPriceConfig(HttpHeaders headers);

    Response deletePriceConfig(String pcId, HttpHeaders headers);

    Response updatePriceConfig(PriceConfig c, HttpHeaders headers);
}