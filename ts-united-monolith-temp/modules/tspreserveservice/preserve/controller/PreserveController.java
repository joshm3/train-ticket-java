package modules.tspreserveservice.preserve.controller;
import modules.tscommon.edu.fudan.common.entity.OrderTicketsInfo;
import modules.tspreserveservice.preserve.service.PreserveService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.ResponseEntity.ok;
/**
 *
 * @author fdse
 */
@RestController
@RequestMapping("/api/v1/preserveservice")
public class PreserveController {
    @Autowired
    private PreserveService preserveService;

    private static final Logger LOGGER = LoggerFactory.getLogger(PreserveController.class);

    @GetMapping(path = "/welcome")
    public String home() {
        return "Welcome to [ Preserve Service ] !";
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/preserve")
    public HttpEntity preserve(@RequestBody
    OrderTicketsInfo oti, @RequestHeader
    HttpHeaders headers) {
        PreserveController.LOGGER.info("[preserve][Preserve Account order][from {} to {} at {}]", oti.getFrom(), oti.getTo(), oti.getDate());
        return ok(preserveService.preserve(oti, headers));
    }
}