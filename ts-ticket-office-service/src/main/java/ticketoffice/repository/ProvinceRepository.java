package ticketoffice.repository;

import ticketoffice.entity.Province;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProvinceRepository extends CrudRepository<Province, String> {

    @Override
    List<Province> findAll();

    Province findByProvince(String name);
}
