package modules.tstravel2service.travel2.entity;
import lombok.Data;
import modules.tscommon.edu.fudan.common.entity.Route;
import modules.tscommon.edu.fudan.common.entity.TrainType;
/**
 *
 * @author fdse
 */
@Data
public class AdminTrip {
    private Trip trip;

    private TrainType trainType;

    private Route route;

    public AdminTrip() {
        // Default Constructor
    }
}