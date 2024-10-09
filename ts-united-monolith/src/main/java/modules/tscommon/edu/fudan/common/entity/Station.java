package modules.tscommon.edu.fudan.common.entity;
import java.util.Locale;
import lombok.Data;
@Data
public class Station {
    private String id;

    private String name;

    private int stayTime;

    public Station() {
        this.name = "";
    }

    public void setName(String name) {
        this.name = name.replace(" ", "").toLowerCase(Locale.ROOT);
    }

    public Station(String name) {
        this.name = name.replace(" ", "").toLowerCase(Locale.ROOT);
    }

    public Station(String name, int stayTime) {
        this.name = name.replace(" ", "").toLowerCase(Locale.ROOT);
        this.stayTime = stayTime;
    }
}