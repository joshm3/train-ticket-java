package modules.tscommon.edu.fudan.common.entity;
import java.util.Arrays;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 *
 * @author fdse
 */
@Data
@NoArgsConstructor
public class RouteInfo {
    private String loginId;

    private String startStation;

    private String endStation;

    private String stationList;

    private String distanceList;

    private String id;

    public List<String> getStations() {
        String[] stations = stationList.split(",");
        return Arrays.asList(stations);
    }

    public List<String> getDistances() {
        String[] distances = distanceList.split(",");
        return Arrays.asList(distances);
    }
}