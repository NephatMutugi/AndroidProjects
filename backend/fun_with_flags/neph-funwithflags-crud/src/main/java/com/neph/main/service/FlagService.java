package com.neph.main.service;

import com.neph.main.entity.Flag;
import com.neph.main.model.RequestPayload;
import com.neph.main.model.ResponsePayload;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @ Author NMuchiri
 **/
public interface FlagService {

    ResponseEntity<List<Flag>> findAllFlags();
    ResponseEntity<Flag> findFlagByCountry(RequestPayload requestPayload);
    ResponseEntity<List<Flag>> findFlagsInContinent(RequestPayload requestPayload);
    ResponseEntity<ResponsePayload> saveFlag(RequestPayload requestPayload);
    ResponseEntity<ResponsePayload> deleteFlag(String countryName);

}
