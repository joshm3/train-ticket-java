package modules.tsexecuteservice.execute.serivce;
import modules.tscommon.edu.fudan.common.entity.Order;
import modules.tscommon.edu.fudan.common.entity.OrderStatus;
import modules.tscommon.edu.fudan.common.util.Response;
import modules.tsexecuteservice.TsexecuteserviceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
/**
 *
 * @author fdse
 */
@Service
public class ExecuteServiceImpl implements ExecuteService {
    @Autowired
    TsexecuteserviceClient tsexecuteserviceClient;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    String orderStatusWrong = "Order Status Wrong";

    private static final Logger LOGGER = LoggerFactory.getLogger(ExecuteServiceImpl.class);

    private String getServiceUrl(String serviceName) {
        return "http://" + serviceName;
    }

    @Override
    public Response ticketExecute(String orderId, HttpHeaders headers) {
        // 1.Get order information
        headers = null;
        Response<Order> resultFromOrder = getOrderByIdFromOrder(orderId, headers);
        Order order;
        if (resultFromOrder.getStatus() == 1) {
            order = resultFromOrder.getData();
            // 2.Check if the order can come in
            if (order.getStatus() != OrderStatus.COLLECTED.getCode()) {
                LOGGER.error("[ticketExecute][getOrderByIdFromOrder][ticket execute error: {}][orderId: {}]", orderStatusWrong, orderId);
                return new Response(0, orderStatusWrong, null);
            }
            // 3.Confirm inbound, request change order information
            Response resultExecute = executeOrder(orderId, OrderStatus.USED.getCode(), headers);
            if (resultExecute.getStatus() == 1) {
                return new Response(1, "Success.", null);
            } else {
                LOGGER.error("[ticketExecute][executeOrder][executeOrder error: {}][orderId: {}]", resultExecute.getMsg(), orderId);
                return new Response(0, resultExecute.getMsg(), null);
            }
        } else {
            resultFromOrder = getOrderByIdFromOrderOther(orderId, headers);
            if (resultFromOrder.getStatus() == 1) {
                order = resultFromOrder.getData();
                // 2.Check if the order can come in
                if (order.getStatus() != OrderStatus.COLLECTED.getCode()) {
                    LOGGER.error("[ticketExecute][getOrderByIdFromOrderOther][ticket execute error: {}][orderId: {}]", orderStatusWrong, orderId);
                    return new Response(0, orderStatusWrong, null);
                }
                // 3.Confirm inbound, request change order information
                Response resultExecute = executeOrderOther(orderId, OrderStatus.USED.getCode(), headers);
                if (resultExecute.getStatus() == 1) {
                    return new Response(1, "Success", null);
                } else {
                    LOGGER.error("[ticketExecute][executeOrderOther][executeOrderOther error: {}][orderId: {}]", resultExecute.getMsg(), orderId);
                    return new Response(0, resultExecute.getMsg(), null);
                }
            } else {
                LOGGER.error("[ticketExecute][getOrderByIdFromOrderOther][ticker execute error: {}][orderId: {}]", "Order Not Found", orderId);
                return new Response(0, "Order Not Found", null);
            }
        }
    }

