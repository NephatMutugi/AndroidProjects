package com.neph.main.service.impl;

import com.neph.main.model.Continent;
import com.neph.main.model.RequestPayload;
import com.neph.main.model.ResponsePayload;
import com.neph.main.repo.ContinentRepository;
import com.neph.main.service.ContinentService;
import com.neph.main.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ Author NMuchiri
 **/
@Service
@Slf4j
public class ContinentServiceImpl implements ContinentService {

    private final ContinentRepository continentRepository;

    public ContinentServiceImpl(ContinentRepository continentRepository) {
        this.continentRepository = continentRepository;
    }

    @Override
    public ResponseEntity<List<Continent>> findAll() {
        return new ResponseEntity<>(continentRepository.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Continent> findContinent(RequestPayload requestPayload) {

        String businessKey = requestPayload.getBusinessKey();
        String businessKeyValue = requestPayload.getBusinessKeyValue();

        if (businessKey.equals(Constants.NAME.getName())) {
            Continent continent = continentRepository.findContinentByContinentName(businessKeyValue);
            if (!(continent.getContinentName().isEmpty())) {
                return new ResponseEntity<>(continent, HttpStatus.OK);
            } else {
                log.error("NO CONTINENT WAS FOUND WITH NAME {}", businessKeyValue);
                return new ResponseEntity<>(continent, HttpStatus.NOT_FOUND);
            }

        } else if (businessKey.equals(Constants.ABBREVIATION.getName())) {
            Continent continent = continentRepository.findContinentByAbbreviation(businessKeyValue);
            if (!(continent.getAbbreviation().isEmpty())) {
                return new ResponseEntity<>(continent, HttpStatus.OK);
            } else {
                log.error("NO CONTINENT WAS FOUND WITH ABBREVIATION {}", businessKeyValue);
                return new ResponseEntity<>(continent, HttpStatus.NOT_FOUND);
            }
        }

        return new ResponseEntity<>(new Continent(), HttpStatus.NOT_FOUND);
    }


    @Override
    public ResponseEntity<ResponsePayload> save(Continent continent) {
        Continent savedContinent = continentRepository.save(continent);
        ResponsePayload responsePayload = new ResponsePayload();
        String message;

        if (savedContinent.getId()!=null){

            message = "Continent created with ID: " +
                    savedContinent.getId() +
                    " and Name:" +
                    savedContinent.getContinentName();
            responsePayload.setMessage(message);
            responsePayload.setStatus("200");
            return new ResponseEntity<>(responsePayload, HttpStatus.OK);
        } else {
            message = "Failed to create continent " + continent.getContinentName();
            responsePayload.setMessage(message);
            return new ResponseEntity<>(responsePayload, HttpStatus.CONFLICT);
        }
    }

    @Override
    public ResponseEntity<?> delete(String name) {
        continentRepository.deleteContinentByContinentName(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
