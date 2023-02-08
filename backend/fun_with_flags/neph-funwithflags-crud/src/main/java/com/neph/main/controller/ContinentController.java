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
@RequestMapping("api/v1/continents")
@RestController
public class ContinentController {
    private final ContinentService continentService;

    public ContinentController(ContinentService continentService) {
        this.continentService = continentService;
    }

    @GetMapping(value = "all")
    public ResponseEntity<List<Continent>> findAll(){
        return continentService.findAll();
    }

    @GetMapping()
    public ResponseEntity<Continent> findContinent(@RequestBody RequestPayload requestPayload){
        return continentService.findContinent(requestPayload);
    }

    @PostMapping("/add")
    public ResponseEntity<ResponsePayload> save(@RequestBody Continent continent){
        return continentService.save(continent);
    }
}
