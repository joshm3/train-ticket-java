package modules.tsdeliveryservice.delivery.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;
@Configuration("queuesFromtsdeliveryservice")
public class Queues {
    public static final String queueName = "food_delivery";

    @Bean("emailQueueFromtsdeliveryservice")
    public Queue emailQueue() {
        return new Queue(queueName);
    }
}