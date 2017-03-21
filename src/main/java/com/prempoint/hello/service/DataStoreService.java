package com.prempoint.hello.service;

import com.google.cloud.datastore.*;
import com.prempoint.hello.dto.uservisit.UserVisit;

/**
 * Created by rajjasti on 3/21/17.
 */
public class DataStoreService {

    public void storeUserVisit(UserVisit userVisit){
        Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
        KeyFactory keyFactory = datastore.newKeyFactory().setKind("uservisit");
        IncompleteKey key = keyFactory.setKind("uservisit").newKey();

        FullEntity<IncompleteKey> visit = FullEntity.newBuilder(key)
                .set("name", userVisit.getName()).set("ipAddress", userVisit.getIpAddress()).build();
        datastore.add(visit);
    }
}
