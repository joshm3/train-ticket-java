package modules.tstravelservice.travel.entity;
import lombok.Data;
import modules.tscommon.edu.fudan.common.entity.TripResponse;
/**
 *
 * @author fdse
 */
@Data
public class TripAllDetail {
    private TripResponse tripResponse;

    private Trip trip;

    public TripAllDetail() {
    }

    public TripAllDetail(TripResponse tripResponse, Trip trip) {
        this.tripResponse = tripResponse;
        this.trip = trip;
    }
}