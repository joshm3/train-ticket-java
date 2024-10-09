package modules.tscommon.edu.fudan.common.entity;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import lombok.Data;
@Data
public class StationFoodStore implements Serializable {
    private UUID id;

    private String stationName;

    private String storeName;

    private String telephone;

    private String businessTime;

    private double deliveryFee;

    private List<Food> foodList;

    public StationFoodStore() {
        // Default Constructor
    }
}