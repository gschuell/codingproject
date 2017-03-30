package com.adserver.domain;

import java.util.List;

/**
 * Created by gschuell on 3/29/17.
 */
public class AdRepository {

    private List<AdRecord> adStore;

    public AdRepository(AdRecord adRecord) {


        adStore.add(adRecord);
    }


}
