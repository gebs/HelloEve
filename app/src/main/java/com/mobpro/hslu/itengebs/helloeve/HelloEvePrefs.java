package com.mobpro.hslu.itengebs.helloeve;

import org.androidannotations.annotations.sharedpreferences.DefaultString;
import org.androidannotations.annotations.sharedpreferences.SharedPref;

/**
 * Created by gebs on 5/19/17.
 */
@SharedPref(SharedPref.Scope.UNIQUE)
public interface HelloEvePrefs {
    @DefaultString("0041796139817")
    String phoneNumber();

    @DefaultString("HelloEve")
    String message();
}
