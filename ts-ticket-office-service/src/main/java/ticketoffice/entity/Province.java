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
@Table(name = "provinces")
public class Province {

    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // private String id; // Unique ID for the region

    @Id
    private String province; // Province name

    // @ElementCollection
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<City> cities; // List of cities in the province
}
