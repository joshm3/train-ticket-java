package modules.tscommon.edu.fudan.common.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 *
 * @author fdse
 */
// public Date getStartTime(){
// return StringUtils.String2Date(this.startTime);
// }
// 
// public Date getEndTime(){
// return StringUtils.String2Date(this.endTime);
// }
// 
// public String getStartStationName() {
// return StringUtils.String2Lower(this.startStationName);
// }
// 
// public String getTerminalStationName() {
// return StringUtils.String2Lower(this.terminalStationName);
// }
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TravelInfo {
    private String loginId;

    private String tripId;

    private String trainTypeName;

    private String routeId;

    private String startStationName;

    private String stationsName;

    private String terminalStationName;

    private String startTime;

    private String endTime;
}