package modules.tsinsidepaymentservice.inside_payment.entity;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
/**
 *
 * @author fdse
 */
@Data
@Entity
@GenericGenerator(name = "jpa-uuid", strategy = "org.hibernate.id.UUIDGenerator")
@Table(name = "inside_payment")
public class PaymentFromtsinsidepaymentservice {
    @Id
    @NotNull
    @Column(length = 36)
    @GeneratedValue(generator = "jpa-uuid")
    private String id;

    @NotNull
    @Valid
    @Column(length = 36)
    private String orderId;

    @NotNull
    @Valid
    @Column(length = 36)
    private String userId;

    @NotNull
    @Valid
    private String price;

    @NotNull
    @Valid
    @Enumerated(EnumType.STRING)
    private PaymentType type;

    public PaymentFromtsinsidepaymentservice() {
        this.orderId = "";
        this.userId = "";
        this.price = "";
    }
}