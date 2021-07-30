package com.example.mentalhealth.home.anger;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mentalhealth.R;
import com.example.mentalhealth.well_bieng_guide.Model.DAYS;

import java.util.ArrayList;

public class anger_start extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anger_start);
        RecyclerView days = findViewById(R.id.anger_days_rv);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        days.setLayoutManager(linearLayoutManager);

        ArrayList<DAYS> list = new ArrayList<>();
        list.add(new DAYS("Day 1","Signs of Anger","anger"));
        list.add(new DAYS("Day 2","The problem framework","anger"));
        list.add(new DAYS("Day 3","Hot Air Balloon","anger"));
        list.add(new DAYS("Day 4","day 4","anger"));
        list.add(new DAYS("Day 5","day 5","anger"));

        anger_daysAdapter anger_daysAdapter = new anger_daysAdapter(this,list);
        days.setAdapter(anger_daysAdapter);
    }
}
