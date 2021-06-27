package com.example.mentalhealth.chatbot.Adapters;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mentalhealth.R;
import com.example.mentalhealth.chatbot.Contract.MessageContract;
import com.example.mentalhealth.chatbot.UtilityPackage.Constants;


public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {

    Cursor cursor;
    Context context;

    public MessageAdapter(Context context, Cursor cursor){
        this.cursor = cursor;
        this.context = context;
    }

    public class MessageViewHolder extends RecyclerView.ViewHolder{

        RelativeLayout botLayout;
        RelativeLayout userLayout;

        TextView botMessageView;
        TextView userMessageView;

        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);
            botLayout = itemView.findViewById(R.id.bot_layout);
            userLayout = itemView.findViewById(R.id.user_layout);

            botMessageView = itemView.findViewById(R.id.bot_message_view);
            userMessageView = itemView.findViewById(R.id.user_message_view);
        }
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.message_view_layout,
                viewGroup, false);
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder messageViewHolder, int i) {

        if(!cursor.moveToPosition(i)){
            return;
        }

        String sender = cursor.getString(cursor.getColumnIndex(MessageContract.MessageEntry.COLUMN_SENDER));
        String message = cursor.getString(cursor.getColumnIndex(MessageContract.MessageEntry.COLUMN_MESSAGE));
        String timestamp = cursor.getString(cursor.getColumnIndex(MessageContract.MessageEntry.COLUMN_TIMESTAMP));
        long id = cursor.getLong(cursor.getColumnIndex(MessageContract.MessageEntry._ID));

        if(Constants.BOT.equals(sender)){
            messageViewHolder.userLayout.setVisibility(View.GONE);
            messageViewHolder.botLayout.setVisibility(View.VISIBLE);
            messageViewHolder.botMessageView.setText(message);
        } else{
            messageViewHolder.botLayout.setVisibility(View.GONE);
            messageViewHolder.userLayout.setVisibility(View.VISIBLE);
            messageViewHolder.userMessageView.setText(message);
        }

        messageViewHolder.itemView.setTag(id);

    }

    @Override
    public int getItemCount() {
        return cursor.getCount();
    }

    public void swapCursor(Cursor newCursor){

        if(cursor != null){
            cursor.close();
        }

        cursor = newCursor;
        if(newCursor != null){
            notifyDataSetChanged();
        }
    }

}
