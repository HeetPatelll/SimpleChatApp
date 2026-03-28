package com.example.simplechatapp;

import android.content.Context;
import android.view.*;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MessageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    ArrayList<MessageModel> list;

    int SEND = 1;
    int RECEIVE = 2;

    public MessageAdapter(Context context, ArrayList<MessageModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).isSender() ? SEND : RECEIVE;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if(viewType == SEND){
            View view = LayoutInflater.from(context).inflate(R.layout.item_send, parent, false);
            return new SendHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.item_receive, parent, false);
            return new ReceiveHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        MessageModel msg = list.get(position);

        if(holder instanceof SendHolder){
            ((SendHolder) holder).txt.setText(msg.getMessage());
        } else {
            ((ReceiveHolder) holder).txt.setText(msg.getMessage());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class SendHolder extends RecyclerView.ViewHolder{
        TextView txt;
        public SendHolder(View v){
            super(v);
            txt = v.findViewById(R.id.messageText);
        }
    }

    class ReceiveHolder extends RecyclerView.ViewHolder{
        TextView txt;
        public ReceiveHolder(View v){
            super(v);
            txt = v.findViewById(R.id.messageText);
        }
    }
}
