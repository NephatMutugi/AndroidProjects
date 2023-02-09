package com.neph.main.service.impl;

import com.neph.main.entity.Country;
import com.neph.main.model.RequestPayload;
import com.neph.main.model.ResponsePayload;
import com.neph.main.service.CountryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ Author NMuchiri
 **/
@Slf4j
@Service
public class CountryServiceImpl implements CountryService {
    @Override
    public ResponseEntity<List<Country>> findAllInContinent(RequestPayload requestPayload) {
        return null;
    }

    @Override
    public ResponseEntity<?> findCountry(RequestPayload requestPayload) {
        return null;
    }

    @Override
    public ResponseEntity<ResponsePayload> save(RequestPayload requestPayload) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(String name) {
        return null;
    }
}
