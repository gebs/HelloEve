package com.mobpro.hslu.itengebs.helloeve;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mobpro.hslu.itengebs.helloeve.api.DatabaseManager;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;

@EActivity
public class LaunchActivity extends AppCompatActivity {

    @Bean
    DatabaseManager dbmanager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (dbmanager.isUserLogedIn()) {
            MainActivity_.intent(getApplicationContext()).start();
        } else {
            RegisterActivity_.intent(getApplicationContext()).flags(Intent.FLAG_ACTIVITY_NO_HISTORY).start();
        }
    }
}
