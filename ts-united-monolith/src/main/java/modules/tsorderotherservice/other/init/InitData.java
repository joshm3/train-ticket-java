package modules.tsorderotherservice.other.init;
import modules.tscommon.edu.fudan.common.entity.OrderStatus;
import modules.tscommon.edu.fudan.common.entity.SeatClass;
import modules.tsorderotherservice.other.entity.OrderFromtsorderotherservice;
import modules.tsorderotherservice.other.service.OrderOtherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
/**
 *
 * @author fdse
 */
@Component("initDataFromtsorderotherservice")
public class InitData implements CommandLineRunner {
    @Autowired
    OrderOtherService service;

    @Override
    public void run(String... args) throws Exception {
        OrderFromtsorderotherservice order1 = new OrderFromtsorderotherservice();
        order1.setAccountId("4d2a46c7-71cb-4cf1-b5bb-b68406d9da6f");
        order1.setCoachNumber(5);
        order1.setContactsDocumentNumber("Test");
        order1.setContactsName("Test");
        order1.setDocumentType(1);
        order1.setFrom("shanghai");
        order1.setId("4d2a46c7-71cb-4cf1-c5bb-b68406d9da6f");
        order1.setPrice("100");
        order1.setSeatClass(SeatClass.FIRSTCLASS.getCode());
        order1.setSeatNumber("6A");
        order1.setStatus(OrderStatus.PAID.getCode());
        order1.setTo("taiyuan");
        order1.setTrainNumber("K1235");
        order1.setTravelDate("2022-10-01 00:00:00");// NOSONAR

        order1.setTravelTime("2022-10-01 00:00:00");// NOSONAR

        service.create(order1, null);
    }
}