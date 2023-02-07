package com.neph.main.service.impl;

import com.neph.main.model.Continent;
import com.neph.main.repo.ContinentRepository;
import com.neph.main.service.ContinentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @ Author NMuchiri
 **/
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
    public ResponseEntity<Continent> findByName(String name) {
        Continent continent = continentRepository.findContinentByContinentName(name);
        if (!(continent.getContinentName().isEmpty())) {
            return new ResponseEntity<>(continent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(continent, HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public ResponseEntity<Continent> findByAbbreviation(String abbreviation) {
        Continent continent = continentRepository.findContinentByContinentName(abbreviation);
        if (!(continent.getContinentName().isEmpty())) {
            return new ResponseEntity<>(continent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(continent, HttpStatus.NOT_FOUND);
        }
    }


    @Override
    public void save(Continent continent) {
        continentRepository.save(continent);
    }

    @Override
    public ResponseEntity<?> delete(String name) {
        continentRepository.deleteContinentByContinentName(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
