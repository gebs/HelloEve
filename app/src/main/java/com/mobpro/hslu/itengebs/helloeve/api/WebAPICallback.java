package com.mobpro.hslu.itengebs.helloeve.api;

import com.koushikdutta.ion.Response;

/**
 * Created by gebs on 5/15/17.
 */

public interface WebAPICallback<E> {
    void onCompleted(Exception e,E response);
}
