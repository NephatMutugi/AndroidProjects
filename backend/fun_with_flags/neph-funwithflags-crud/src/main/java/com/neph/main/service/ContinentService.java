package com.neph.main.service;

import com.neph.main.model.Continent;
import com.neph.main.model.RequestPayload;
import com.neph.main.model.ResponsePayload;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @ Author NMuchiri
 **/
public interface ContinentService {
    ResponseEntity<List<Continent>> findAll();
    ResponseEntity<Continent> findContinent(RequestPayload requestPayload);
    ResponseEntity<ResponsePayload> save(Continent continent);

    ResponseEntity<?> delete(String name);
}
