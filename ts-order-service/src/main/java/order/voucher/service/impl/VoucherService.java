package order.voucher.service.impl;

import order.voucher.entity.Voucher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import org.springframework.core.ParameterizedTypeReference;


import order.voucher.repository.VoucherRepository;

import edu.fudan.common.entity.Order;
import edu.fudan.common.util.Response;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class VoucherService {

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
        if (type==0) {
            requestUrl = order_other_service_url + "/api/v1/orderOtherService/orderOther/" + orderId;
        } else {
            requestUrl = order_service_url + "/api/v1/orderservice/order/" + orderId;
        }

        HttpEntity requestEntityGetOrderInfo = new HttpEntity(null); //no headers
        ResponseEntity<Response<Order>> reGetOrderByRebookInfo = restTemplate.exchange(
                requestUrl,
                HttpMethod.GET,
                requestEntityGetOrderInfo,
                new ParameterizedTypeReference<Response<Order>>() {
                });

        Response<Order> queryOrderResult = reGetOrderByRebookInfo.getBody();
        Order returnOrder = queryOrderResult.getData();
        return returnOrder;
    }



    public Voucher getVoucher(String orderId, int type){

        Voucher existingVoucher = voucherRepository.findByOrderId(orderId);
        if ((existingVoucher = voucherRepository.findByOrderId(orderId)) != null) {
            VoucherService.LOGGER.info("[VoucherService][Voucher Found]");
            return existingVoucher;
        }
        else {
            Order order = queryOrderByIdAndType(orderId, type);
            
            Voucher newVoucher = new Voucher();
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