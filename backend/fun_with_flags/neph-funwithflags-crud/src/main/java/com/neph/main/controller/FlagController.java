package com.neph.main.controller;

import com.neph.main.entity.Flag;
import com.neph.main.model.RequestPayload;
import com.neph.main.model.ResponsePayload;
import com.neph.main.service.FlagService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ Author NMuchiri
 **/
@RestController
@RequestMapping("api/v1/flag")
public class FlagController {

    private final FlagService flagService;

    public FlagController(FlagService flagService) {
        this.flagService = flagService;
    }

    @GetMapping(value = "/all", produces = {"application/json"})
    public ResponseEntity<List<Flag>> findAllFlags(){
        return flagService.findAllFlags();
    }

    @PostMapping(value = "/continent", produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<List<Flag>> findFlagsInContinent(@RequestBody RequestPayload requestPayload){
        return flagService.findFlagsInContinent(requestPayload);
    }

    @PostMapping(value = "/country", produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<?> findFlagByCountry(@RequestBody RequestPayload requestPayload){
        return flagService.findFlagByCountry(requestPayload);
    }

    @PostMapping(value = "save", produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<ResponsePayload> addCountry(@RequestBody RequestPayload requestPayload){
        return flagService.saveFlag(requestPayload);
    }

    @PostMapping(value = "delete", produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<ResponsePayload> deleteFlag(@RequestBody RequestPayload requestPayload){
        return flagService.deleteFlag(requestPayload);
    }
}
