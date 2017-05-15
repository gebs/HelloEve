package com.mobpro.hslu.itengebs.helloeve.model;

import com.orm.SugarRecord;

/**
 * Created by gebs on 5/15/17.
 */

public class HelloEveUser extends SugarRecord<HelloEveUser> {
    String phoneNumber;



    String phoneHash;
    String token;

    public HelloEveUser() {
    }

    public HelloEveUser(String phoneNumber, String token,String phoneHash) {
        this.phoneNumber = phoneNumber;
        this.token = token;
        this.phoneHash = phoneHash;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getToken() {
        return token;
    }
    public String getPhoneHash() {
        return phoneHash;
    }
}
