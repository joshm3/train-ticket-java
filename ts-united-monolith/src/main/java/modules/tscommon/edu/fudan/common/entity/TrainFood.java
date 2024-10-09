package modules.tscommon.edu.fudan.common.entity;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import lombok.Data;
@Data
public class TrainFood implements Serializable {
    public TrainFood() {
        // Default Constructor
    }

    private UUID id;

    private String tripId;

    private List<Food> foodList;
}