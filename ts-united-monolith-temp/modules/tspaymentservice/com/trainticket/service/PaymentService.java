package modules.tspaymentservice.com.trainticket.service;
import modules.tscommon.edu.fudan.common.util.Response;
import modules.tspaymentservice.com.trainticket.entity.Payment;
import org.springframework.http.HttpHeaders;
/**
 *
 * @author Chenjie
 * @date 2017/4/3
 */
public interface PaymentService {
    Response pay(Payment info, HttpHeaders headers);

    Response addMoney(Payment info, HttpHeaders headers);

    Response query(HttpHeaders headers);

    void initPayment(Payment payment, HttpHeaders headers);
}