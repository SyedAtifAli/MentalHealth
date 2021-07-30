package com.example.mentalhealth.home.anxiety;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mentalhealth.R;
import com.example.mentalhealth.well_bieng_guide.Model.DAYS;

import java.util.ArrayList;

public class Anxiety_start extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anxiety_start);

        RecyclerView days = findViewById(R.id.anx_days_rv);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        days.setLayoutManager(linearLayoutManager);

        ArrayList<DAYS> list = new ArrayList<>();
        list.add(new DAYS("Day 1","Quick Muscle Relaxation","anxiety"));
        list.add(new DAYS("Day 2","The problem framework","anxiety"));
        list.add(new DAYS("Day 3","Hot Air Balloon","anxiety"));
        list.add(new DAYS("Day 4","day 4","anxiety"));
        list.add(new DAYS("Day 5","day 5","anxiety"));
        list.add(new DAYS("Day 6","day 6","anxiety"));

        anxiety_daysAdapter anxiety_daysAdapter = new anxiety_daysAdapter(this,list);
        days.setAdapter(anxiety_daysAdapter);
    }
}
