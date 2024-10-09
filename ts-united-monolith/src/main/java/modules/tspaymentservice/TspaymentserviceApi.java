package modules.tspaymentservice;
import modules.tspaymentservice.com.trainticket.controller.PaymentController;
import modules.tspaymentservice.com.trainticket.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
@Component
public class TspaymentserviceApi {
    @Autowired
    PaymentController paymentController;

    public HttpEntity postApiV1PaymentservicePayment(Payment info, HttpHeaders headers) {
        return paymentController.pay(info, headers);
    }
}