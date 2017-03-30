package com.adserver.controllers;

import com.adserver.domain.AdRecord;
import com.adserver.domain.AdRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.time.LocalDate;

/**
 * Created by gschuell on 3/29/17.
 */
@RestController
public class AdController {

    private AdRepository adStore;

    @Autowired
    public AdController(AdRepository adStore) {
        this.adStore = adStore;
    }



    @RequestMapping(value = "/ad", method = RequestMethod.POST, produces = "application/json")
    public String createAdInstance(@RequestBody String adData) {

        String returnValue = null;
        // Convert incoming JSON string to AdData object
        final GsonBuilder builder = new GsonBuilder();
        builder.excludeFieldsWithoutExposeAnnotation();
        final Gson gson = builder.create();

        AdRecord ar = new AdRecord();
        ar = gson.fromJson(adData, AdRecord.class);
        AdRecord tmp = adStore.getAd(ar.getPartnerId());
        if (tmp == null) { //No ad for this partner
            adStore.addAd(ar);
            returnValue = "Ad added for partner " + ar.getPartnerId();
        } else { // ad already exists for this partner
            if (!checkDuration(tmp)) { // Ad expired, remove old one and replace with new one.
                adStore.removeAd(tmp.getPartnerId());
                adStore.addAd(ar);
                returnValue = "Ad added for partner " + ar.getPartnerId();
            }
            else {
                returnValue = "Ad for partner " + ar.getPartnerId() + " already exists.";
            }
        }


        return returnValue;
    }

    @RequestMapping(value = "/ad/{id}", method = RequestMethod.GET, produces = "application/json")
    public String getPartnerAd(@PathVariable String id) {

        String returnValue = null;

        final GsonBuilder builder = new GsonBuilder();
        builder.excludeFieldsWithoutExposeAnnotation();
        final Gson gson = builder.create();
        AdRecord ad = adStore.getAd(id);
        if (ad != null) {
            if (checkDuration(ad)) {
                returnValue = gson.toJson(ad);
            } else {
                returnValue = "No active ad campaign found for partner id " + id;
            }


        }
        return returnValue;
    }

    /**
     * If the date in milliseconds the ad was first entered plus the duration is less than
     * the current time in milliseconds, then true is returned. Otherwise false is returned.
     */
    public boolean checkDuration(AdRecord existingAd) {

        long currentMillis = System.currentTimeMillis();
        if ((existingAd.getMillisAdded() + existingAd.getAdDuration() * 1000) > currentMillis) {
            return true;
        }
        return false;
    }
}
