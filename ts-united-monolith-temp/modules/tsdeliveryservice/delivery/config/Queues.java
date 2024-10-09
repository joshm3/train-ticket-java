package modules.tsdeliveryservice.delivery.config;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class Queues {
    public static final String queueName = "food_delivery";

    @Bean
    public Queue emailQueue() {
        return new Queue(queueName);
    }
}