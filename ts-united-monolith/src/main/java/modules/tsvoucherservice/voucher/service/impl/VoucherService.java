package modules.tsvoucherservice.voucher.service.impl;
import modules.tscommon.edu.fudan.common.entity.Order;
import modules.tscommon.edu.fudan.common.util.Response;
import modules.tsvoucherservice.TsvoucherserviceClient;
import modules.tsvoucherservice.voucher.entity.VoucherFromtsvoucherservice;
import modules.tsvoucherservice.voucher.repository.VoucherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service("voucherServiceFromtsvoucherservice")
public class VoucherService {
    @Autowired
    TsvoucherserviceClient tsvoucherserviceClient;

    @Autowired
    private VoucherRepository voucherRepository;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    private String getServiceUrl(String serviceName) {
        return "http://" + serviceName;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(VoucherService.class);

    public Order queryOrderByIdAndType(String orderId, int type) {
        // Change can only be changed once, check the status of the order to determine whether it has been changed
        String requestUrl = "";
        String order_service_url = getServiceUrl("ts-order-service");
        String order_other_service_url = getServiceUrl("ts-order-other-service");
        HttpEntity requestEntityGetOrderInfo = new HttpEntity(null);// no headers

        ResponseEntity<Response<Order>> reGetOrderByRebookInfo = null;
        if (type == 0) {
            requestUrl = (order_other_service_url + "/api/v1/orderOtherService/orderOther/") + orderId;
            reGetOrderByRebookInfo = tsvoucherserviceClient.getApiV1OrderotherserviceOrderotherPathvariable(orderId, null);
        } else {
            requestUrl = (order_service_url + "/api/v1/orderservice/order/") + orderId;
            reGetOrderByRebookInfo = tsvoucherserviceClient.getApiV1OrderserviceOrderPathvariable(orderId, null);
        }
        Response<Order> queryOrderResult = reGetOrderByRebookInfo.getBody();
        Order returnOrder = queryOrderResult.getData();
        return returnOrder;
    }

    public VoucherFromtsvoucherservice getVoucher(String orderId, int type) {
        VoucherFromtsvoucherservice existingVoucher = voucherRepository.findByOrderId(orderId);
        if ((existingVoucher = voucherRepository.findByOrderId(orderId)) != null) {
            VoucherService.LOGGER.info("[VoucherService][Voucher Found]");
            return existingVoucher;
        } else {
            Order order = queryOrderByIdAndType(orderId, type);
            VoucherFromtsvoucherservice newVoucher = new VoucherFromtsvoucherservice();
            newVoucher.setOrderId(order.getId());
            newVoucher.setTravelDate(order.getTravelDate());
            newVoucher.setTravelTime(order.getTravelTime());
            newVoucher.setContactName(order.getContactsName());
            newVoucher.setTrainNumber(order.getTrainNumber());
            newVoucher.setSeatClass(order.getSeatClass());
            newVoucher.setSeatNumber(order.getSeatNumber());
            newVoucher.setStartStation(order.getFrom());
            newVoucher.setDestStation(order.getTo());
            newVoucher.setPrice(order.getPrice());
            voucherRepository.save(newVoucher);
            VoucherService.LOGGER.info("[VoucherService][Voucher Created]");
            return newVoucher;
        }
    }
}