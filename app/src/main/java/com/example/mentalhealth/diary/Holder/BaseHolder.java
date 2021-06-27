package com.example.mentalhealth.diary.Holder;

import android.view.View;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mentalhealth.R;


public class BaseHolder extends RecyclerView.ViewHolder {

    public TextView txt_waktu;
    public TextView txt_judul;
    public CardView card_item_note;

    public BaseHolder(View itemView) {
        super(itemView);
        txt_waktu = (TextView) itemView.findViewById(R.id.txt_waktu);
        txt_judul = (TextView) itemView.findViewById(R.id.txt_judul);
        card_item_note = (CardView) itemView.findViewById(R.id.card_item_note);
    }

}
