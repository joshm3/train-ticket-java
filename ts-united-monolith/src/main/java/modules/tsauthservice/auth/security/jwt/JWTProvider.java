package modules.tsauthservice.auth.security.jwt;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Base64;
import java.util.Date;
import modules.tsauthservice.auth.constant.InfoConstant;
import modules.tsauthservice.auth.entity.UserFromtsauthservice;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
/**
 *
 * @author fdse
 */
@Component
public class JWTProvider {
    private String secretKey = "secret";

    private long validityInMilliseconds = 3600000;

    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public String createToken(UserFromtsauthservice user) {
        Claims claims = Jwts.claims().setSubject(user.getUsername());
        claims.put(InfoConstant.ROLES, user.getRoles());
        claims.put(InfoConstant.ID, user.getUserId());
        Date now = new Date();
        Date validate = new Date(now.getTime() + validityInMilliseconds);
        return Jwts.builder().setClaims(claims).setIssuedAt(now).setExpiration(validate).signWith(SignatureAlgorithm.HS256, secretKey).compact();
    }
}