package modules.tssecurityservice.security.repository;
import java.util.ArrayList;
import java.util.Optional;
import modules.tssecurityservice.security.entity.SecurityConfig;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author fdse
 */
@Repository
public interface SecurityRepository extends CrudRepository<SecurityConfig, String> {
    SecurityConfig findByName(String name);

    Optional<SecurityConfig> findById(String id);

    @Override
    ArrayList<SecurityConfig> findAll();

    void deleteById(String id);
}