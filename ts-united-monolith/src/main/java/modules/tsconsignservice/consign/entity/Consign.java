package modules.tsconsignservice.consign.entity;
import javax.persistence.*;
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
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Consign {
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 36)
    private String id;

    // id????String??? ???????
    private String orderId;// ????????


    private String accountId;// ?????????


    private String handleDate;

    private String targetDate;

    private String from;

    private String to;

    private String consignee;

    private String phone;

    private double weight;

    private boolean isWithin;
}