package com.example.mentalhealth.well_bieng_guide.SelfLove.Activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mentalhealth.R;
import com.example.mentalhealth.well_bieng_guide.Model.DAYS;
import com.example.mentalhealth.well_bieng_guide.SelfLove.Adapter.Selflove_daysAdapter;

import java.util.ArrayList;
import java.util.List;

public class Selflove_START extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable  Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_selflove_start);

        RecyclerView days = findViewById(R.id.selflove_days_rv);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        days.setLayoutManager(linearLayoutManager);

        List<DAYS> list = new ArrayList<>();
        list.add(new DAYS("Day 1","Defining Self Love"));
        list.add(new DAYS("Day 2","Defining Self Love"));
        list.add(new DAYS("Day 3","Defining Self Love"));
        list.add(new DAYS("Day 4","Defining Self Love"));
        list.add(new DAYS("Day 5","Defining Self Love"));
        list.add(new DAYS("Day 6","Defining Self Love"));
        list.add(new DAYS("Day 7","Defining Self Love"));
        list.add(new DAYS("Day 8","Defining Self Love"));

        Selflove_daysAdapter selflove_daysAdapter = new Selflove_daysAdapter(this,list);
        days.setAdapter(selflove_daysAdapter);
    }






}
