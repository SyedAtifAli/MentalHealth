package com.example.mentalhealth.well_bieng_guide.start;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mentalhealth.R;

public class Para extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.para_activity);

        String course;
        int day;
        course = getIntent().getStringExtra("course");
        day = getIntent().getIntExtra("day", 1);

        TextView content = findViewById(R.id.para_content);
        TextView title = findViewById(R.id.para_title);

        if(course.equals("course")){
            if(day == 1){
                title.setText("Understanding Resilience");
                content.setText( getString(R.string.para_res_1));
                Button next = findViewById(R.id.para_next);
                next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Para.this,WriteSomething.class);
                        intent.putExtra("course","res");
                        intent.putExtra("day",1);
                        startActivity(intent);
                    }
                });
            }
        }



    }
}
