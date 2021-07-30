package com.example.mentalhealth.home.AP;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mentalhealth.R;
import com.example.mentalhealth.diary.Adapter.BaseAdapter;
import com.example.mentalhealth.home.anger.anger_start;
import com.example.mentalhealth.home.anxiety.Anxiety_start;
import com.example.mentalhealth.home.depression.depression_start;
import com.example.mentalhealth.home.happy.happy_start;
import com.example.mentalhealth.home.sleep.sleep_start;
import com.example.mentalhealth.home.stress.stress_start;

import java.util.List;

public class AP_Adapter extends RecyclerView.Adapter<AP_Holder> {

    Context context;
    List<AP_Objects> object_list;
    BaseAdapter.BaseAdapterClickListener clickListener;

    public AP_Adapter(Context context, List<AP_Objects> object_list) {
        this.context = context;
        this.object_list = object_list;
    }

    @NonNull

    @Override
    public AP_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.additional_plan_listitem, null);
        AP_Holder holder = new AP_Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AP_Holder holder, int position) {
        holder.title.setText(object_list.get(position).title);
        holder.duration.setText(object_list.get(position).duration);

        holder.Ap_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (object_list.get(position).title.equals("Foundation Course for Anxiety")) {
                    Intent intent = new Intent(context, Anxiety_start.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
                else if (object_list.get(position).title.equals("Stress\nManagement")) {
                    Intent intent = new Intent(context, stress_start.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
                else if (object_list.get(position).title.equals("Foundation\nof Anger\nManagement")) {
                    Intent intent = new Intent(context, anger_start.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
                else if (object_list.get(position).title.equals("Foundation course for depression")) {
                    Intent intent = new Intent(context, depression_start.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
                else if (object_list.get(position).title.equals("Have a nice Sleep")) {
                    Intent intent = new Intent(context, sleep_start.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
                else if (object_list.get(position).title.equals("Basics of\nliving Happier")) {
                    Intent intent = new Intent(context, happy_start.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
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
