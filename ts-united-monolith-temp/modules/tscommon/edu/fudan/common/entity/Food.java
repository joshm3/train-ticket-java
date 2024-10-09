package modules.tscommon.edu.fudan.common.entity;
import java.io.Serializable;
import javax.persistence.Embeddable;
import lombok.Data;
@Data
@Embeddable
public class Food implements Serializable {
    private String foodName;

    private double price;

    public Food() {
        // Default Constructor
    }
}