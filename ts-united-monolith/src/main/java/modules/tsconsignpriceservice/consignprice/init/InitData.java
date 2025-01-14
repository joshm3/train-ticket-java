package modules.tsconsignpriceservice.consignprice.init;
import java.util.UUID;
import modules.tsconsignpriceservice.consignprice.entity.ConsignPrice;
import modules.tsconsignpriceservice.consignprice.service.ConsignPriceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
/**
 *
 * @author fdse
 */
@Component("initDataFromtsconsignpriceservice")
public class InitData implements CommandLineRunner {
    @Autowired
    ConsignPriceService service;

    private static final Logger LOGGER = LoggerFactory.getLogger(InitData.class);

    @Override
    public void run(String... strings) throws Exception {
        InitData.LOGGER.info("[InitData.run][Consign price service][Init data operation]");
        ConsignPrice config = new ConsignPrice();
        config.setId(UUID.randomUUID().toString());
        config.setIndex(0);
        config.setInitialPrice(8);
        config.setInitialWeight(1);
        config.setWithinPrice(2);
        config.setBeyondPrice(4);
        service.createAndModifyPrice(config, null);
    }
}