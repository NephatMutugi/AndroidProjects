package com.neph.main.service;

import com.neph.main.model.Continent;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @ Author NMuchiri
 **/
public interface ContinentService {
    ResponseEntity<List<Continent>> findAll();
    ResponseEntity<Continent> findByName(String  name);
    ResponseEntity<Continent> findByAbbreviation(String abbreviation);
    void save(Continent continent);

    ResponseEntity<?> delete(String name);
}
