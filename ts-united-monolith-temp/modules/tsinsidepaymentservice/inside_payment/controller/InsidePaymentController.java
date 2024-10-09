package modules.tsinsidepaymentservice.inside_payment.controller;
import modules.tsinsidepaymentservice.inside_payment.entity.AccountInfo;
import modules.tsinsidepaymentservice.inside_payment.entity.PaymentInfo;
import modules.tsinsidepaymentservice.inside_payment.service.InsidePaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.ResponseEntity.ok;
/**
 *
 * @author fdse
 */
@RestController
@RequestMapping("/api/v1/inside_pay_service")
public class InsidePaymentController {
    @Autowired
    public InsidePaymentService service;

    private static final Logger LOGGER = LoggerFactory.getLogger(InsidePaymentController.class);

    @GetMapping(path = "/welcome")
    public String home() {
        return "Welcome to [ InsidePayment Service ] !";
    }

    @PostMapping("/inside_payment")
    public HttpEntity pay(@RequestBody
    PaymentInfo info, @RequestHeader
    HttpHeaders headers) {
        InsidePaymentController.LOGGER.info("[pay][Inside Payment Service.Pay][Pay for: {}]", info.getOrderId());
        return ok(service.pay(info, headers));
    }

    @PostMapping("/inside_payment/account")
    public HttpEntity createAccount(@RequestBody
    AccountInfo info, @RequestHeader
    HttpHeaders headers) {
        LOGGER.info("[createAccount][Create account][accountInfo: {}]", info);
        return ok(service.createAccount(info, headers));
    }

    @GetMapping("/inside_payment/{userId}/{money}")
    public HttpEntity addMoney(@PathVariable
    String userId, @PathVariable
    String money, @RequestHeader
    HttpHeaders headers) {
        LOGGER.info("[addMoney][add money][userId: {}, money: {}]", userId, money);
        return ok(service.addMoney(userId, money, headers));
    }

    @GetMapping("/inside_payment/payment")
    public HttpEntity queryPayment(@RequestHeader
    HttpHeaders headers) {
        LOGGER.info("[queryPayment][query payment]");
        return ok(service.queryPayment(headers));
    }

    @GetMapping("/inside_payment/account")
    public HttpEntity queryAccount(@RequestHeader
    HttpHeaders headers) {
        LOGGER.info("[queryAccount][query account]");
        return ok(service.queryAccount(headers));
    }

    @GetMapping("/inside_payment/drawback/{userId}/{money}")
    public HttpEntity drawBack(@PathVariable
    String userId, @PathVariable
    String money, @RequestHeader
    HttpHeaders headers) {
        LOGGER.info("[drawBack][draw back payment][userId: {}, money: {}]", userId, money);
        return ok(service.drawBack(userId, money, headers));
    }

    @PostMapping("/inside_payment/difference")
    public HttpEntity payDifference(@RequestBody
    PaymentInfo info, @RequestHeader
    HttpHeaders headers) {
        LOGGER.info("[payDifference][pay difference]");
        return ok(service.payDifference(info, headers));
    }

    @GetMapping("/inside_payment/money")
    public HttpEntity queryAddMoney(@RequestHeader
    HttpHeaders headers) {
        LOGGER.info("[queryAddMoney][query add money]");
        return ok(service.queryAddMoney(headers));
    }
}