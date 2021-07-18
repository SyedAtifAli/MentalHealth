package com.example.mentalhealth.well_bieng_guide.Resilience.Activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mentalhealth.R;
import com.example.mentalhealth.well_bieng_guide.Model.DAYS;
import com.example.mentalhealth.well_bieng_guide.Resilience.Adapter.RES_daysAdapter;

import java.util.ArrayList;

public class RES_START extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable  Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_res_start);

        RecyclerView days = findViewById(R.id.res_days_rv);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        days.setLayoutManager(linearLayoutManager);

        ArrayList<DAYS> list = new ArrayList<>();
        list.add(new DAYS("Day 1","Defining resilience","res"));
        list.add(new DAYS("Day 2","Nurturing Strength","res"));
        list.add(new DAYS("Day 3","Your Social Support","res"));
        list.add(new DAYS("Day 4","Healthy Coping Behaviour","res"));
        list.add(new DAYS("Day 5","Resilience Log","res"));
        list.add(new DAYS("Day 6","Growth Mindset","res"));
        list.add(new DAYS("Day 7","Defining resilience","res"));
        list.add(new DAYS("Day 8","Defining resilience","res"));

        RES_daysAdapter res_daysAdapter = new RES_daysAdapter(this,list);
        days.setAdapter(res_daysAdapter);
    }






}
