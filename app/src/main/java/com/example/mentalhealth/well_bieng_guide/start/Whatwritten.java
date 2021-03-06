package com.example.mentalhealth.well_bieng_guide.start;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mentalhealth.R;

public class Whatwritten extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.what_written);


        String course = "" , def, sad ,pep, lonely, advice;
        int day;
        course = getIntent().getStringExtra("course");
        day = getIntent().getIntExtra("day", 1);
        def = getIntent().getStringExtra("content");
        sad = getIntent().getStringExtra("sad");
        pep = getIntent().getStringExtra("pep");
        lonely = getIntent().getStringExtra("lonely");
        advice = getIntent().getStringExtra("advice");


        TextView title = findViewById(R.id.ww_title);
        TextView content = findViewById(R.id.ww_content);
        TextView answer = findViewById(R.id.ww_answer);
        TextView suggestion = findViewById(R.id.ww_suggest);
        Button next = findViewById(R.id.ww_next);

        if(course.equals("res")) {
            if (day == 1) {
                title.setText("Take a look at what you have written");
                content.setText("My defination of resilience");
                answer.setText(def);
                suggestion.setText(getString(R.string.res_day_1_whatwritten_suggest));
                next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent(Whatwritten.this,suggestions.class);
                        intent.putExtra("course", "res");
                        intent.putExtra("day", 1);
                        startActivity(intent);
                    }
                });

            }
            else if( day == 3){
                title.setText("Take a look at what you have written");
                content.setText(Html.fromHtml("Who uplifts your mood<br><br>" +
                        "<font color='#000'>"+sad+"</font><br><br>" +
                        "Who boosts your confidence <br><br><font color='#000000'>" +pep+"</font><br><br>"+
                        "Who makes you feel less alone  <br><br><font color='#000000'>" +lonely+"</font><br><br>"+
                        "Who gives you the best advice   <br><br><font color='#000000'>" +advice+"</font><br><br>"));
                answer.setVisibility(View.INVISIBLE);
                suggestion.setVisibility(View.INVISIBLE);
                next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent(Whatwritten.this,suggestions.class);
                        intent.putExtra("course", "res");
                        intent.putExtra("day", 3);
                        startActivity(intent);
                    }
                });
            }
        }
    }
}
