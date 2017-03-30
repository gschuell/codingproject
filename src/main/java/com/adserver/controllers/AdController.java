package com.adserver.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by gschuell on 3/29/17.
 */
public class AdController {

    @RequestMapping(value = "/ad", method = RequestMethod.POST, produces = "application/json")
    public String createAdInstance(@RequestBody String adData) {



        return "Passed in " + adData;
    }
}
