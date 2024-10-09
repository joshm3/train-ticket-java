package modules.tsticketofficeservice.ticketoffice.entity;
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
@Table(name = "offices")
public class Office {
    @Id
    private String name;// Name of the office


    private String city;// Address of the office


    private String province;

    private String region;

    private String address;

    private String workTime;// Working hours of the office


    private int windowNum;// Number of ticket windows

}