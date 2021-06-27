package com.example.mentalhealth.home.Activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mentalhealth.R;
import com.example.mentalhealth.diary.Adapter.BaseAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RA_Adapter extends RecyclerView.Adapter<RA_Holder>{

    Context context;
    List<RA_Objects> object_list;
    BaseAdapter.BaseAdapterClickListener clickListener;

    public RA_Adapter(Context context, List<RA_Objects> object_list) {
        this.context = context;
        this.object_list = object_list;
    }

    @NonNull
    @NotNull
    @Override
    public RA_Holder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recommended_act_listitem, null);
        RA_Holder holder = new RA_Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RA_Holder holder, int position) {
        holder.title.setText(object_list.get(position).title);
        holder.RA_wv.loadUrl("file:///android_asset/html_css/RA.html");
    }


    @Override
    public int getItemCount() {
        return object_list.size();
    }
}
