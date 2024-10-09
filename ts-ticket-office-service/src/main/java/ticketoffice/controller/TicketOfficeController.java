package ticketoffice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import ticketoffice.service.impl.TicketOfficeService;
import ticketoffice.entity.Office;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/office")
public class TicketOfficeController {

    @Autowired
    private TicketOfficeService ticketOfficeService;

    private static final Logger logger = LoggerFactory.getLogger(TicketOfficeController.class);

    @GetMapping
    public String welcome() {
        return "welcome to ts-ticket-office-service";
    }

    @GetMapping("/getRegionList")
    public ResponseEntity<?> getRegionList() {
        logger.info("TicketOfficeService getRegionList");
        return ResponseEntity.ok(ticketOfficeService.getRegionList());
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        logger.info("TicketOfficeService getAll");
        return ResponseEntity.ok(ticketOfficeService.getAllOffices());
    }

    @PostMapping("/getSpecificOffices")
    public ResponseEntity<?> getSpecificOffices(@RequestBody Map<String, String> data) {
        logger.info("TicketOfficeService getSpecificOffices");
        return ResponseEntity.ok(ticketOfficeService.getSpecificOffices((String)data.get("province"), (String)data.get("city"), (String)data.get("region")));
    }

    @PostMapping("/addOffice")
    public ResponseEntity<?> addOffice(@RequestBody Map<String, Object> data) {
        logger.info("TicketOfficeService addOffice");
        @SuppressWarnings("unchecked") Map<String, Object> office = (Map<String,Object>)data.get("office");
        Office newOffice = new Office((String)office.get("name"), (String)data.get("city"), (String)data.get("province"), (String)data.get("region"), (String)office.get("address"), (String)office.get("workTime"), (int)office.get("windowNum"));
        return ResponseEntity.ok(ticketOfficeService.addOffice(newOffice));
    }

    @PostMapping("/deleteOffice")
    public ResponseEntity<?> deleteOffice(@RequestBody Map<String, String> data) {
        logger.info("TicketOfficeService deleteOffice");
        return ResponseEntity.ok(ticketOfficeService.deleteOffice(data.get("province"), data.get("city"), data.get("region"), data.get("officeName")));
    }

    @PostMapping("/updateOffice")
    public ResponseEntity<?> updateOffice(@RequestBody Map<String, Object> data) {
        logger.info("TicketOfficeService updateOffice");
        @SuppressWarnings("unchecked") Map<String, Object> office = (Map<String,Object>)data.get("newOffice");
        Office newOffice = new Office((String)office.get("name"), (String)data.get("city"), (String)data.get("province"), (String)data.get("region"), (String)office.get("address"), (String)office.get("workTime"), (int)office.get("windowNum"));
        
        return ResponseEntity.ok(ticketOfficeService.updateOffice((String)data.get("province"), (String)data.get("city"), (String)data.get("region"), (String)data.get("oldOfficeName"), newOffice));
    }
}

