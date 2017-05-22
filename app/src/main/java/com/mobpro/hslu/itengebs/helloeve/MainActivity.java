package com.mobpro.hslu.itengebs.helloeve;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.design.widget.FloatingActionButton;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Toast;

import com.mobpro.hslu.itengebs.helloeve.api.DatabaseManager;
import com.mobpro.hslu.itengebs.helloeve.api.WebAPICallback;
import com.mobpro.hslu.itengebs.helloeve.api.WebAPIManager;
import com.mobpro.hslu.itengebs.helloeve.model.HelloEveUser;
import com.mobpro.hslu.itengebs.helloeve.model.SendMessage_Response;

import org.androidannotations.annotations.sharedpreferences.Pref;
import org.w3c.dom.Text;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;


@EActivity(R.layout.activity_main)
@OptionsMenu(R.menu.settings)
public class MainActivity extends AppCompatActivity {

    @ViewById(R.id.clickMeImage)
    ImageView clickMeImage;

    @ViewById(R.id.historyFab)
    FloatingActionButton fabHistory;

    @Bean
    DatabaseManager dbManager;

    @Bean
    WebAPIManager webmanager;

    @Pref
    HelloEvePrefs_ prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Click(R.id.clickMeImage)
    public void onClickMeClick() {
        // this.checkPreferences();
        sendMessage();
    }

    @Background
    void sendMessage() {
        HelloEveUser user = dbManager.getUserInfo();


        final String receiverNumber = prefs.phoneNumber().get();  //this.phoneNumber;
        final String messageText = prefs.message().get();//this.message;

        if (receiverNumber.contains(";")) {
            String[] numbers = receiverNumber.split(";");
            for (final String number : numbers) {
                webmanager.sendMessage(this, user.getToken(), number, messageText, new WebAPICallback<SendMessage_Response>() {
                    @Override
                    public void onCompleted(Exception e, SendMessage_Response response) {
                        if (response.Successfull) {
                            dbManager.saveMessage(messageText, number);
                            Toast.makeText(MainActivity.this, "Message sent", Toast.LENGTH_LONG).show();
                        }
                    }
                });

            }

        }else {
            webmanager.sendMessage(this, user.getToken(), receiverNumber, messageText, new WebAPICallback<SendMessage_Response>() {
                @Override
                public void onCompleted(Exception e, SendMessage_Response response) {
                    if (response.Successfull) {
                        dbManager.saveMessage(messageText, receiverNumber);
                        Toast.makeText(MainActivity.this, "Message sent", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }

    }

    @Click(R.id.historyFab)
    public void onHistoryFabClick() {
        HistoryActivity_.intent(this).start();
    }


    @OptionsItem(R.id.action_settings)
    void settingsSelected(){
        Intent prefIntent = new Intent(MainActivity.this, MessagePrefActivity.class);
        startActivity(prefIntent);
    }


    @Override
    protected void onResume() {
        super.onResume();
        //checkPreferences();
    }
}
