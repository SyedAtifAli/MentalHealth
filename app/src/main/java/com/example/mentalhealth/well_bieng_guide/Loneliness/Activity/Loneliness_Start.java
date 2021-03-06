package com.example.mentalhealth.well_bieng_guide.Loneliness.Activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mentalhealth.R;
import com.example.mentalhealth.well_bieng_guide.Loneliness.Adapter.Lon_daysAdapter;
import com.example.mentalhealth.well_bieng_guide.Model.DAYS;

import java.util.ArrayList;
import java.util.List;

public class Loneliness_Start extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable  Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_lon_start);

        RecyclerView days = findViewById(R.id.lon_days_rv);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        days.setLayoutManager(linearLayoutManager);

        List<DAYS> list = new ArrayList<>();
        list.add(new DAYS("Day 1","Beliefs About Alone Time","lon"));
        list.add(new DAYS("Day 2","The Reconnection Effect","lon"));
        list.add(new DAYS("Day 3","Identifying Your Emotions","lon"));
        list.add(new DAYS("Day 4","Loving-Kindness Practice","lon"));
        list.add(new DAYS("Day 5","Staying Connected","lon"));
        list.add(new DAYS("Day 6","Defining Loneliness","lon"));
        list.add(new DAYS("Day 7","Defining Loneliness","lon"));
        list.add(new DAYS("Day 8","Defining Loneliness","lon"));

        Lon_daysAdapter lon_daysAdapter = new Lon_daysAdapter(this,list);
        days.setAdapter(lon_daysAdapter);
    }

}
