package com.mobpro.hslu.itengebs.helloeve;

import android.content.Context;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
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

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.mipmap.ic_menu);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        final DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        NavigationView view = (NavigationView) findViewById(R.id.navigation_view);
        /*
        view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override public boolean onNavigationItemSelected(MenuItem menuItem) {
                //Snackbar.make(content, menuItem.getTitle() + " pressed", Snackbar.LENGTH_LONG).show();
                //menuItem.setChecked(true);
                //drawerLayout.closeDrawers();
                return true;
            }
        });
        */

        /*

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.mipmap.ic_menu);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        final DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        NavigationView view = (NavigationView) findViewById(R.id.navigation_view);
        view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override public boolean onNavigationItemSelected(MenuItem menuItem) {
                //Snackbar.make(content, menuItem.getTitle() + " pressed", Snackbar.LENGTH_LONG).show();
                menuItem.setChecked(true);
                drawerLayout.closeDrawers();
                return true;
            }
        });
*/

        setContentView(R.layout.activity_main);
    }

    public void onClickMeClick(View view){

        HelloEveUser user = DatabaseManager.getInstance().getUserInfo();

        WebAPIManager.getInstance().sendMessage(getApplicationContext(), user.getToken(), "0041795313129", "Test Message", null, new WebAPICallback<SendMessage_Response>() {
            @Override
            public void onCompleted(Exception e, SendMessage_Response response) {
                if (response.Successfull) {
                    Toast.makeText(MainActivity.this, "Message sent", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
