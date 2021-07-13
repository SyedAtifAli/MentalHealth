package com.example.mentalhealth.well_bieng_guide.Resilience.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mentalhealth.R;
import com.example.mentalhealth.well_bieng_guide.Model.DAYS;
import com.example.mentalhealth.well_bieng_guide.Resilience.SQLite.Resilience_DBHelper;

import java.util.List;

public class RES_daysAdapter extends RecyclerView.Adapter<RES_daysAdapter.myViewHolder> {

    Context context;
    List<DAYS> list ;

    public RES_daysAdapter(Context context , List<DAYS> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull

    @Override
    public RES_daysAdapter.myViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.res_days_listitem, null);
        myViewHolder holder = new myViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull  myViewHolder holder, int position) {

        Resilience_DBHelper helper = new Resilience_DBHelper(context);
        int day = helper.getDay();


        if(position < day){
            holder.check2.setVisibility(View.VISIBLE);
            holder.dayCount.setText(list.get(position).getDay());
            holder.dayTitle.setText(list.get(position).getTitle());
            holder.startDay.setVisibility(View.VISIBLE);

        }

        else if(position == day) {
            holder.dayCount.setText(list.get(position).getDay());
            holder.dayTitle.setText(list.get(position).getTitle());
            holder.startDay.setVisibility(View.VISIBLE);
            holder.startDay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    helper.saveDay(position+1);

                }
            });
        }
        else
        {
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

        ImageView check , check2;  //check2 is "#9cd1b3" this color bg , setting its visibility as visible will show the tick mark
        TextView dayCount, dayTitle;
        RelativeLayout startDay;

        public myViewHolder(@NonNull  View itemView) {
            super(itemView);

            check = itemView.findViewById(R.id.res_LI_check);
            check2 = itemView.findViewById(R.id.res_LI_check2);
            dayCount = itemView.findViewById(R.id.days_LI_daysNum);
            dayTitle = itemView.findViewById(R.id.days_LI_title);
            startDay = itemView.findViewById(R.id.res_LI_startDay);
        }
    }
}
