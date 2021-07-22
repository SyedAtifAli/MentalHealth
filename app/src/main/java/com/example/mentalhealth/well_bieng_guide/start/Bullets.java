package com.example.mentalhealth.well_bieng_guide.start;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
        TextView title = findViewById(R.id.bullet_title);

        if(course.equals("res")){
            if(day.equals("day 1")){
                title.setText("A closer look at defining resilience");
            }
            else if(day.equals("Day 3")){
                title.setText("A closer look at your social support");
            }
        }

        next.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
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
                if(day.equals("Day 3")){
                    Intent intent = new Intent(Bullets.this,Para.class);
                    intent.putExtra("course","res");
                    intent.putExtra("day",3);
                    startActivity(intent);
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
            else if(day.equals("Day 3")){
                list.add(new bulletsModel("Social support refers to the network of loved ones who you can depend on."));
                list.add(new bulletsModel("Studies show that poor social support has harmful consequences on you"));
                list.add(new bulletsModel("Whereas having rich social support protects your physical and psychological health"));
                list.add(new bulletsModel("In fact, a study conducted at Howard University for over 80 years back this up."));
                list.add(new bulletsModel("According to this study, good quality of social relationships improve your well-being."));
                list.add(new bulletsModel("Social support has been linked to greater resilience to stress and adversity."));
                list.add(new bulletsModel("Social support builds you up and helps you thrive even n difficult times."));
            }
        }
        return list;
    }
}
