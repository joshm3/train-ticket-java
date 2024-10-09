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
@Table(name = "inside_money")
public class MoneyFromtsinsidepaymentservice {
    @Valid
    @NotNull
    @Id
    @Column(length = 36)
    @GeneratedValue(generator = "jpa-uuid")
    private String id;

    @Valid
    @NotNull
    @Column(length = 36)
    private String userId;

    @Valid
    @NotNull
    private String money;// NOSONAR


    @Valid
    @NotNull
    @Enumerated(EnumType.STRING)
    private MoneyType type;

    public MoneyFromtsinsidepaymentservice() {
        this.userId = "";
        this.money = "";
    }
}