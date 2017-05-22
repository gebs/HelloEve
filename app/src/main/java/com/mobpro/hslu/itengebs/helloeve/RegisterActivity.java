package com.mobpro.hslu.itengebs.helloeve;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.register)
public class RegisterActivity extends AppCompatActivity {

    @ViewById(R.id.fragment_container)
    FrameLayout fragmentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RegisterPhoneNumberFragement rpf = new RegisterPhoneNumberFragement_();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,rpf).commit();
    }
    public void goToNextScreen(String nextFrag){
        if (nextFrag.equals("Code")){
            RegisterCodeFragement rcf = new RegisterCodeFragement_();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, rcf);
            transaction.addToBackStack(null);
            transaction.commit();
        }else{
            //MainActivity_.intent(getApplicationContext()).flags(Intent.FLAG_ACTIVITY_NO_HISTORY).start();
            MainActivity_.intent(this).start();
        }
    }
}
