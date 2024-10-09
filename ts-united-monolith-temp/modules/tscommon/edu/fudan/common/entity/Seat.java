package modules.tscommon.edu.fudan.common.entity;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
/**
 *
 * @author fdse
 */
@Data
@AllArgsConstructor
public class Seat {
    @Valid
    @NotNull
    private String travelDate;

    @Valid
    @NotNull
    private String trainNumber;

    @Valid
    @NotNull
    private String startStation;

    @Valid
    @NotNull
    private String destStation;

    @Valid
    @NotNull
    private int seatType;

    private int totalNum;

    private List<String> stations;

    public Seat() {
        // Default Constructor
        this.travelDate = "";
        this.trainNumber = "";
        this.startStation = "";
        this.destStation = "";
        this.seatType = 0;
        this.totalNum = 0;
        this.stations = null;
    }
}