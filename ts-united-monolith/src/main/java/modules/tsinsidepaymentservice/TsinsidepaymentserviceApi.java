package modules.tsinsidepaymentservice;
import modules.tsinsidepaymentservice.inside_payment.controller.InsidePaymentController;
import modules.tsinsidepaymentservice.inside_payment.entity.PaymentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
@Component
public class TsinsidepaymentserviceApi {
    @Autowired
    InsidePaymentController insidePaymentController;

    public HttpEntity getApiV1Inside_pay_serviceInside_paymentDrawbackPathvariablePathvariable(String userId, String money, HttpHeaders headers) {
        return insidePaymentController.drawBack(userId, money, headers);
    }

    public HttpEntity postApiV1Inside_pay_serviceInside_paymentDifference(PaymentInfo info, HttpHeaders headers) {
        return insidePaymentController.payDifference(info, headers);
    }
}