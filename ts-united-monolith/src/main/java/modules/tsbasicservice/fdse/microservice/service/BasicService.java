package modules.tsbasicservice.fdse.microservice.service;
import java.util.List;
import modules.tscommon.edu.fudan.common.entity.Travel;
import modules.tscommon.edu.fudan.common.util.Response;
import org.springframework.http.HttpHeaders;
/**
 *
 * @author Chenjie
 * @date 2017/6/6.
 */
public interface BasicService {
    /**
     * query for travel with travel information
     *
     * @param info
    		information
     * @param headers
    		headers
     * @return Response
     */
    Response queryForTravel(Travel info, HttpHeaders headers);

    Response queryForTravels(List<Travel> infos, HttpHeaders headers);

    /**
     * query for station id with station name
     *
     * @param stationName
     * 		station name
     * @param headers
    		headers
     * @return Response
     */
    Response queryForStationId(String stationName, HttpHeaders headers);
}