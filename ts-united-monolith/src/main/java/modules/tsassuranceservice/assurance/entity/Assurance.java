package modules.tsassuranceservice.assurance.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.UUID;
import javax.persistence.*;
import lombok.Data;
import javax.validation.constraints.NotNull;
/**
 *
 * @author fdse
 */
@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Assurance {
    @Id
    @Column(name = "assurance_id")
    private String id;// ??


    /**
     * which order the assurance is related to
     */
    @NotNull
    private String orderId;// ?????????


    /**
     * the type of assurance
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "assurance_type")
    private AssuranceType type;

    public Assurance() {
        this.orderId = UUID.randomUUID().toString();
    }

    public Assurance(String id, String orderId, AssuranceType type) {
        this.id = id;
        this.orderId = orderId;
        this.type = type;
    }
}