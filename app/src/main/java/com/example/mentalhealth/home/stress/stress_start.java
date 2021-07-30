package com.example.mentalhealth.home.stress;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mentalhealth.R;
import com.example.mentalhealth.well_bieng_guide.Model.DAYS;

import java.util.ArrayList;

public class stress_start extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stress_start);

        RecyclerView days = findViewById(R.id.stress_days_rv);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        days.setLayoutManager(linearLayoutManager);

        ArrayList<DAYS> list = new ArrayList<>();
        list.add(new DAYS("Day 1","Belly Breathing","stress"));
        list.add(new DAYS("Day 2","The problem framework","stress"));
        list.add(new DAYS("Day 3","The Exercise Effect","stress"));
        list.add(new DAYS("Day 4","Distraction Diary","stress"));
        list.add(new DAYS("Day 5","day 5","stress"));

        stress_daysAdapter stress_daysAdapter = new stress_daysAdapter(this,list);
        days.setAdapter(stress_daysAdapter);
    }
}
