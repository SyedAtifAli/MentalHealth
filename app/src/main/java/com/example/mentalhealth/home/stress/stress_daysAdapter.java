package com.example.mentalhealth.home.stress;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
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
import com.example.mentalhealth.well_bieng_guide.start.Start;

import org.jetbrains.annotations.NotNull;
import org.joda.time.DateTime;

import java.util.List;

public class stress_daysAdapter  extends RecyclerView.Adapter<stress_daysAdapter.myViewHolder> {


    Context context;
    List<DAYS> list;

    public stress_daysAdapter(Context context, List<DAYS> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @NotNull
    @Override
    public stress_daysAdapter.myViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.res_days_listitem, null);
        stress_daysAdapter.myViewHolder holder = new stress_daysAdapter.myViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull stress_daysAdapter.myViewHolder holder, int position) {

        Stress_DBHelper helper = new Stress_DBHelper(context);
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
                    intent.putExtra("course", "stress");
                    intent.putExtra("day", list.get(position).getDay());
                    intent.putExtra("title", list.get(position).getTitle());
                    context.startActivity(intent);

                }
            });

        } else if (position == day && DateTime.now().getDayOfYear() > helper.getDate()) {
            holder.dayCount.setText(list.get(position).getDay());
            holder.dayTitle.setText(list.get(position).getTitle());
            holder.startDay.setVisibility(View.VISIBLE);
            holder.startDay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, Start.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("course", "stress");
                    intent.putExtra("day", list.get(position).getDay());
                    intent.putExtra("title", list.get(position).getTitle());
                    Log.d("abcde", "res" + " " + list.get(position).getDay() + " " + list.get(position).getTitle());
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
        return list.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        ImageView check, check2;  //check2 is "#9cd1b3" this color bg , setting its visibility as visible will show the tick mark
        TextView dayCount, dayTitle;
        RelativeLayout startDay;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            check = itemView.findViewById(R.id.res_LI_check);
            check2 = itemView.findViewById(R.id.res_LI_check2);
            dayCount = itemView.findViewById(R.id.days_LI_daysNum);
            dayTitle = itemView.findViewById(R.id.days_LI_title);
            startDay = itemView.findViewById(R.id.res_LI_startDay);
        }
    }
}
