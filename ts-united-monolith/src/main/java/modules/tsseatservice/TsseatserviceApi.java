package modules.tsseatservice;
import modules.tscommon.edu.fudan.common.entity.Seat;
import modules.tsseatservice.seat.controller.SeatController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
@Component
public class TsseatserviceApi {
    @Autowired
    SeatController seatController;

    public HttpEntity postApiV1SeatserviceSeatsLeft_tickets(Seat seatRequest, HttpHeaders headers) {
        return seatController.getLeftTicketOfInterval(seatRequest, headers);
    }

    public HttpEntity postApiV1SeatserviceSeats(Seat seatRequest, HttpHeaders headers) {
        return seatController.create(seatRequest, headers);
    }
}