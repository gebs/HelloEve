package com.mobpro.hslu.itengebs.helloeve;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.mobpro.hslu.itengebs.helloeve.api.DatabaseManager;
import com.mobpro.hslu.itengebs.helloeve.api.WebAPICallback;
import com.mobpro.hslu.itengebs.helloeve.api.WebAPIManager;
import com.mobpro.hslu.itengebs.helloeve.model.HelloEveUser;
import com.mobpro.hslu.itengebs.helloeve.model.SendMessage_Response;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private String phoneNumber;
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.checkPreferences();

        setContentView(R.layout.activity_main);
    }

    public void onClickMeClick(View view){

        this.checkPreferences();


        HelloEveUser user = DatabaseManager.getInstance().getUserInfo();

        /*
        final String receiverNumber = "0041796139817";
        final String messageText ="Hello Eve";
        */

        final String receiverNumber = this.phoneNumber;
        final String messageText = this.message;

        WebAPIManager.getInstance().sendMessage(getApplicationContext(), user.getToken(), receiverNumber, messageText, new WebAPICallback<SendMessage_Response>() {
            @Override
            public void onCompleted(Exception e, SendMessage_Response response) {
                if (response.Successfull){
                    DatabaseManager.getInstance().saveMessage(messageText,receiverNumber);
                    Toast.makeText(MainActivity.this, "Message sent", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void checkPreferences(){

        final SharedPreferences messagePref = PreferenceManager.getDefaultSharedPreferences(this);
        this.phoneNumber = messagePref.getString("phonePref","1");
        this.message = messagePref.getString("messagePref","Hello Eve");

        if((phoneNumber == null || phoneNumber.isEmpty())||(message == null || message.isEmpty())){
            this.phoneNumber = "0041796139817";
            this.message = "HelloEve";
        }

    }

    public void onHistoryFabClick(View view) {
        Intent intent = new Intent(this,HistoryActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        if(item.getItemId() != R.id.action_settings){
            return false;
        }

        Intent prefIntent = new Intent(MainActivity.this, MessagePrefActivity.class);
        startActivity(prefIntent);

        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        checkPreferences();
    }
}
