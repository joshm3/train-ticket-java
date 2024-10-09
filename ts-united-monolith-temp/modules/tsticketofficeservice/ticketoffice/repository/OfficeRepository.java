package modules.tsticketofficeservice.ticketoffice.repository;
import java.util.List;
import modules.tsticketofficeservice.ticketoffice.entity.Office;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface OfficeRepository extends CrudRepository<Office, String> {
    // @Override
    // Optional<Office> findById(String id);
    Office findByName(String name);

    List<Office> findByProvinceAndCityAndRegion(String province, String city, String region);

    void deleteByProvinceAndCityAndRegionAndName(String province, String city, String region, String name);

    @Override
    List<Office> findAll();

    void deleteByName(String name);
}