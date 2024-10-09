package modules.tsfoodservice.foodsearch.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;
@Configuration
public class Queues {
    public static final String queueName = "food_delivery";

    @Bean
    public Queue emailQueue() {
        return new Queue(queueName);
    }
}