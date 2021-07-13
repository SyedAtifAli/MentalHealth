package com.example.mentalhealth.Games;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mentalhealth.R;
import com.example.mentalhealth.Recommended_Activities.play_activity2;
import com.example.mentalhealth.home.Activities.RA_Objects;

import java.util.List;

public class physical_adapter extends RecyclerView.Adapter<physical_adapter.myViewHolder> {

    Context context;
    List<RA_Objects> list1;

    public physical_adapter(Context context, List<RA_Objects> list1) {
        this.context = context;
        this.list1 = list1;
    }

    @NonNull
    @Override
    public physical_adapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recommended_act_listitem2, null);
        physical_adapter.myViewHolder holder = new physical_adapter.myViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull physical_adapter.myViewHolder holder, int position) {
        holder.title.setText(list1.get(position).title);

        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position == 0){ //walking
                    Intent intent = new Intent(context, play_activity2.class);
                    intent.putExtra("title",list1.get(position).title);
                    intent.putExtra("details",list1.get(position).title);
                    intent.putExtra("img",R.drawable.walking);
                    context.startActivity(intent);
                }if(position == 1){ //climbing stairs
                    Intent intent = new Intent(context, play_activity2.class);
                    intent.putExtra("title",list1.get(position).title);
                    intent.putExtra("details",list1.get(position).title);
                    intent.putExtra("img",R.drawable.climbing);
                    context.startActivity(intent);
                }if(position == 2){ // Running
                    Intent intent = new Intent(context, play_activity2.class);
                    intent.putExtra("title",list1.get(position).title);
                    intent.putExtra("details",list1.get(position).title);
                    intent.putExtra("img",R.drawable.shoe_img);
                    context.startActivity(intent);
                }if(position == 3){ //cycling
                    Intent intent = new Intent(context, play_activity2.class);
                    intent.putExtra("title",list1.get(position).title);
                    intent.putExtra("details",list1.get(position).title);
                    intent.putExtra("img",R.drawable.cycle);
                    context.startActivity(intent);
                }if(position == 4){ // skipping rope
                    Intent intent = new Intent(context, play_activity2.class);
                    intent.putExtra("title",list1.get(position).title);
                    intent.putExtra("details",list1.get(position).title);
                    intent.putExtra("img",R.drawable.skipping);
                    context.startActivity(intent);
                }
            }
        });


    }


    @Override
    public int getItemCount() {
        return list1.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        FrameLayout frame;
        CardView cardView;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.RA_item_title);
            cardView = itemView.findViewById(R.id.ra_card);
            frame = itemView.findViewById(R.id.frame);
        }
    }
}
