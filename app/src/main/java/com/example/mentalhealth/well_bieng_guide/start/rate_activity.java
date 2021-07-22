package com.example.mentalhealth.well_bieng_guide.start;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mentalhealth.R;
import com.example.mentalhealth.well_bieng_guide.Resilience.SQLite.Resilience_DBHelper;
import com.example.mentalhealth.well_bieng_guide.Well_Being_Activity;

public class rate_activity  extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable  Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rate_activity);

        TextView title = findViewById(R.id.rate_title);
        Button yes = findViewById(R.id.rate_yes);
        Button no = findViewById(R.id.rate_no);
        ImageView close = findViewById(R.id.rate_cross);

        Resilience_DBHelper helper = new Resilience_DBHelper(this);


        String course = "";
        int day;
        course = getIntent().getStringExtra("course");
        day = getIntent().getIntExtra("day", 1);

        if(course.equals("res")){
            if(day == 1){
                title.setText("Defining Resilience");
                yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        helper.saveDay(day);
                        Intent intent = new Intent(rate_activity.this, Well_Being_Activity.class);
                        startActivity(intent);
                        finishAffinity();

                    }
                });
                no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        helper.saveDay(day);
                        Intent intent = new Intent(rate_activity.this, Well_Being_Activity.class);
                        startActivity(intent);
                        finishAffinity();

                    }
                });

                helper.close();
            }
        }
         if(day == 2){
            title.setText("Nurturing Strength");
            yes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    helper.saveDay(day);
                    Intent intent = new Intent(rate_activity.this, Well_Being_Activity.class);
                    startActivity(intent);
                    finishAffinity();

                }
            });
            no.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    helper.saveDay(day);
                    Intent intent = new Intent(rate_activity.this, Well_Being_Activity.class);
                    startActivity(intent);
                    finishAffinity();

                }
            });

            helper.close();
        }
         if(day == 3){
             title.setText("Your Social Support");
             yes.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     helper.saveDay(day);
                     Intent intent = new Intent(rate_activity.this, Well_Being_Activity.class);
                     startActivity(intent);
                     finishAffinity();

                 }
             });
             no.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     helper.saveDay(day);
                     Intent intent = new Intent(rate_activity.this, Well_Being_Activity.class);
                     startActivity(intent);
                     finishAffinity();

                 }
             });

             helper.close();
         }
        else {
            helper.close();
        }
    }
}
