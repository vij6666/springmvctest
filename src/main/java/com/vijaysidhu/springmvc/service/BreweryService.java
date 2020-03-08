package com.vijaysidhu.springmvc.service;

import com.vijaysidhu.springmvc.model.Brewery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class BreweryService {

    private final static Logger log = LoggerFactory.getLogger(BreweryService.class);
    private final static String brewerySvcURL = "https://api.openbrewerydb.org/breweries";

    @Async
    public CompletableFuture<ResponseEntity> getBreweries(){
        HttpHeaders headers = new HttpHeaders();
        headers.set("User-agent", "SomeUserAgent");
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Brewery[]> response = restTemplate.exchange(brewerySvcURL, HttpMethod.GET, entity, Brewery[].class);


        return CompletableFuture.completedFuture(response);
    }
}
