package modules.tsvoucherservice.voucher.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
// Getters and Setters
@Data
@Table(name = "vouchers")
@Entity
@GenericGenerator(name = "jpa-uuid", strategy = "org.hibernate.id.UUIDGenerator")
@AllArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class VoucherFromtsvoucherservice {
    public VoucherFromtsvoucherservice() {
    }

    @Id
    @Column(length = 36)
    @GeneratedValue(generator = "jpa-uuid")
    private String voucher_id;

    @Column(nullable = false)
    private String orderId;

    @Column(nullable = false)
    private String travelDate;

    @Column(nullable = false)
    private String travelTime;

    @Column(nullable = false)
    private String contactName;

    @Column(nullable = false)
    private String trainNumber;

    @Column(nullable = false)
    private int seatClass;

    @Column(nullable = false)
    private String seatNumber;

    @Column(nullable = false)
    private String startStation;

    @Column(nullable = false)
    private String destStation;

    @Column(nullable = false)
    private String price;
}