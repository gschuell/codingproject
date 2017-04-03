package com.adserver.domain;

import org.springframework.stereotype.Component;
import java.util.Collections;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by gschuell on 3/29/17.
 */
@Component
public class AdRepository {

    private Map lhm = Collections.synchronizedMap(new LinkedHashMap());


    public AdRepository() {

    }

    public void addAd(AdRecord adEdit) {

        adEdit.setMillisAdded(System.currentTimeMillis());
        lhm.put(adEdit.getPartnerId(), adEdit);

    }

    public AdRecord getAd(String partnerId) {
        if (lhm.containsKey(partnerId)) {
            AdRecord ar = (AdRecord) lhm.get(partnerId);
            return ar;
        }
        return null;

    }

    public void removeAd(String partnerId) {
        lhm.remove(partnerId);
    }

    public Set<AdRecord> listAds() {
        return lhm.entrySet();
    }



}
