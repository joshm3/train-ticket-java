package modules.tsticketofficeservice.ticketoffice.entity;
import java.util.List;
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
@Table(name = "cities")
public class City {
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // private String id; // Unique ID for the region
    @Id
    private String city;// City name


    // @ElementCollection
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Region> regions;// List of regions in the city

}