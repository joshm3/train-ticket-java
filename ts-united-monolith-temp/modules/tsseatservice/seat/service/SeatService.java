package modules.tsseatservice.seat.service;
import modules.tscommon.edu.fudan.common.entity.Seat;
import modules.tscommon.edu.fudan.common.util.Response;
import org.springframework.http.HttpHeaders;
/**
 *
 * @author fdse
 */
public interface SeatService {
    Response distributeSeat(Seat seatRequest, HttpHeaders headers);

    Response getLeftTicketOfInterval(Seat seatRequest, HttpHeaders headers);
}