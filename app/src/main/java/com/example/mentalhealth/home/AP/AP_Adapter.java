package com.example.mentalhealth.home.AP;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mentalhealth.R;
import com.example.mentalhealth.diary.Adapter.BaseAdapter;

import java.util.List;

public class AP_Adapter extends RecyclerView.Adapter<AP_Holder>{

    Context context;
    List<AP_Objects> object_list;
    BaseAdapter.BaseAdapterClickListener clickListener;

    public AP_Adapter(Context context, List<AP_Objects> object_list) {
        this.context = context;
        this.object_list = object_list;
    }

    @NonNull

    @Override
    public AP_Holder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.additional_plan_listitem, null);
        AP_Holder holder = new AP_Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull  AP_Holder holder, int position) {
        holder.title.setText(object_list.get(position).title);
        holder.duration.setText(object_list.get(position).duration);
//        holder.AP_wv.loadUrl("file:///android_asset/html_css/AP.html");
    }

    @Override
    public int getItemCount() {
        return object_list.size();
    }
}
