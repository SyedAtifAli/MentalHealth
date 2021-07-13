package com.example.mentalhealth.well_bieng_guide.Resilience.Activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mentalhealth.R;
import com.example.mentalhealth.well_bieng_guide.Resilience.Adapter.RES_daysAdapter;
import com.example.mentalhealth.well_bieng_guide.Model.DAYS;

import java.util.ArrayList;
import java.util.List;

public class RES_START extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable  Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_res_start);

        RecyclerView days = findViewById(R.id.res_days_rv);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        days.setLayoutManager(linearLayoutManager);

        List<DAYS> list = new ArrayList<>();
        list.add(new DAYS("Day 1","Defining resilience"));
        list.add(new DAYS("Day 2","Defining resilience"));
        list.add(new DAYS("Day 3","Defining resilience"));
        list.add(new DAYS("Day 4","Defining resilience"));
        list.add(new DAYS("Day 5","Defining resilience"));
        list.add(new DAYS("Day 6","Defining resilience"));
        list.add(new DAYS("Day 7","Defining resilience"));
        list.add(new DAYS("Day 8","Defining resilience"));

        RES_daysAdapter res_daysAdapter = new RES_daysAdapter(this,list);
        days.setAdapter(res_daysAdapter);
    }






}
