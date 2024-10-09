package modules.tspreserveotherservice.preserveOther.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;
@Configuration("queuesFromtspreserveotherservice")
public class Queues {
    public static final String queueName = "email";

    @Bean("emailQueueFromtspreserveotherservice")
    public Queue emailQueue() {
        return new Queue(queueName);
    }
}