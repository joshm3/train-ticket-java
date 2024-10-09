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
@Table(name = "provinces")
public class Province {
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // private String id; // Unique ID for the region
    @Id
    private String province;// Province name


    // @ElementCollection
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<City> cities;// List of cities in the province

}