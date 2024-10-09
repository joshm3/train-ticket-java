package modules.tsorderservice;
import modules.tscommon.edu.fudan.common.entity.Seat;
import modules.tsorderservice.order.controller.OrderController;
import modules.tsorderservice.order.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
@Component
public class TsorderserviceApi {
    @Autowired
    OrderController orderController;

    public HttpEntity getApiV1OrderserviceOrder(HttpHeaders headers) {
        return orderController.findAllOrder(headers);
    }

    public HttpEntity getApiV1OrderserviceOrderPathvariable(String orderId, HttpHeaders headers) {
        return orderController.getOrderById(orderId, headers);
    }

    public HttpEntity putApiV1OrderserviceOrder(Order orderInfo, HttpHeaders headers) {
        return orderController.saveOrderInfo(orderInfo, headers);
    }

    public HttpEntity postApiV1OrderserviceOrderAdmin(Order order, HttpHeaders headers) {
        return orderController.addcreateNewOrder(order, headers);
    }

    public HttpEntity postApiV1OrderserviceOrderTickets(Seat seatRequest, HttpHeaders headers) {
        return orderController.getTicketListByDateAndTripId(seatRequest, headers);
    }

    public HttpEntity postApiV1OrderserviceOrder(Order createOrder, HttpHeaders headers) {
        return orderController.createNewOrder(createOrder, headers);
    }

    public HttpEntity deleteApiV1OrderserviceOrderPathvariable(String orderId, HttpHeaders headers) {
        return orderController.deleteOrder(orderId, headers);
    }

    public HttpEntity getApiV1OrderserviceOrderStatusPathvariablePathvariable(String orderId, int status, HttpHeaders headers) {
        return orderController.modifyOrder(orderId, status, headers);
    }

    public HttpEntity putApiV1OrderserviceOrderAdmin(Order order, HttpHeaders headers) {
        return orderController.updateOrder(order, headers);
    }

    public HttpEntity getApiV1OrderserviceOrderSecurityPathvariablePathvariable(String checkDate, String accountId, HttpHeaders headers) {
        return orderController.securityInfoCheck(checkDate, accountId, headers);
    }
}