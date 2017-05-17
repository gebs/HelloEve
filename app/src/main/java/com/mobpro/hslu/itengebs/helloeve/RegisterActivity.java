package com.mobpro.hslu.itengebs.helloeve;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

public class RegisterActivity extends AppCompatActivity {

    private FrameLayout fragmentContainer;
    private int currentFrag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        fragmentContainer = (FrameLayout)findViewById(R.id.fragment_container);

        RegisterPhoneNumberFragement rpf = new RegisterPhoneNumberFragement();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,rpf).commit();
    }
    public void goToNextScreen(String nextFrag){
        if (nextFrag.equals("Code")){
            RegisterCodeFragement rcf = new RegisterCodeFragement();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, rcf);
            transaction.addToBackStack(null);
            transaction.commit();
        }else{
            Intent intent = new Intent(this,MainActivity.class);
            intent.setFlags(intent.getFlags() | Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(intent);
        }
    }
}
