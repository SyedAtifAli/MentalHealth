package com.example.mentalhealth.home.AP;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mentalhealth.R;

public class AP_Holder extends RecyclerView.ViewHolder{

    TextView title;
    TextView duration;
    LinearLayout Ap_container;
//    WebView AP_wv;

    public AP_Holder(@NonNull  View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.AP_item_title);
        duration = itemView.findViewById(R.id.AP_item_duration);
        Ap_container = itemView.findViewById(R.id.Ap_container);
//        AP_wv = itemView.findViewById(R.id.AP_wv);
    }
}
