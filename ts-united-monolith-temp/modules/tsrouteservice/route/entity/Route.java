package modules.tsrouteservice.route.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import java.util.UUID;
import javax.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
/**
 *
 * @author fdse
 */
@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@GenericGenerator(name = "jpa-uuid", strategy = "org.hibernate.id.UUIDGenerator")
public class Route {
    @Id
    @Column(length = 36)
    private String id;

    @ElementCollection(targetClass = String.class)
    @OrderColumn
    private List<String> stations;

    @ElementCollection(targetClass = Integer.class)
    @OrderColumn
    private List<Integer> distances;

    private String startStation;

    private String endStation;

    public Route() {
        this.id = UUID.randomUUID().toString();
    }

    public Route(String id, List<String> stations, List<Integer> distances, String startStation, String endStation) {
        this.id = id;
        this.stations = stations;
        this.distances = distances;
        this.startStation = startStation;
        this.endStation = endStation;
    }

    public Route(List<String> stations, List<Integer> distances, String startStation, String endStation) {
        this.id = UUID.randomUUID().toString();
        this.stations = stations;
        this.distances = distances;
        this.startStation = startStation;
        this.endStation = endStation;
    }
}