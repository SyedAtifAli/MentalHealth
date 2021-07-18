package com.example.mentalhealth.well_bieng_guide.start;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mentalhealth.R;
import com.example.mentalhealth.well_bieng_guide.Model.bulletsModel;

import java.util.List;

public class BulletAdapter extends RecyclerView.Adapter<BulletAdapter.myViewHolder> {

    List<bulletsModel> list;
    Context context;

    BulletAdapter(List<bulletsModel> list, Context context){
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bullet_li,null);
        BulletAdapter.myViewHolder holder = new BulletAdapter.myViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull BulletAdapter.myViewHolder holder, int position) {

        holder.point.setText(list.get(position).getPoint());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        TextView point;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
        point = itemView.findViewById(R.id.bullet_li_point);
        }
    }
}
