package modules.tspaymentservice.com.trainticket.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
/**
 *
 * @author fdse
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@GenericGenerator(name = "jpa-uuid", strategy = "org.hibernate.id.UUIDGenerator")
@Entity
public class Money {
    @Id
    @Column(length = 36)
    @GeneratedValue(generator = "jpa-uuid")
    private String id;

    @Column(length = 36)
    private String userId;

    private String money;// NOSONAR

}