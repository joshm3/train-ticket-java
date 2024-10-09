package modules.tsauthservice.auth.repository;
import java.util.Optional;
import modules.tsauthservice.auth.entity.UserFromtsauthservice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author fdse
 */
@Repository("userRepositoryFromtsauthservice")
public interface UserRepository extends CrudRepository<UserFromtsauthservice, String> {
    /**
     * find by username
     *
     * @param username
    		username
     * @return Optional<User>
     */
    Optional<UserFromtsauthservice> findByUsername(String username);

    /**
     * delete by user id
     *
     * @param userId
     * 		user id
     * @return null
     */
    void deleteByUserId(String userId);
}