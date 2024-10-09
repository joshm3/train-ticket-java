package modules.tsnotificationservice;
import modules.tsnotificationservice.notification.controller.NotificationController;
import modules.tsnotificationservice.notification.entity.NotifyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
@Component
public class TsnotificationserviceApi {
    @Autowired
    NotificationController notificationController;

    public boolean postApiV1NotifyserviceNotificationOrder_cancel_success(NotifyInfo info, HttpHeaders headers) {
        return notificationController.order_cancel_success(info, headers);
    }
}