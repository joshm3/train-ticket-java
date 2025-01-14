package modules.tsconsignservice.consign.service;
import java.util.UUID;
import modules.tscommon.edu.fudan.common.util.Response;
import modules.tsconsignservice.consign.entity.Consign;
import org.springframework.http.HttpHeaders;
/**
 *
 * @author fdse
 */
public interface ConsignService {
    /**
     * insert consign record
     *
     * @param consignRequest
     * 		consign request
     * @param headers
     * 		headers
     * @return Response
     */
    Response insertConsignRecord(Consign consignRequest, HttpHeaders headers);

    /**
     * update consign record
     *
     * @param consignRequest
     * 		consign request
     * @param headers
     * 		headers
     * @return Response
     */
    Response updateConsignRecord(Consign consignRequest, HttpHeaders headers);

    /**
     * query by account id
     *
     * @param accountId
     * 		account id
     * @param headers
     * 		headers
     * @return Response
     */
    Response queryByAccountId(UUID accountId, HttpHeaders headers);

    /**
     * query by order id
     *
     * @param orderId
     * 		order id
     * @param headers
     * 		headers
     * @return Response
     */
    Response queryByOrderId(UUID orderId, HttpHeaders headers);

    /**
     * query by consignee
     *
     * @param consignee
     * 		consignee
     * @param headers
     * 		headers
     * @return Response
     */
    Response queryByConsignee(String consignee, HttpHeaders headers);
}