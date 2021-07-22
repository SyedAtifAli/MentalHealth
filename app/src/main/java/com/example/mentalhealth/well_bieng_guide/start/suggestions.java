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

public class suggestions extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.suggestion);
        String course = "";
        int day;
        course = getIntent().getStringExtra("course");
        day = getIntent().getIntExtra("day", 1);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView recyclerView = findViewById(R.id.sug_rv);
        recyclerView.setLayoutManager(layoutManager);

        Button next = findViewById(R.id.sug_next);

        if(course.equals("res")){
            if(day == 1){
                List<bulletsModel> list = new ArrayList<>();
                list.add(new bulletsModel("All peole have some level of resilience. It varies from person to person"));
                list.add(new bulletsModel("All peole have some level of resilience. It varies from person to person"));
                list.add(new bulletsModel("All peole have some level of resilience. It varies from person to person"));

                BulletAdapter adapter = new BulletAdapter(list, this);
                recyclerView.setAdapter(adapter);

                next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent(suggestions.this,nutshell.class);
                        intent.putExtra("course", "res");
                        intent.putExtra("day", 1);
                        startActivity(intent);
                    }
                });
            }
            else if(day == 3){
                List<bulletsModel> list = new ArrayList<>();
                list.add(new bulletsModel("These are the people you have identified as someone you can lean on."));
                list.add(new bulletsModel("Spend some time reconnecting with them."));
                list.add(new bulletsModel("give them a call or send them a message - and nurture your relationship."));

                BulletAdapter adapter = new BulletAdapter(list, this);
                recyclerView.setAdapter(adapter);

                next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent(suggestions.this,nutshell.class);
                        intent.putExtra("course", "res");
                        intent.putExtra("day", 3);
                        startActivity(intent);
                    }
                });
            }
        }
    }
}
