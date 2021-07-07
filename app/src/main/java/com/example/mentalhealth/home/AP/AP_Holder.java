package com.example.mentalhealth.home.AP;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mentalhealth.R;

import org.jetbrains.annotations.NotNull;

public class AP_Holder extends RecyclerView.ViewHolder{

    TextView title;
    TextView duration;
//    WebView AP_wv;

    public AP_Holder(@NonNull @NotNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.AP_item_title);
        duration = itemView.findViewById(R.id.AP_item_duration);
//        AP_wv = itemView.findViewById(R.id.AP_wv);
    }
}
