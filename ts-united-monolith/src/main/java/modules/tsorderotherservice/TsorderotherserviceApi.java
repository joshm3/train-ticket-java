package modules.tsorderotherservice;
import modules.tscommon.edu.fudan.common.entity.Seat;
import modules.tsorderotherservice.other.controller.OrderOtherController;
import modules.tsorderotherservice.other.entity.OrderFromtsorderotherservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
@Component
public class TsorderotherserviceApi {
    @Autowired
    OrderOtherController orderOtherController;

    public HttpEntity getApiV1OrderotherserviceOrderother(HttpHeaders headers) {
        return orderOtherController.findAllOrder(headers);
    }

    public HttpEntity getApiV1OrderotherserviceOrderotherPathvariable(String orderId, HttpHeaders headers) {
        return orderOtherController.getOrderById(orderId, headers);
    }

    public HttpEntity putApiV1OrderotherserviceOrderother(OrderFromtsorderotherservice orderInfo, HttpHeaders headers) {
        return orderOtherController.saveOrderInfo(orderInfo, headers);
    }

    public HttpEntity postApiV1OrderotherserviceOrderotherAdmin(OrderFromtsorderotherservice order, HttpHeaders headers) {
        return orderOtherController.addcreateNewOrder(order, headers);
    }

    public HttpEntity postApiV1OrderotherserviceOrderotherTickets(Seat seatRequest, HttpHeaders headers) {
        return orderOtherController.getTicketListByDateAndTripId(seatRequest, headers);
    }

    public HttpEntity postApiV1OrderotherserviceOrderother(OrderFromtsorderotherservice createOrder, HttpHeaders headers) {
        return orderOtherController.createNewOrder(createOrder, headers);
    }

    public HttpEntity deleteApiV1OrderotherserviceOrderotherPathvariable(String orderId, HttpHeaders headers) {
        return orderOtherController.deleteOrder(orderId, headers);
    }

    public HttpEntity getApiV1OrderotherserviceOrderotherStatusPathvariablePathvariable(String orderId, int status, HttpHeaders headers) {
        return orderOtherController.modifyOrder(orderId, status, headers);
    }

    public HttpEntity putApiV1OrderotherserviceOrderotherAdmin(OrderFromtsorderotherservice order, HttpHeaders headers) {
        return orderOtherController.updateOrder(order, headers);
    }

    public HttpEntity getApiV1OrderotherserviceOrderotherSecurityPathvariablePathvariable(String checkDate, String accountId, HttpHeaders headers) {
        return orderOtherController.securityInfoCheck(checkDate, accountId, headers);
    }
}