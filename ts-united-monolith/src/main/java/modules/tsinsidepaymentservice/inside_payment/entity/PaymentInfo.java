package modules.tsinsidepaymentservice.inside_payment.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
/**
 *
 * @author fdse
 */
// public String getOrderId(){
// return this.orderId;
// }
@Data
@AllArgsConstructor
public class PaymentInfo {
    public PaymentInfo() {
        // Default Constructor
    }

    private String userId;

    private String orderId;

    private String tripId;

    private String price;
}