package modules.tsfoodservice.foodsearch.mq;
import modules.tsfoodservice.foodsearch.config.Queues;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.amqp.core.AmqpTemplate;
@Component
public class RabbitSend {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    private static final Logger logger = LoggerFactory.getLogger(RabbitSend.class);

    public void send(String val) {
        logger.info("Send info to mq:" + val);
        this.rabbitTemplate.convertAndSend(Queues.queueName, val);
    }
}