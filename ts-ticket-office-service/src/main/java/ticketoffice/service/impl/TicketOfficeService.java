package ticketoffice.service.impl;

import ticketoffice.repository.OfficeRepository;
import ticketoffice.entity.Office;
import ticketoffice.repository.ProvinceRepository;
import ticketoffice.entity.Province;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.MessageFormat;
import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class TicketOfficeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TicketOfficeService.class);

    @Autowired
    private ProvinceRepository provinceRepository;

    @Autowired
    private OfficeRepository officeRepository;

    ObjectMapper mapper = new ObjectMapper();

    public String getRegionList() {
        // Logic to read region.json and return its content
        // You may want to use a JSON library like Jackson or Gson
        List<Province> provinces = provinceRepository.findAll();
        try {
            String json = mapper.writeValueAsString(provinces);
            return (json);
        } catch (Exception e) {
            return ("error");
        }
        
    }

    public String getAllOffices() {
        // Logic to fetch all offices from the database
        List<Office> offices = officeRepository.findAll();
        try {
            String json = mapper.writeValueAsString(offices);
            return (json);
        } catch (Exception e) {
            return ("error");
        }
    }

    public String getSpecificOffices(String province, String city, String region) {
        // Logic to get specific offices based on the request

        //find offices based on province, city, and region
        List<Office> offices = officeRepository.findByProvinceAndCityAndRegion(province, city, region);
        try {
            String json = mapper.writeValueAsString(offices);
            return (json);
        } catch (Exception e) {
            return ("error");
        }
    }

    @Transactional
    public String addOffice(Office officeRequest) {
        if (officeRequest.getName()==null) {
            TicketOfficeService.LOGGER.info("Could not save office, no name " + officeRequest.toString());
            return "failure";
        }
        // Logic to add a new office
        officeRepository.save(officeRequest);
        return "\"insert succeed.\"";
    }

    @Transactional
    public String deleteOffice(String province, String city, String region, String officeName) {
        // Logic to delete an office
        officeRepository.deleteByProvinceAndCityAndRegionAndName(province, city, region, officeName);
        return ("Number of records deleted: " + "deleted.toString()");
    }

    @Transactional
    public String updateOffice(String province, String region, String city, String oldOfficeName, Office newOffice) {
        // Logic to update an office
        deleteOffice(province, city, region, oldOfficeName);
        officeRepository.save(newOffice);
        return ("Number of records updated: " + "updated.toString()");
    }
}

