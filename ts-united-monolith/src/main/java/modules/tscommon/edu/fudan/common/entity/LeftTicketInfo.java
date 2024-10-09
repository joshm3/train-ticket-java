package modules.tscommon.edu.fudan.common.entity;
import java.util.Set;
import lombok.Data;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
/**
 *
 * @author fdse
 */
@Data
public class LeftTicketInfo {
    @Valid
    @NotNull
    private Set<Ticket> soldTickets;

    public LeftTicketInfo() {
        // Default Constructor
    }

    @Override
    public String toString() {
        return (("LeftTicketInfo{" + "soldTickets=") + soldTickets) + '}';
    }
}