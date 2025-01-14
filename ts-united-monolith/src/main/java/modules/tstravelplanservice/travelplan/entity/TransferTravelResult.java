package modules.tstravelplanservice.travelplan.entity;
import java.util.List;
import lombok.Data;
import modules.tscommon.edu.fudan.common.entity.TripResponse;
/**
 *
 * @author fdse
 */
@Data
public class TransferTravelResult {
    private List<TripResponse> firstSectionResult;

    private List<TripResponse> secondSectionResult;

    public TransferTravelResult() {
        // Default Constructor
    }

    public TransferTravelResult(List<TripResponse> firstSectionResult, List<TripResponse> secondSectionResult) {
        this.firstSectionResult = firstSectionResult;
        this.secondSectionResult = secondSectionResult;
    }
}