package com.mobpro.hslu.itengebs.helloeve;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mobpro.hslu.itengebs.helloeve.api.DatabaseManager;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (DatabaseManager.getInstance().isUserLogedIn()){
            Intent intent = new Intent(this,MainActivity.class);
            this.startActivity(intent);
        }else{
            Intent intent = new Intent(this,MainActivity.class);
            this.startActivity(intent);
        }
    }
}
