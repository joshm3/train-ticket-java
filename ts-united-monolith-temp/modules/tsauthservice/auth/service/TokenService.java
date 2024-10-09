package modules.tsauthservice.auth.service;
import modules.tsauthservice.auth.dto.BasicAuthDto;
import modules.tscommon.edu.fudan.common.util.Response;
import org.springframework.http.HttpHeaders;
/**
 *
 * @author fdse
 */
public interface TokenService {
    /**
     * get token by dto
     *
     * @param dto
     * 		dto
     * @param headers
     * 		headers
     * @return Response
     */
    Response getToken(BasicAuthDto dto, HttpHeaders headers);
}