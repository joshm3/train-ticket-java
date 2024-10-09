package ticketoffice.init;

import ticketoffice.entity.Office;
import ticketoffice.repository.OfficeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.UUID;

/**
 * @author fdse
 */
@Component
public class InitOffice implements CommandLineRunner {

    @Autowired
    private OfficeRepository officeRepository;

    @Override
    public void run(String... strings) throws Exception {
        Office oldOffice = officeRepository.findByName("Jinqiao Road ticket sales outlets");
        if (oldOffice == null) {
            Office office = new Office("Jinqiao Road ticket sales outlets", "Shanghai", "Shanghai", "Pudong New Area", "Jinqiao Road 1320, Shanghai, Pudong New Area", "08:00-18:00", 1);
            officeRepository.save(office);
        }
    }
}
