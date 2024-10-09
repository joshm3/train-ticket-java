package modules.tsticketofficeservice.ticketoffice.repository;
import java.util.List;
import modules.tsticketofficeservice.ticketoffice.entity.Province;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProvinceRepository extends CrudRepository<Province, String> {
    @Override
    List<Province> findAll();

    Province findByProvince(String name);
}