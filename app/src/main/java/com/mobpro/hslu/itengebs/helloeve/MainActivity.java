package com.mobpro.hslu.itengebs.helloeve;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    public void onClickMeClick(View view){
        Toast.makeText(MainActivity.this, "hoiiii", Toast.LENGTH_LONG).show();
    }

    public void onHistoryFabClick(View view) {
        Toast.makeText(MainActivity.this, "history", Toast.LENGTH_SHORT).show();
    }
}
