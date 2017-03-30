package com.adserver.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by gschuell on 3/29/17.
 */
public class AdRecord {

    @SerializedName("partner_id")
    @Expose
    private String partnerId;
    @SerializedName("duration")
    @Expose
    private long adDuration;
    @SerializedName("ad_content")
    @Expose
    private String adContent;
    transient long millisAdded;

    public AdRecord() {

    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public long getAdDuration() {
        return adDuration;
    }

    public void setAdDuration(long adDuration) {
        this.adDuration = adDuration;
    }

    public void setMillisAdded(long millis) { this.millisAdded = millis;}

    public long getMillisAdded() { return millisAdded;}

    public String getAdContent() {
        return adContent;
    }

    public void setAdContent(String adContent) {
        this.adContent = adContent;
    }
}
