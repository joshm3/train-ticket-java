package ticketoffice.init;

import ticketoffice.entity.Province;
import ticketoffice.entity.City;
import ticketoffice.entity.Region;
import ticketoffice.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fdse
 */
@Component
public class InitProvince implements CommandLineRunner {

    @Autowired
    private ProvinceRepository provinceRepository;

    @Override
    public void run(String... strings) throws Exception {
        Province oldProvince = provinceRepository.findByProvince("Shanghai");
        if (oldProvince == null) {
            //shanghai
            List<City> cities = new ArrayList<City>();

            List<Region> regions = new ArrayList<Region>();
            regions.add(new Region("Pudong New Area"));
            cities.add(new City("Shanghai", regions));

            provinceRepository.save(new Province("Shanghai", cities));
        }

        oldProvince = provinceRepository.findByProvince("Anhui");
        if (oldProvince == null) {
            //anhui
            List<City> cities = new ArrayList<City>();

            List<Region> regions = new ArrayList<Region>();
            regions.add(new Region("Heifei Downtown Area"));
            regions.add(new Region("Feixi County"));
            cities.add(new City("Heifei", regions));

            regions = new ArrayList<Region>();
            regions.add(new Region("Anqing Downtown Area"));
            cities.add(new City("Anqing", regions));

            provinceRepository.save(new Province("Anhui", cities));
        }
    }
}
