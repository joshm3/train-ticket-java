package modules.tscancelservice.cancel.entity;
import lombok.Data;
import modules.tscommon.edu.fudan.common.entity.Account;
/**
 *
 * @author fdse
 */
@Data
public class GetAccountByIdResult {
    private boolean status;

    private String message;

    private Account account;

    public GetAccountByIdResult() {
        // Default Constructor
    }
}