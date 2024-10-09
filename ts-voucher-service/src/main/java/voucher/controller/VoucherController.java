package voucher.controller;

import edu.fudan.common.entity.Seat;
import edu.fudan.common.util.StringUtils;
import voucher.entity.Voucher;
import voucher.service.impl.VoucherService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;

/**
 * @author fdse
 */
@RestController
public class VoucherController {

    @Autowired
    private VoucherService voucherService;

    private static final Logger LOGGER = LoggerFactory.getLogger(VoucherController.class);

    @PostMapping(value = "/getVoucher")
    public HttpEntity<String> getVoucher(@RequestBody Map<String, Object> data, @RequestHeader HttpHeaders headers) throws IOException {

        VoucherController.LOGGER.info("[getVoucher][Fetch Voucher][OrderId: {}]", data.get("orderId"));

        String orderId = data.get("orderId").toString();
        int type = Integer.parseInt(data.get("type").toString());

        Voucher voucher = voucherService.getVoucher(orderId, type);
        ObjectMapper mapper = new ObjectMapper();

        return ok(mapper.writeValueAsString(voucher));
    }
}
