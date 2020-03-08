package com.vijaysidhu.springmvc;

import com.vijaysidhu.springmvc.model.Brewery;
import com.vijaysidhu.springmvc.service.BreweryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class BreweryServiceControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private BreweryService breweryService;

    @Test
    void getAllBreweries() throws Exception {

        Brewery brewery1 = new Brewery(1,"Avondale Brewing Co","micro","201 41st St S","Birmingham","Alabama","35222-1932","United States","-86.774322","33.524521","2057775456","http://www.avondalebrewing.com","2018-08-23T23:19:57.825Z");
        Brewery brewery2 = new Brewery(2,"Avondale Brewing Co 2","micro","201 41st St S","Birmingham","Alabama","35222-1932","United States","-86.774322","33.524521","2057775456","http://www.avondalebrewing.com","2018-08-23T23:19:57.825Z");
        Brewery[] breweryArr = {brewery1, brewery2};
        ResponseEntity<Brewery[]> responseEntity = new ResponseEntity(breweryArr,HttpStatus.OK);
        when(breweryService.getBreweries()).thenReturn(CompletableFuture.completedFuture(responseEntity));
        mockMvc.perform(MockMvcRequestBuilders.get("/brewery")
        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(jsonPath("$", hasSize((2)))).andDo(print());

    }
}
