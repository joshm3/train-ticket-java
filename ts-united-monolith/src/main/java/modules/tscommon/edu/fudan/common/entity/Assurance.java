package modules.tscommon.edu.fudan.common.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.UUID;
import lombok.Data;
import javax.validation.constraints.NotNull;
/**
 *
 * @author fdse
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Assurance {
    private UUID id;

    /**
     * which order the assurance is related to
     */
    @NotNull
    private UUID orderId;

    /**
     * the type of assurance
     */
    private AssuranceType type;

    public Assurance() {
        this.orderId = UUID.randomUUID();
    }

    public Assurance(UUID id, UUID orderId, AssuranceType type) {
        this.id = id;
        this.orderId = orderId;
        this.type = type;
    }
}