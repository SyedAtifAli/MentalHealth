package com.example.mentalhealth.home.Activities;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mentalhealth.R;


public class RA_Holder extends RecyclerView.ViewHolder{

    TextView title;
    FrameLayout frame;
    CardView cardView;

    public RA_Holder(@NonNull  View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.RA_item_title);
        cardView = itemView.findViewById(R.id.ra_card);
        frame = itemView.findViewById(R.id.frame);
    }
}
