package com.neph.main.service.impl;

import com.neph.main.entity.Continent;
import com.neph.main.entity.Country;
import com.neph.main.model.RequestPayload;
import com.neph.main.model.ResponsePayload;
import com.neph.main.repo.ContinentRepository;
import com.neph.main.repo.CountryRepository;
import com.neph.main.service.CountryService;
import com.neph.main.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author NMuchiri
 **/
@Slf4j
@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;
    private final ContinentRepository continentRepository;

    public CountryServiceImpl(CountryRepository countryRepository, ContinentRepository continentRepository) {
        this.countryRepository = countryRepository;
        this.continentRepository = continentRepository;
    }

    @Override
    public ResponseEntity<List<Country>> findAllCountries() {
        List<Country> countryList = countryRepository.findAll();
        log.info("Total Number of Countries: {}", countryList.size());
        return new ResponseEntity<>(countryList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Country>> findAllInContinent(RequestPayload requestPayload) {
        List<Country> countryList = new ArrayList<>();
        if ((requestPayload.getBusinessKey().equalsIgnoreCase(Constants.NAME.getName()))){
            Continent continent = continentRepository.findContinentByContinentName(requestPayload.getBusinessKeyValue());
            countryList = countryRepository.findCountriesByContinent(continent);
        } else if ((requestPayload.getBusinessKey().equalsIgnoreCase(Constants.ABBREVIATION.getName()))) {
            Continent continent = continentRepository.findContinentByAbbreviation(requestPayload.getBusinessKeyValue());
            countryList = countryRepository.findCountriesByContinent(continent);
        }

        if (countryList.size() == 0){
            log.error("FAILED TO GET ANY COUNTRIES IN CONTINENT {}", requestPayload.getBusinessKeyValue());
        }
        return new ResponseEntity<>(countryList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> findCountry(RequestPayload requestPayload) {

        if ((requestPayload.getBusinessKey().equalsIgnoreCase("Query"))) {
            Country country = countryRepository.findCountryByCountryName(requestPayload.getBusinessKeyValue());
            if (country != null) {
                return new ResponseEntity<>(country, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(
                        new ResponsePayload("404", "NO COUNTRY WAS FOUND WITH NAME: "
                                + requestPayload.getBusinessKeyValue()),
                        HttpStatus.OK);
            }
        } else {
            return new ResponseEntity<>(new ResponsePayload("400",
                    "Please use businessKey \"Query\" to query a country"), HttpStatus.OK);
        }

    }

    @Override
    public ResponseEntity<ResponsePayload> save(RequestPayload requestPayload) {
        String continentName = requestPayload.getBusinessKey();
        String countryName = requestPayload.getBusinessKeyValue();
        Continent continent = continentRepository.findContinentByContinentName(continentName);

        if (continent != null) {
            countryRepository.save(new Country(countryName, continent));
        } else {
            continent = continentRepository.findContinentByAbbreviation(continentName);
            if (continent != null) {
                countryRepository.save(new Country(countryName, continent));
            } else {
                return new ResponseEntity<>(new ResponsePayload("400",
                        "Continents: " + continentsList()), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(new ResponsePayload("400",
                "Failed to create country"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> delete(String name) {
        countryRepository.deleteCountryByCountryName(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private String continentsList() {
        List<Continent> continentList = continentRepository.findAll();
        StringBuilder continentBuilder = new StringBuilder();
        for (Continent continent : continentList) {
            String continentName = continent.getContinentName();
            continentBuilder.append(continentName).append(", ");
        }
        String continents = continentBuilder.toString().trim();
        return continents.replaceAll(",&", "");

    }

}
