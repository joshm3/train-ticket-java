package modules.tsconfigservice.config.repository;
import java.util.List;
import modules.tsconfigservice.config.entity.Config;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author fdse
 */
public interface ConfigRepository extends CrudRepository<Config, String> {
    /**
     * find by name
     *
     * @param name
     * 		name
     * @return Config
     */
    Config findByName(String name);

    /**
     * find all
     *
     * @return List<Config>
     */
    @Override
    List<Config> findAll();

    /**
     * delete by name
     *
     * @param name
     * 		name
     * @return null
     */
    void deleteByName(String name);
}