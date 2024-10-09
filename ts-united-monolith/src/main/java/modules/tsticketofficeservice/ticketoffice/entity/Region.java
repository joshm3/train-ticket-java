package modules.tsticketofficeservice.ticketoffice.entity;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "regions")
public class Region {
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // private String id; // Unique ID for the region
    @Id
    private String region;// Name of the region

}