package com.mobpro.hslu.itengebs.helloeve;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.PreferenceScreen;

/**
 * Created by carla on 18.05.2017.
 */


public class MessagePrefActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getFragmentManager().findFragmentById(android.R.id.content) == null){
            getFragmentManager()
                    .beginTransaction()
                    .replace(android.R.id.content, new MessagePreferences())
                    .commit();
        }
    }

    public static final class MessagePreferences extends PreferenceFragment{
        public static String PREF_NAME = "HelloEvePrefs";
        public MessagePreferences(){

        }

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            // Using your MyPrefs values
            this.getPreferenceManager().setSharedPreferencesName(PREF_NAME);

            addPreferencesFromResource(R.xml.preferences);
        }
    }
}
