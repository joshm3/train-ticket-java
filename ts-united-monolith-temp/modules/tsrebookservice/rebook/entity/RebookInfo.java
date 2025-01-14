package modules.tsrebookservice.rebook.entity;
import java.util.Date;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import lombok.Data;
import modules.tscommon.edu.fudan.common.util.StringUtils;
/**
 *
 * @author fdse
 */
@Data
public class RebookInfo {
    @Valid
    @NotNull
    private String loginId;

    @Valid
    @NotNull
    private String orderId;

    @Valid
    @NotNull
    private String oldTripId;

    @Valid
    @NotNull
    private String tripId;

    @Valid
    @NotNull
    private int seatType;

    @Valid
    @NotNull
    private String date;

    public RebookInfo() {
        // Default Constructor
        this.loginId = "";
        this.orderId = "";
        this.oldTripId = "";
        this.tripId = "";
        this.seatType = 0;
        this.date = StringUtils.Date2String(new Date());
    }
}