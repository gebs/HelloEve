package com.mobpro.hslu.itengebs.helloeve.api;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import com.mobpro.hslu.itengebs.helloeve.model.SendCode_Response;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by gebs on 5/15/17.
 */
public class WebAPIManagerTest {
    @Test
    public void sendCode() throws Exception {
        Context appContext = InstrumentationRegistry.getTargetContext();
        WebAPIManager.getInstance().sendCode(appContext, "0041795313129", new WebAPICallback<SendCode_Response>() {
            @Override
            public void onCompleted(Exception e, SendCode_Response response) {
                System.out.println(response);
            }
        });
    }

    @Test
    public void signIn() throws Exception {

    }

    @Test
    public void sendMessage() throws Exception {

    }

}