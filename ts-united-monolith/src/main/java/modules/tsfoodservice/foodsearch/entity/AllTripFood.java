package modules.tsfoodservice.foodsearch.entity;
import java.util.List;
import java.util.Map;
import lombok.Data;
import modules.tscommon.edu.fudan.common.entity.Food;
import modules.tscommon.edu.fudan.common.entity.StationFoodStore;
@Data
public class AllTripFood {
    private List<Food> trainFoodList;

    private Map<String, List<StationFoodStore>> foodStoreListMap;

    public AllTripFood() {
        // Default Constructor
    }
}