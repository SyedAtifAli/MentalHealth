package com.example.mentalhealth.well_bieng_guide.start;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mentalhealth.R;

public class drag_select extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drag_select);

        String course, value;
        int day;
        course = getIntent().getStringExtra("course");
        day = getIntent().getIntExtra("day", 1);
        value = getIntent().getStringExtra("strength");

        TextView Title = findViewById(R.id.ds_title);
        TextView content = findViewById(R.id.ds_content);
        TextView box_title = findViewById(R.id.ds_box_title);
        Button next = findViewById(R.id.ds_next);
        Button edit = findViewById(R.id.ds_edit);
        ImageView close = findViewById(R.id.ds_cross);

        if(course.equals("res")){
            if(day == 2){
                Title.setText("Nurturing Strength");
                box_title.setText( Html.fromHtml("<b>Building resilience</b>"));
                content.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                content.setText(Html.fromHtml("Great job on identifying your strength! This is the strength you have decided to nurture<br><br><b>"+ value + "</b>"));

                edit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        drag_select.super.onBackPressed();
                    }
                });

                next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(drag_select.this,nutshell.class);
                        intent.putExtra("course","res");
                        intent.putExtra("day",2);
                        startActivity(intent);
                    }
                });
            }
        }
    }
}
