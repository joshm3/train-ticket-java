package modules.tscommon.edu.fudan.common.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consign {
    private String id;

    // id????String??? ???????
    private String orderId;// ????????


    private String accountId;// ?????????


    private String handleDate;

    private String targetDate;

    private String from;

    private String to;

    private String consignee;

    private String phone;

    private double weight;

    private boolean isWithin;
}