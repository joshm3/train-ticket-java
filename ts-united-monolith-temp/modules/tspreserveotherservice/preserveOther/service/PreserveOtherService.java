package modules.tspreserveotherservice.preserveOther.service;
import modules.tscommon.edu.fudan.common.entity.OrderTicketsInfo;
import modules.tscommon.edu.fudan.common.util.Response;
import org.springframework.http.HttpHeaders;
/**
 *
 * @author fdse
 */
public interface PreserveOtherService {
    Response preserve(OrderTicketsInfo oti, HttpHeaders headers);
}