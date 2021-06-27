package com.example.mentalhealth.home.Activities;

import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mentalhealth.R;

import org.jetbrains.annotations.NotNull;

public class RA_Holder extends RecyclerView.ViewHolder{

    TextView title;
    WebView RA_wv;

    public RA_Holder(@NonNull @NotNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.RA_item_title);
        RA_wv = itemView.findViewById(R.id.RA_wv);
    }
}
