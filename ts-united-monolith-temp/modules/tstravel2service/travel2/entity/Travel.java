package modules.tstravel2service.travel2.entity;
import lombok.Data;
/**
 *
 * @author fdse
 */
@Data
public class Travel {
    private Trip trip;

    private String startPlace;

    private String endPlace;

    private String departureTime;

    public Travel() {
        // Default Constructor
    }
}