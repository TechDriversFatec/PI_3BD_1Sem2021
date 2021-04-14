package com.airplan.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airplan.api.model.FlagModel;
import com.airplan.api.service.FlagService;



@RestController
@RequestMapping("/createFlag")
public class FlagController {

    @Autowired
    private FlagService flagService;

    @PostMapping
    public ResponseEntity<Void> cadastrarFlag(@RequestBody FlagModel flagModel){
        flagService.createFlag(flagModel);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}