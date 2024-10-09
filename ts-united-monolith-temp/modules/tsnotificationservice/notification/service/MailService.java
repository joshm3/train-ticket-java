package modules.tsnotificationservice.notification.service;
import freemarker.template.Configuration;
import freemarker.template.Template;
import javax.mail.internet.MimeMessage;
import modules.tsnotificationservice.notification.entity.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
/**
 *
 * @author fdse
 */
@Service
public class MailService {
    @Autowired
    private JavaMailSender sender;

    @Autowired
    @Qualifier("freeMarkerConfiguration")
    private Configuration freemarkerConfig;

    public void sendEmail(Mail mail, String template) throws Exception {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        // Using a subfolder such as /templates here
        freemarkerConfig.setClassForTemplateLoading(this.getClass(), "/templates");
        Template t = freemarkerConfig.getTemplate(template);
        String text = FreeMarkerTemplateUtils.processTemplateIntoString(t, mail.getModel());
        helper.setTo(mail.getMailTo());
        helper.setText(text, true);
        helper.setFrom(mail.getMailFrom());
        helper.setSubject(mail.getMailSubject());
        sender.send(message);
    }
}