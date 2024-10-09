package modules.tsinsidepaymentservice.inside_payment.entity;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import lombok.Data;
/**
 *
 * @author fdse
 */
@Data
public class Balance {
    @Valid
    @NotNull
    private String userId;

    @Valid
    @NotNull
    private String balance;// NOSONAR


    public Balance() {
        // Default Constructor
        this.userId = "";
        this.balance = "";
    }
}