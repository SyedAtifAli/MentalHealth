package com.example.mentalhealth.well_bieng_guide.Anxiety.Activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mentalhealth.R;
import com.example.mentalhealth.well_bieng_guide.Anxiety.Adapter.Anxiety_daysAdapter;
import com.example.mentalhealth.well_bieng_guide.Model.DAYS;

import java.util.ArrayList;
import java.util.List;

public class Anxiety_START extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable  Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_anxiety_start);

        RecyclerView days = findViewById(R.id.anxiety_days_rv);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        days.setLayoutManager(linearLayoutManager);

        List<DAYS> list = new ArrayList<>();
        list.add(new DAYS("Day 1","Defining Anxiety"));
        list.add(new DAYS("Day 2","Defining Anxiety"));
        list.add(new DAYS("Day 3","Defining Anxiety"));
        list.add(new DAYS("Day 4","Defining Anxiety"));
        list.add(new DAYS("Day 5","Defining Anxiety"));
        list.add(new DAYS("Day 6","Defining Anxiety"));
        list.add(new DAYS("Day 7","Defining Anxiety"));
        list.add(new DAYS("Day 8","Defining Anxiety"));

        Anxiety_daysAdapter anxiety_daysAdapter = new Anxiety_daysAdapter(this,list);
        days.setAdapter(anxiety_daysAdapter);
    }






}
