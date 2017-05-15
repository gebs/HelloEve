package com.mobpro.hslu.itengebs.helloeve;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ImageView clickMe = (ImageView) findViewById(R.id.clickMeImage);


        setContentView(R.layout.activity_main);
    }

    public void onClickMeClick(View view){
        Toast.makeText(MainActivity.this, "hoiiii", Toast.LENGTH_LONG).show();
    }
}
