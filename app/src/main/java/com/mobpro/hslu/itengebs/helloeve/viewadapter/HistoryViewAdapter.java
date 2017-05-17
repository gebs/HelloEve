package com.mobpro.hslu.itengebs.helloeve.viewadapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mobpro.hslu.itengebs.helloeve.R;
import com.mobpro.hslu.itengebs.helloeve.model.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gebs on 5/17/17.
 */

public class HistoryViewAdapter extends RecyclerView.Adapter<HistoryViewAdapter.ViewHolder> {


    public List<Message> messages;
    public HistoryAdapterClickListener listener;

    public interface HistoryAdapterClickListener {
        void recyclerViewClick(long noteID);
    }

    public HistoryViewAdapter(List<Message> _notes,HistoryAdapterClickListener _listener) {
        this.messages = _notes;
        this.listener = _listener;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_card_view, parent, false);
        ViewHolder vh = new ViewHolder(v, new ViewHolder.MessageClickListener() {
            @Override
            public void messageOnClick(long messageId) {
                listener.recyclerViewClick(messageId);
            }
        });
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Message msg = messages.get(position);
        holder.Text.setText(msg.getMessageText());
        holder.Title.setText(msg.getReceiverPhoneNumber());
        holder.ID = msg.getId();
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView Title;
        TextView Text;
        long ID;
        public MessageClickListener listener;

        //listener passed to viewHolder
        public interface MessageClickListener {
            void messageOnClick(long messageId);
        }

        ViewHolder(View itemView,MessageClickListener listener) {
            super(itemView);
            Title = (TextView) itemView.findViewById(R.id.cvlblTitle);
            Text = (TextView) itemView.findViewById(R.id.cvlblText);
            this.listener = listener;
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v){
            listener.messageOnClick(ID);
        }


    }
}
