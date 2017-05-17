package com.mobpro.hslu.itengebs.helloeve;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.mobpro.hslu.itengebs.helloeve.api.DatabaseManager;
import com.mobpro.hslu.itengebs.helloeve.api.WebAPICallback;
import com.mobpro.hslu.itengebs.helloeve.api.WebAPIManager;
import com.mobpro.hslu.itengebs.helloeve.model.HelloEveUser;
import com.mobpro.hslu.itengebs.helloeve.model.SendMessage_Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    public void onClickMeClick(View view){
        HelloEveUser user = DatabaseManager.getInstance().getUserInfo();
        final String receiverNumber = "0041795313129";
        final String messageText ="Test Message Code";

        WebAPIManager.getInstance().sendMessage(getApplicationContext(), user.getToken(), receiverNumber, messageText, null, new WebAPICallback<SendMessage_Response>() {
            @Override
            public void onCompleted(Exception e, SendMessage_Response response) {
                if (response.Successfull){
                    DatabaseManager.getInstance().saveMessage(messageText,receiverNumber);
                    Toast.makeText(MainActivity.this, "Message sent", Toast.LENGTH_LONG).show();
                }
            }
        });


    }

    public void onHistoryFabClick(View view) {
        Intent intent = new Intent(this,HistoryActivity.class);
        startActivity(intent);
    }
}
