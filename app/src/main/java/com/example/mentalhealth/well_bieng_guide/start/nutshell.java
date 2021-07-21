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

public class nutshell extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable  Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nutshell);

        TextView content = findViewById(R.id.nutshell_content);
        TextView title = findViewById(R.id.nutshell_title);
        Button next = findViewById(R.id.nutshell_nextButton);
        ImageView close = findViewById(R.id.nutshell_cross);

        String course = "";
        int day;
        course = getIntent().getStringExtra("course");
        day = getIntent().getIntExtra("day", 1);

        if(course.equals("res")) {
            if (day == 1) {
                title.setText("Defining Resilience");
                content.setText("Resilience is not the absence of distress, but the willingness to face problems and work towards overcomming them. A simple understanding of resilience can help you incorporate it into your life!");
                next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(nutshell.this,rate_activity.class);
                        intent.putExtra("course", "res");
                        intent.putExtra("day", 1);
                        startActivity(intent);
                        startActivity(intent);
                    }
                });
            }
        }

    }
}
