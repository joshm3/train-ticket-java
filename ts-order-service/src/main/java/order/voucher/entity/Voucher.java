package order.voucher.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity
@Builder
@AllArgsConstructor
public class Voucher {

    public Voucher(){}

    @Id
    private Long voucherId;

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

    // Getters and Setters
}
