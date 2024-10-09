package modules.tspreserveservice.preserve.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;
@Configuration("queuesFromtspreserveservice")
public class Queues {
    public static final String queueName = "email";

    @Bean("emailQueueFromtspreserveservice")
    public Queue emailQueue() {
        return new Queue(queueName);
    }
}