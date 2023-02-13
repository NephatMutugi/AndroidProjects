package com.neph.main.service.impl;

import com.neph.main.entity.Country;
import com.neph.main.entity.Flag;
import com.neph.main.model.RequestPayload;
import com.neph.main.model.ResponsePayload;
import com.neph.main.repo.CountryRepository;
import com.neph.main.repo.FlagRepository;
import com.neph.main.service.FlagService;
import com.neph.main.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ Author NMuchiri
 **/
@Slf4j
@Service
public class FlagServiceImpl implements FlagService {

    private final FlagRepository flagRepository;
    private final CountryRepository countryRepository;

    public FlagServiceImpl(FlagRepository flagRepository, CountryRepository countryRepository) {
        this.flagRepository = flagRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public ResponseEntity<List<Flag>> findAllFlags() {
        List<Flag> flagList = flagRepository.findAll();
        log.info("FOUND:: {} flags", flagList.size());
        return new ResponseEntity<>(flagList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> findFlagByCountry(RequestPayload requestPayload) {
        String countryName = requestPayload.getBusinessKeyValue();
        Flag flag = flagRepository.findFlagByCountryCountryName(countryName);
        log.info("findFlagByCountry");
        log.info("REQUEST: {}", Utils.objectToJson(requestPayload));
        if (flag != null){
            log.info("RESPONSE: {}", Utils.objectToJson(flag));
            return new ResponseEntity<>(flag, HttpStatus.OK);
        } else {
            log.error("RESPONSE: Unable to find {} flag", requestPayload.getBusinessKeyValue());
            return new ResponseEntity<>(new ResponsePayload("400", countryName + " not among the countries added"), HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<List<Flag>> findFlagsInContinent(RequestPayload requestPayload) {
        List<Flag> flagList = flagRepository.findFlagsByContinent(requestPayload.getBusinessKeyValue());
        log.info("THERE ARE {} FLAGS IN {}", flagList.size(), requestPayload.getBusinessKeyValue());
        return new ResponseEntity<>(flagList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponsePayload> saveFlag(RequestPayload requestPayload) {
        String countryName = requestPayload.getBusinessKey();
        String imageUrl = requestPayload.getBusinessKeyValue();
        Country country = countryRepository.findCountryByCountryName(countryName);

        if (country != null) {
            return saveFlag(imageUrl, country);
        }
        return new ResponseEntity<>(new ResponsePayload(
                "400",
                "Failed to create flag: " + countryName
        ), HttpStatus.OK);
    }


    @Override
    public ResponseEntity<ResponsePayload> deleteFlag(RequestPayload requestPayload) {
        String countryName = requestPayload.getBusinessKeyValue();

        try {
            Country country = countryRepository.findCountryByCountryName(countryName);
            flagRepository.deleteFlagByCountry(country);
            return new ResponseEntity<>(new ResponsePayload("200", "Deleted " + countryName), HttpStatus.OK);
        } catch (Exception e) {
            log.error("ERROR WHILE DELETING COUNTRY:: {}", e.getMessage());
            return new ResponseEntity<>(new ResponsePayload("400", "Failed to delete " + countryName), HttpStatus.OK);
        }

    }


    private ResponseEntity<ResponsePayload> saveFlag(String imageUrl, Country country) {
        try {
            Flag flag = flagRepository.save(new Flag(imageUrl, country));
            log.info("CREATED FLAG: {}", Utils.objectToJson(flag));
            if (flag.getId() != null) {
                return new ResponseEntity<>(new ResponsePayload(
                        "200",
                        "Country: " + country.getCountryName() + " created with flag: " + flag.getImageUrl()
                ), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new ResponsePayload(
                        "400",
                        "Failed to create flag: " + imageUrl
                ), HttpStatus.OK);
            }
        } catch (Exception e) {
            log.error("CREATE FLAG {}: {}", imageUrl, e.getMessage());
            return new ResponseEntity<>(new ResponsePayload("400",
                    e.getMessage()), HttpStatus.OK);
        }
    }
}
