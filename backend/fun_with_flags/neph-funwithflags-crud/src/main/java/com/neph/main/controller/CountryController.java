package com.neph.main.controller;

import com.neph.main.entity.Country;
import com.neph.main.model.RequestPayload;
import com.neph.main.model.ResponsePayload;
import com.neph.main.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ Author NMuchiri
 **/
@RequestMapping("api/v1/country")
@RestController
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping(value = "/all", produces = {"application/json"})
    public ResponseEntity<List<Country>> findAllCountries(){
        return countryService.findAllCountries();
    }

    @PostMapping(value = "/continent", produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<List<Country>> findAllInContinent(@RequestBody RequestPayload requestPayload){
        return countryService.findAllInContinent(requestPayload);
    }

    @PostMapping(value = "one", produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<?> findCountry(@RequestBody RequestPayload requestPayload){
        return countryService.findCountry(requestPayload);
    }

    @PostMapping(value = "save", produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<ResponsePayload> addCountry(@RequestBody RequestPayload requestPayload){
        return countryService.save(requestPayload);
    }

}
