package modules.tspriceservice.price.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.UUID;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
/**
 *
 * @author fdse
 */
@Data
@AllArgsConstructor
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(indexes = { @Index(name = "route_type_idx", columnList = "train_type, route_id", unique = true) })
public class PriceConfig {
    @Id
    @Column(length = 36)
    private String id;

    @Column(name = "train_type")
    private String trainType;

    @Column(name = "route_id", length = 36)
    private String routeId;

    private double basicPriceRate;

    private double firstClassPriceRate;

    public PriceConfig() {
        // Empty Constructor
        this.id = UUID.randomUUID().toString();
    }
}