    @Override
    public Response ticketCollect(String orderId, HttpHeaders headers) {
        // 1.Get order information
        headers = null;
        Response<Order> resultFromOrder = getOrderByIdFromOrder(orderId, headers);
        Order order;
        if (resultFromOrder.getStatus() == 1) {
            order = resultFromOrder.getData();
            // 2.Check if the order can come in
            if ((order.getStatus() != OrderStatus.PAID.getCode()) && (order.getStatus() != OrderStatus.CHANGE.getCode())) {
                LOGGER.error("[ticketCollect][getOrderByIdFromOrder][ticket collect error: {}][orderId: {}]", orderStatusWrong, orderId);
                return new Response(0, orderStatusWrong, null);
            }
            // 3.Confirm inbound, request change order information
            Response resultExecute = executeOrder(orderId, OrderStatus.COLLECTED.getCode(), headers);
            if (resultExecute.getStatus() == 1) {
                return new Response(1, "Success", null);
            } else {
                LOGGER.error("[ticketCollect][executeOrder][ticket collect error: {}][orderId: {}]", resultExecute.getMsg(), orderId);
                return new Response(0, resultExecute.getMsg(), null);
            }
        } else {
            resultFromOrder = getOrderByIdFromOrderOther(orderId, headers);
            if (resultFromOrder.getStatus() == 1) {
                order = ((Order) (resultFromOrder.getData()));
                // 2.Check if the order can come in
                if ((order.getStatus() != OrderStatus.PAID.getCode()) && (order.getStatus() != OrderStatus.CHANGE.getCode())) {
                    LOGGER.error("[ticketCollect][getOrderByIdFromOrderOther][ticket collect error: {}][orderId: {}]", orderStatusWrong, orderId);
                    return new Response(0, orderStatusWrong, null);
                }
                // 3.Confirm inbound, request change order information
                Response resultExecute = executeOrderOther(orderId, OrderStatus.COLLECTED.getCode(), headers);
                if (resultExecute.getStatus() == 1) {
                    return new Response(1, "Success.", null);
                } else {
                    LOGGER.error("[ticketCollect][executeOrderOther][ticket collect error: {}][orderId: {}]", resultExecute.getMsg(), orderId);
                    return new Response(0, resultExecute.getMsg(), null);
                }
            } else {
                LOGGER.error("[ticketCollect][getOrderByIdFromOrderOther][ticket collect error: {}][orderId: {}]", "Order Not Found", orderId);
                return new Response(0, "Order Not Found", null);
            }
        }
    }

    private Response executeOrder(String orderId, int status, HttpHeaders headers) {
        ExecuteServiceImpl.LOGGER.info("[Execute Service][Execute Order] Executing....");
        headers = null;
        HttpEntity requestEntity = new HttpEntity(headers);
        String order_service_url = getServiceUrl("ts-order-service");
        ResponseEntity<Response> re = tsexecuteserviceClient.getApiV1OrderserviceOrderStatusPathvariablePathvariable(orderId, status, headers);
        return re.getBody();
    }

    private Response executeOrderOther(String orderId, int status, HttpHeaders headers) {
        ExecuteServiceImpl.LOGGER.info("[Execute Service][Execute Order] Executing....");
        headers = null;
        HttpEntity requestEntity = new HttpEntity(headers);
        String order_other_service_url = getServiceUrl("ts-order-other-service");
        ResponseEntity<Response> re = tsexecuteserviceClient.getApiV1OrderotherserviceOrderotherStatusPathvariablePathvariable(orderId, status, headers);
        return re.getBody();
    }

    private Response<Order> getOrderByIdFromOrder(String orderId, HttpHeaders headers) {
        ExecuteServiceImpl.LOGGER.info("[Execute Service][Get Order] Getting....");
        headers = null;
        HttpEntity requestEntity = new HttpEntity(headers);
        String order_service_url = getServiceUrl("ts-order-service");
        ResponseEntity<Response<Order>> re = tsexecuteserviceClient.getApiV1OrderserviceOrderPathvariable(orderId, headers);
        return re.getBody();
    }

    private Response<Order> getOrderByIdFromOrderOther(String orderId, HttpHeaders headers) {
        ExecuteServiceImpl.LOGGER.info("[getOrderByIdFromOrderOther][Execute Service, Get Order]");
        headers = null;
        HttpEntity requestEntity = new HttpEntity(headers);
        String order_other_service_url = getServiceUrl("ts-order-other-service");
        ResponseEntity<Response<Order>> re = tsexecuteserviceClient.getApiV1OrderotherserviceOrderotherPathvariable(orderId, headers);
        return re.getBody();
    }
}