package modules.tsnotificationservice.notification.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;
@Configuration("queuesFromtsnotificationservice")
public class Queues {
    public static final String queueName = "email";

    @Bean("emailQueueFromtsnotificationservice")
    public Queue emailQueue() {
        return new Queue(queueName);
    }
}