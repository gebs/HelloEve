package com.mobpro.hslu.itengebs.helloeve;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mobpro.hslu.itengebs.helloeve.api.DatabaseManager;
import com.mobpro.hslu.itengebs.helloeve.model.Message;
import com.mobpro.hslu.itengebs.helloeve.viewadapter.HistoryViewAdapter;
import com.orm.Database;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

@EActivity(R.layout.history_list)
public class HistoryActivity extends AppCompatActivity {

    @ViewById(R.id.rcmessages)
    RecyclerView mRecyclerView;

    @Bean
    DatabaseManager dbmanager;

    private HistoryViewAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    List<Message> src = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        src = dbmanager.getMessages();
    }

    @AfterViews
    void setReciclerView(){
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new HistoryViewAdapter(src, new HistoryViewAdapter.HistoryAdapterClickListener() {
            @Override
            public void recyclerViewClick(long noteID) {
                //Do Something
            }
        });

        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void onResume(){
        super.onResume();

        src = dbmanager.getMessages();
        mAdapter.messages = src;
        mAdapter.notifyDataSetChanged();

    }
    @Override
    protected void onPause(){
        super.onPause();

    }
}
