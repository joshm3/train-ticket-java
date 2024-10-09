package modules.tstravel2service.travel2.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import modules.tscommon.edu.fudan.common.entity.TripResponse;
/**
 *
 * @author fdse
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TripAllDetail {
    private boolean status;

    private String message;

    private TripResponse tripResponse;

    private TripFromtstravel2service trip;
}