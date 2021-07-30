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
                    }
                });
            }
            else if(day == 2){
                title.setText("Nurturing Strength");
                content.setText("When difficulties arise, instead of getting bogged down, think of what strength you can use to address the situation. Take action to recognise what you're capable of to develop a resilient mindset");
                next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(nutshell.this,rate_activity.class);
                        intent.putExtra("course", "res");
                        intent.putExtra("day", 2);
                        startActivity(intent);
                    }
                });
            }
            else if (day == 3){
                title.setText("Your Social Support");
                content.setText("The next time you feel stressed and don't know how to move forward from a situation, come back to this list and ask for help from the people you identified as your support system." );
                        next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(nutshell.this,rate_activity.class);
                        intent.putExtra("course", "res");
                        intent.putExtra("day", 3);
                        startActivity(intent);
                    }
                });
            }
        }
        else if(course.equals("anxiety")){
            if(day == 1){
                title.setText("Quick Muscle Relaxation");
                content.setText("Use your muscles to beat anxiety! You can do this exercise whenever you find your body tensing up due to anxiety. In fact, regular practise can protect you from feeling anxious in the first place.");
                next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(nutshell.this,rate_activity.class);
                        intent.putExtra("course", "anxiety");
                        intent.putExtra("day", 1);
                        startActivity(intent);
                    }
                });
            }
        }
        else if (course.equals("stress")) {
            if (day == 1) {
                title.setText("Belly Breathing");
                content.setText("Give your body a dose of fresh oxygen with belly breathing. This technique can be difficult for beginners, so be patient with yourself. You will get better at it with practise!");
                next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(nutshell.this, rate_activity.class);
                        intent.putExtra("course", "stress");
                        intent.putExtra("day", 1);
                        startActivity(intent);
                    }
                });
            }
        }
        else if (course.equals("anger")) {
            if (day == 1) {
                title.setText("Sign of Anger");
                content.setText("");
                next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(nutshell.this, rate_activity.class);
                        intent.putExtra("course", "anger");
                        intent.putExtra("day", 1);
                        startActivity(intent);
                    }
                });
            }
        }

    }
}
