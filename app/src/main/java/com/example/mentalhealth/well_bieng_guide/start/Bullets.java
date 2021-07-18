package com.example.mentalhealth.well_bieng_guide.start;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mentalhealth.R;
import com.example.mentalhealth.well_bieng_guide.Model.bulletsModel;

import java.util.ArrayList;
import java.util.List;

public class Bullets extends AppCompatActivity {

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.bullet_points);

        String course,day;
        course = getIntent().getStringExtra("course");
        day = getIntent().getStringExtra("day");

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        RecyclerView bullets = findViewById(R.id.bullet_points_rv);
        bullets.setLayoutManager(linearLayoutManager);

        BulletAdapter adapter = new BulletAdapter(getBullets(course,day), this);
        bullets.setAdapter(adapter);

        Button next = findViewById(R.id.bullet_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(course.equals("res")){
                    if(day.equals("Day 1")){
                        Intent intent = new Intent(Bullets.this,Para.class);
                        intent.putExtra("course","res");
                        intent.putExtra("day",1);
                        startActivity(intent);
                    }
                }
            }
        });
    }

    private List<bulletsModel> getBullets(String course , String day){
        List<bulletsModel> list = new ArrayList<>();
        if(course.equals("res")){
            if(day.equals("Day 1")){
                list.add(new bulletsModel("Resilience gives people the strength of mind to cope with hardships and stressors."));
                list.add(new bulletsModel("It refers to a reservoir of strength that can be tapped into during times of need"));
                list.add(new bulletsModel("Resilience helps you learn from adversity and protects you from its consequences."));
                list.add(new bulletsModel("It is because of your resilience that you are able to survive difficult situations."));
                list.add(new bulletsModel("During difficult times, resilience allows you to maintain balance in our life."));
                list.add(new bulletsModel("Some people are more resilient than others. This gives them better coping abilities."));
                list.add(new bulletsModel("However, resilience is a skill that can be enhanced with practice."));
                list.add(new bulletsModel("By understanding what resilience is you can learn to cultivate it in your own life."));
            }
        }
        return list;
    }
}
