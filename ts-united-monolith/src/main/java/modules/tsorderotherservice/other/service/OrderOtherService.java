package modules.tsorderotherservice.other.service;
import java.util.Date;
import modules.tscommon.edu.fudan.common.entity.Seat;
import modules.tscommon.edu.fudan.common.util.Response;
import modules.tsorderotherservice.other.entity.OrderAlterInfo;
import modules.tsorderotherservice.other.entity.OrderFromtsorderotherservice;
import modules.tsorderotherservice.other.entity.QueryInfo;
import org.springframework.http.HttpHeaders;
/**
 *
 * @author fdse
 */
public interface OrderOtherService {
    Response findOrderById(String id, HttpHeaders headers);

    Response create(OrderFromtsorderotherservice newOrder, HttpHeaders headers);

    Response updateOrder(OrderFromtsorderotherservice order, HttpHeaders headers);

    Response saveChanges(OrderFromtsorderotherservice order, HttpHeaders headers);

    Response cancelOrder(String accountId, String orderId, HttpHeaders headers);

    Response addNewOrder(OrderFromtsorderotherservice order, HttpHeaders headers);

    Response deleteOrder(String orderId, HttpHeaders headers);

    Response getOrderById(String orderId, HttpHeaders headers);

    Response payOrder(String orderId, HttpHeaders headers);

    Response getOrderPrice(String orderId, HttpHeaders headers);

    Response modifyOrder(String orderId, int status, HttpHeaders headers);

    Response getAllOrders(HttpHeaders headers);

    Response getSoldTickets(Seat seatRequest, HttpHeaders headers);

    Response queryOrders(QueryInfo qi, String accountId, HttpHeaders headers);

    Response queryOrdersForRefresh(QueryInfo qi, String accountId, HttpHeaders headers);

    Response alterOrder(OrderAlterInfo oai, HttpHeaders headers);

    Response queryAlreadySoldOrders(Date travelDate, String trainNumber, HttpHeaders headers);

    Response checkSecurityAboutOrder(Date checkDate, String accountId, HttpHeaders headers);

    void initOrder(OrderFromtsorderotherservice order, HttpHeaders headers);
}