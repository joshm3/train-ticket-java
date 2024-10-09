package ticketoffice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "offices")
public class Office {

    @Id
    private String name; // Name of the office
    private String city; // Address of the office
    private String province;
    private String region;
    private String address;
    private String workTime; // Working hours of the office
    private int windowNum; // Number of ticket windows
}
