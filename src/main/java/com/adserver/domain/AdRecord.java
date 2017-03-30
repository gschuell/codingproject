package com.adserver.domain;

/**
 * Created by gschuell on 3/29/17.
 */
public class AdRecord {

    private long partnerId;
    private long adDuration;
    private String adContent;

    public long getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(long partnerId) {
        this.partnerId = partnerId;
    }

    public long getAdDuration() {
        return adDuration;
    }

    public void setAdDuration(long adDuration) {
        this.adDuration = adDuration;
    }

    public String getAdContent() {
        return adContent;
    }

    public void setAdContent(String adContent) {
        this.adContent = adContent;
    }
}
