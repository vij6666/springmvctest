package com.vijaysidhu.springmvc.controller;

import com.vijaysidhu.springmvc.model.Brewery;
import com.vijaysidhu.springmvc.service.BreweryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@RestController
public class BreweryServiceController {

    private static final Logger log = LoggerFactory.getLogger(BreweryServiceController.class);
    private BreweryService breweryService;

    public BreweryServiceController(@Autowired BreweryService breweryService){
        this.breweryService = breweryService;
    }

    @RequestMapping(value ="/brewery", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Brewery[]> getdata() {
        ResponseEntity responseEntity;
        CompletableFuture<ResponseEntity> breweriesFuture = breweryService.getBreweries();

        try {
            responseEntity = breweriesFuture.get(10, TimeUnit.SECONDS);
        } catch (Exception e) {
            log.error(e.toString());
            responseEntity = new ResponseEntity(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }
}
