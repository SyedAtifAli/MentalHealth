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
import com.example.mentalhealth.Recommended_Activities.play_activity;
import com.example.mentalhealth.home.Activities.RA_Objects;

import java.util.List;

public class relax_adapter extends RecyclerView.Adapter<relax_adapter.myViewHolder> {

    Context context;
    List<RA_Objects> list1;

    public relax_adapter(Context context, List<RA_Objects> list1) {
        this.context = context;
        this.list1 = list1;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recommended_act_listitem2, null);
        myViewHolder holder = new myViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull relax_adapter.myViewHolder holder, int position) {
        holder.title.setText(list1.get(position).title);

        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == 0) {
                    Intent intent = new Intent(context, play_activity.class);
                    intent.putExtra("title", list1.get(position).title);
                    intent.putExtra("details", list1.get(position).title);
                    intent.putExtra("sound", R.raw.deep);
                    context.startActivity(intent);
                }
                if (position == 1) {
                    Intent intent = new Intent(context, play_activity.class);
                    intent.putExtra("title", list1.get(position).title);
                    intent.putExtra("details", list1.get(position).title);
                    intent.putExtra("sound", R.raw.deep);
                    context.startActivity(intent);
                }
                if (position == 2) {
                    Intent intent = new Intent(context, play_activity.class);
                    intent.putExtra("title", list1.get(position).title);
                    intent.putExtra("details", list1.get(position).title);
                    intent.putExtra("sound", R.raw.deep);
                    context.startActivity(intent);
                }
                if (position == 3) {
                    Intent intent = new Intent(context, play_activity.class);
                    intent.putExtra("title", list1.get(position).title);
                    intent.putExtra("details", list1.get(position).title);
                    intent.putExtra("sound", R.raw.deep);
                    context.startActivity(intent);
                }
                if (position == 4) {
                    Intent intent = new Intent(context, play_activity.class);
                    intent.putExtra("title", list1.get(position).title);
                    intent.putExtra("details", list1.get(position).title);
                    intent.putExtra("sound", R.raw.deep);
                    context.startActivity(intent);
                }
                if (position == 5) {
                    Intent intent = new Intent(context, play_activity.class);
                    intent.putExtra("title", list1.get(position).title);
                    intent.putExtra("details", list1.get(position).title);
                    intent.putExtra("sound", R.raw.deep);
                    context.startActivity(intent);
                }
                if (position == 6) {
                    Intent intent = new Intent(context, play_activity.class);
                    intent.putExtra("title", list1.get(position).title);
                    intent.putExtra("details", list1.get(position).title);
                    intent.putExtra("sound", R.raw.deep);
                    context.startActivity(intent);
                }
                if (position == 7) {
                    Intent intent = new Intent(context, play_activity.class);
                    intent.putExtra("title", list1.get(position).title);
                    intent.putExtra("details", list1.get(position).title);
                    intent.putExtra("sound", R.raw.deep);
                    context.startActivity(intent);
                }
                }});


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
