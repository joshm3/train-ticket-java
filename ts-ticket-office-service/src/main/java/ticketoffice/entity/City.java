package ticketoffice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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
    private String city; // City name 

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    // @ElementCollection
    private List<Region> regions; // List of regions in the city
}
