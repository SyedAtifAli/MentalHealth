package com.example.mentalhealth.home.Activities;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mentalhealth.R;
import com.example.mentalhealth.Recommended_Activities.play_activity;
import com.example.mentalhealth.Recommended_Activities.play_activity2;
import com.example.mentalhealth.diary.Adapter.BaseAdapter;


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
    @Override
    public RA_Holder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recommended_act_listitem, null);
        RA_Holder holder = new RA_Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull  RA_Holder holder, int position) {
        holder.title.setText(object_list.get(position).title);

        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position == 0){
                    Intent intent = new Intent(context, play_activity.class);
                    intent.putExtra("title",object_list.get(position).title);
                    intent.putExtra("details",object_list.get(position).title);
                    intent.putExtra("sound",R.raw.deep);
                    context.startActivity(intent);
                }if(position == 1){
                    Intent intent = new Intent(context, play_activity.class);
                    intent.putExtra("title",object_list.get(position).title);
                    intent.putExtra("details",object_list.get(position).title);
                    intent.putExtra("sound",R.raw.deep);
                    context.startActivity(intent);
                }if(position == 2){
                    Intent intent = new Intent(context, play_activity.class);
                    intent.putExtra("title",object_list.get(position).title);
                    intent.putExtra("details",object_list.get(position).title);
                    intent.putExtra("sound",R.raw.deep);
                    context.startActivity(intent);
                }if(position == 3){
                    Intent intent = new Intent(context, play_activity.class);
                    intent.putExtra("title",object_list.get(position).title);
                    intent.putExtra("details",object_list.get(position).title);
                    intent.putExtra("sound",R.raw.deep);
                    context.startActivity(intent);
                }if(position == 4){
                    Intent intent = new Intent(context, play_activity.class);
                    intent.putExtra("title",object_list.get(position).title);
                    intent.putExtra("details",object_list.get(position).title);
                    intent.putExtra("sound",R.raw.deep);
                    context.startActivity(intent);
                }if(position == 5){
                    Intent intent = new Intent(context, play_activity.class);
                    intent.putExtra("title",object_list.get(position).title);
                    intent.putExtra("details",object_list.get(position).title);
                    intent.putExtra("sound",R.raw.deep);
                    context.startActivity(intent);
                }if(position == 6){
                    Intent intent = new Intent(context, play_activity.class);
                    intent.putExtra("title",object_list.get(position).title);
                    intent.putExtra("details",object_list.get(position).title);
                    intent.putExtra("sound",R.raw.deep);
                    context.startActivity(intent);
                }if(position == 7){
                    Intent intent = new Intent(context, play_activity.class);
                    intent.putExtra("title",object_list.get(position).title);
                    intent.putExtra("details",object_list.get(position).title);
                    intent.putExtra("sound",R.raw.deep);
                    context.startActivity(intent);
                }if(position == 8){ //walking
                    Intent intent = new Intent(context, play_activity2.class);
                    intent.putExtra("title",object_list.get(position).title);
                    intent.putExtra("details",object_list.get(position).title);
                    intent.putExtra("img",R.drawable.walking);
                    context.startActivity(intent);
                }if(position == 9){ //climbing stairs
                    Intent intent = new Intent(context, play_activity2.class);
                    intent.putExtra("title",object_list.get(position).title);
                    intent.putExtra("details",object_list.get(position).title);
                    intent.putExtra("img",R.drawable.climbing);
                    context.startActivity(intent);
                }if(position == 10){ // Running
                    Intent intent = new Intent(context, play_activity2.class);
                    intent.putExtra("title",object_list.get(position).title);
                    intent.putExtra("details",object_list.get(position).title);
                    intent.putExtra("img",R.drawable.shoe_img);
                    context.startActivity(intent);
                }if(position == 11){ //cycling
                    Intent intent = new Intent(context, play_activity2.class);
                    intent.putExtra("title",object_list.get(position).title);
                    intent.putExtra("details",object_list.get(position).title);
                    intent.putExtra("img",R.drawable.cycle);
                    context.startActivity(intent);
                }if(position == 12){ // skipping rope
                    Intent intent = new Intent(context, play_activity2.class);
                    intent.putExtra("title",object_list.get(position).title);
                    intent.putExtra("details",object_list.get(position).title);
                    intent.putExtra("img",R.drawable.skipping);
                    context.startActivity(intent);
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return object_list.size();
    }
}
