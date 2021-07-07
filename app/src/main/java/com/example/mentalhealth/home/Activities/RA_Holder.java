package com.example.mentalhealth.home.Activities;

import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mentalhealth.R;

import org.jetbrains.annotations.NotNull;

public class RA_Holder extends RecyclerView.ViewHolder{

    TextView title;
    WebView RA_wv;
    FrameLayout frame;
    CardView cardView;

    public RA_Holder(@NonNull @NotNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.RA_item_title);
        RA_wv = itemView.findViewById(R.id.RA_wv);
        cardView = itemView.findViewById(R.id.ra_card);
        frame = itemView.findViewById(R.id.frame);
    }
}
