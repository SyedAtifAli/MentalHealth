package com.example.mentalhealth.well_bieng_guide.Loneliness.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mentalhealth.R;
import com.example.mentalhealth.well_bieng_guide.Loneliness.SQLite.loneliness_DBHelper;
import com.example.mentalhealth.well_bieng_guide.Model.DAYS;
import com.example.mentalhealth.well_bieng_guide.start.Start;

import java.util.List;

public class Lon_daysAdapter extends RecyclerView.Adapter<Lon_daysAdapter.myViewHolder> {

    Context context;
    List<DAYS> list;

    public Lon_daysAdapter(Context context, List<DAYS> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull

    @Override
    public Lon_daysAdapter.myViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lon_days_listitem, null);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  myViewHolder holder, int position) {

        loneliness_DBHelper helper = new loneliness_DBHelper(context);
        int day = helper.getDay();


        if (position < day) {
            holder.check2.setVisibility(View.VISIBLE);
            holder.dayCount.setText(list.get(position).getDay());
            holder.dayTitle.setText(list.get(position).getTitle());
            holder.startDay.setVisibility(View.VISIBLE);
            holder.startDay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, Start.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("course","lon");
                    intent.putExtra("day",list.get(position).getDay());
                    intent.putExtra("title",list.get(position).getTitle());
                    context.startActivity(intent);
                }
            });

        } else if (position == day) {
            holder.dayCount.setText(list.get(position).getDay());
            holder.dayTitle.setText(list.get(position).getTitle());
            holder.startDay.setVisibility(View.VISIBLE);
            holder.startDay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, Start.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("course","lon");
                    intent.putExtra("day",list.get(position).getDay());
                    intent.putExtra("title",list.get(position).getTitle());
                    context.startActivity(intent);

                }
            });
        } else {
            holder.dayCount.setText(list.get(position).getDay());
            holder.dayTitle.setText("Locked");
            holder.startDay.setVisibility(View.GONE);
        }

        helper.close();
    }


    @Override
    public int getItemCount() {
        return 8;
    }

    static class myViewHolder extends RecyclerView.ViewHolder {

        ImageView check, check2;  //check2 is "#9cd1b3" this color bg , setting its visibility as visible will show the tick mark
        TextView dayCount, dayTitle;
        RelativeLayout startDay;

        public myViewHolder(@NonNull  View itemView) {
            super(itemView);

            check = itemView.findViewById(R.id.lon_LI_check);
            check2 = itemView.findViewById(R.id.lon_LI_check2);
            dayCount = itemView.findViewById(R.id.days_li_daysNum);
            dayTitle = itemView.findViewById(R.id.days_LI_title);
            startDay = itemView.findViewById(R.id.lon_LI_startDay);
        }
    }
}
