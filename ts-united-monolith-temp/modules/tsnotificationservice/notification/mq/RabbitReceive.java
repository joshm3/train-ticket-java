package modules.tsnotificationservice.notification.mq;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import modules.tscommon.edu.fudan.common.util.JsonUtils;
import modules.tsnotificationservice.notification.config.Queues;
import modules.tsnotificationservice.notification.entity.Mail;
import modules.tsnotificationservice.notification.entity.NotifyInfo;
import modules.tsnotificationservice.notification.repository.NotifyRepository;
import modules.tsnotificationservice.notification.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class RabbitReceive {
    private static final Logger logger = LoggerFactory.getLogger(RabbitReceive.class);

    @Autowired
    MailService mailService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private NotifyRepository notifyRepository;

    @Value("${email_address:trainticket_notify@163.com}")
    String email;

    String username = "username";

    String startPlace = "startPlace";

    String endPlace = "endPlace";

    String startTime = "startTime";

    String seatClass = "seatClass";

    String seatNumber = "seatNumber";

    String date = "date";

    String price = "price";

    @RabbitListener(queues = Queues.queueName)
    public void process(String payload) {
        NotifyInfo info = JsonUtils.json2Object(payload, NotifyInfo.class);
        if (info == null) {
            logger.error("[process][json2Object][Receive email object is null, error]");
            return;
        }
        logger.info("[process][Receive email object][info: {}]", info);
        Mail mail = new Mail();
        mail.setMailFrom(email);
        mail.setMailTo(info.getEmail());
        mail.setMailSubject("Preserve Success");
        Map<String, Object> model = new HashMap<>();
        model.put(username, info.getUsername());
        model.put(startPlace, info.getStartPlace());
        model.put(endPlace, info.getEndPlace());
        model.put(startTime, info.getStartTime());
        model.put(date, info.getDate());
        model.put(seatClass, info.getSeatClass());
        model.put(seatNumber, info.getSeatNumber());
        model.put(price, info.getPrice());
        mail.setModel(model);
        try {
            mailService.sendEmail(mail, "preserve_success.ftl");
            logger.info("[process][Send email to user {} success]", username);
            info.setSendStatus(true);
        } catch (Exception e) {
            logger.error("[process][mailService.sendEmail][Send email error][Exception: {}]", e.getMessage());
            info.setSendStatus(false);
        }
        info.setId(UUID.randomUUID().toString());
        logger.info("[process][Save notify info object [{}] into database]", info.getId());
        notifyRepository.save(info);
    }
}