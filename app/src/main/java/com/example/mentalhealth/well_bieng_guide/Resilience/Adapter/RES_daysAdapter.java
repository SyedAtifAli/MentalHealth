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
import com.example.mentalhealth.well_bieng_guide.Resilience.Model.DAYS;
import com.example.mentalhealth.well_bieng_guide.Resilience.SQLite.Resilience_DBHelper;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RES_daysAdapter extends RecyclerView.Adapter<RES_daysAdapter.myViewHolder> {

    Context context;
    List<DAYS> list ;

    public RES_daysAdapter(Context context , List<DAYS> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @NotNull
    @Override
    public RES_daysAdapter.myViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.res_days_listitem, null);
        myViewHolder holder = new myViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull myViewHolder holder, int position) {

        Resilience_DBHelper helper = new Resilience_DBHelper(context);
        int day = helper.getDay();

            holder.dayCount.setText(list.get(position).getDay());
            holder.dayTitle.setText(list.get(position).getTitle());
            holder.startDay.setVisibility(View.VISIBLE);
            holder.startDay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    helper.saveDay(1);

                }
            });


        helper.close();
    }


    @Override
    public int getItemCount() {
        return 8;
    }

    class myViewHolder extends RecyclerView.ViewHolder {

        ImageView check;
        TextView dayCount, dayTitle;
        RelativeLayout startDay;

        public myViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            check = itemView.findViewById(R.id.res_LI_check);
            dayCount = itemView.findViewById(R.id.days_LI_daysNum);
            dayTitle = itemView.findViewById(R.id.days_LI_title);
            startDay = itemView.findViewById(R.id.res_LI_startDay);
        }
    }
}
