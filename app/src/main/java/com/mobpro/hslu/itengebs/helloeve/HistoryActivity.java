package com.mobpro.hslu.itengebs.helloeve;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mobpro.hslu.itengebs.helloeve.api.DatabaseManager;
import com.mobpro.hslu.itengebs.helloeve.model.Message;
import com.mobpro.hslu.itengebs.helloeve.viewadapter.HistoryViewAdapter;
import com.orm.Database;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private HistoryViewAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    List<Message> src = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_list);

        mRecyclerView = (RecyclerView) findViewById(R.id.rcmessages);

        src = DatabaseManager.getInstance().getMessages();

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        //  mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
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

        src = DatabaseManager.getInstance().getMessages();
        mAdapter.messages = src;
        mAdapter.notifyDataSetChanged();

    }
    @Override
    protected void onPause(){
        super.onPause();

    }
}
