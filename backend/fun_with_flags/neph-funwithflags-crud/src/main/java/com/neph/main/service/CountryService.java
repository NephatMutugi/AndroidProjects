package com.neph.main.service;

import com.neph.main.model.Country;
import com.neph.main.model.RequestPayload;
import com.neph.main.model.ResponsePayload;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @ Author NMuchiri
 **/
public interface CountryService {
    ResponseEntity<List<Country>> findAllInContinent(RequestPayload requestPayload);
    ResponseEntity<?> findCountry(RequestPayload requestPayload);
    ResponseEntity<ResponsePayload> save(RequestPayload requestPayload);
    ResponseEntity<?> delete(String name);
}
