package com.mobpro.hslu.itengebs.helloeve;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
        final String receiverNumber = "0041796139817";
        final String messageText ="Hello Eve";

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

        Toast.makeText(this,"Settings, yeah", Toast.LENGTH_SHORT).show();
        Intent prefIntent = new Intent(MainActivity.this, MessagePrefActivity.class);
        startActivity(prefIntent);

        return true;
    }
}
