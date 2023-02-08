package com.neph.main.controller;

import com.neph.main.model.Continent;
import com.neph.main.model.RequestPayload;
import com.neph.main.model.ResponsePayload;
import com.neph.main.service.ContinentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ Author NMuchiri
 **/
@RequestMapping("/api/v1/continents")
@RestController
public class ContinentController {
    private final ContinentService continentService;

    public ContinentController(ContinentService continentService) {
        this.continentService = continentService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = {"application/json"})
    public ResponseEntity<List<Continent>> findAll(){
        return continentService.findAll();
    }

    @RequestMapping(value = "/find", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<Continent> findContinent(@RequestBody RequestPayload requestPayload){
        return continentService.findContinent(requestPayload);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<ResponsePayload> save(@RequestBody Continent continent){
        return continentService.save(continent);
    }
}
