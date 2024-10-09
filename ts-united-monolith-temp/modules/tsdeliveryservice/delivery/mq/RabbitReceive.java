package modules.tsdeliveryservice.delivery.mq;
import java.util.UUID;
import modules.tscommon.edu.fudan.common.util.JsonUtils;
import modules.tsdeliveryservice.delivery.config.Queues;
import modules.tsdeliveryservice.delivery.entity.Delivery;
import modules.tsdeliveryservice.delivery.repository.DeliveryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class RabbitReceive {
    private static final Logger logger = LoggerFactory.getLogger(RabbitReceive.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DeliveryRepository deliveryRepository;

    @RabbitListener(queues = Queues.queueName)
    public void process(String payload) {
        Delivery delivery = JsonUtils.json2Object(payload, Delivery.class);
        if (delivery == null) {
            logger.error("[process][json2Object][Receive delivery object is null error]");
            return;
        }
        logger.info("[process][Receive delivery object][delivery object: {}]" + delivery);
        if (delivery.getId() == null) {
            delivery.setId(UUID.randomUUID().toString());
        }
        try {
            deliveryRepository.save(delivery);
            logger.info("[process][Save delivery object into database success]");
        } catch (Exception e) {
            logger.error("[process][deliveryRepository.save][Save delivery object into database failed][exception: {}]", e.toString());
        }
    }
}