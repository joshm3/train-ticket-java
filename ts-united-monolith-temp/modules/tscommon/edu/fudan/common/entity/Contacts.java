package modules.tscommon.edu.fudan.common.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 *
 * @author fdse
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
public class Contacts {
    private UUID id;

    private UUID accountId;

    private String name;

    private int documentType;

    private String documentNumber;

    private String phoneNumber;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Contacts other = ((Contacts) (obj));
        return (((name.equals(other.getName()) && accountId.equals(other.getAccountId())) && documentNumber.equals(other.getDocumentNumber())) && phoneNumber.equals(other.getPhoneNumber())) && (documentType == other.getDocumentType());
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = (31 * result) + (id == null ? 0 : id.hashCode());
        return result;
    }
}