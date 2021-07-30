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
        else if(course.equals("anger")){
            if(day == 1){
                Title.setText("Signs of Anger");
                box_title.setText( Html.fromHtml("<b>Get a better understanding of the sign you have selected</b>"));
                content.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                if(value.equals("Difficulty concentrating")){
                    content.setText(Html.fromHtml("Great job on identifying your sign!<br><b>"+ value + "</b><br>In times of anger, your brain focuses on the cause of anger. This blocks other thoughts out, making it difficult for you to concentrate."));

                }
                if(value.equals("Memory problem")){
                    content.setText(Html.fromHtml("Great job on identifying your sign!<br><b>"+ value + "</b><br>Anger can consume your brain's resources making it difficult to pay attention, focus, or store information. This leads to memory problems"));

                }
                 if(value.equals("Thoughts of hurting someone")){
                    content.setText(Html.fromHtml("Great job on identifying your sign!<br><b>"+ value + "</b><br>Anger is usually felt in response to perceived injustice. This can make you want to retaliate by wanting to harm the responsible person."));

                }
                 if(value.equals("Bitter,harsh or critical thoughts")){
                    content.setText(Html.fromHtml("Great job on identifying your sign!<br><b>"+ value + "</b><br>Anger is almost always the result of negative harsh thoughts, such as 'I hate him','She's so selfish', or 'This person is the worst'."));

                }
                 if(value.equals("Overthinking about the problem")){
                    content.setText(Html.fromHtml("Great job on identifying your sign!<br><b>"+ value + "</b><br>When you are angry, you might brood over what upsets you. Ruminating or overthinking makes you feel like you are solving the problem."));

                }
                 if(value.equals("Rapid heart beat")){
                    content.setText(Html.fromHtml("Great job on identifying your sign!<br><b>"+ value + "</b><br>In times of anger, your brain focuses on the cause of anger. This blocks other thoughts out, making it difficult for you to concentrate."));

                }
                 if(value.equals("Shaking")){
                     content.setText(Html.fromHtml("Great job on identifying your sign!<br><b>"+ value + "</b><br>In times of anger, your brain focuses on the cause of anger. This blocks other thoughts out, making it difficult for you to concentrate."));

                }
                 if(value.equals("Tense muscles")){
                     content.setText(Html.fromHtml("Great job on identifying your sign!<br><b>"+ value + "</b><br>In times of anger, your brain focuses on the cause of anger. This blocks other thoughts out, making it difficult for you to concentrate."));

                }
                 if(value.equals("Headaches")){
                     content.setText(Html.fromHtml("Great job on identifying your sign!<br><b>"+ value + "</b><br>In times of anger, your brain focuses on the cause of anger. This blocks other thoughts out, making it difficult for you to concentrate."));

                }
                 if(value.equals("Frowning")){
                     content.setText(Html.fromHtml("Great job on identifying your sign!<br><b>"+ value + "</b><br>In times of anger, your brain focuses on the cause of anger. This blocks other thoughts out, making it difficult for you to concentrate."));

                }
                 if(value.equals("Hot or red face")){
                     content.setText(Html.fromHtml("Great job on identifying your sign!<br><b>"+ value + "</b><br>In times of anger, your brain focuses on the cause of anger. This blocks other thoughts out, making it difficult for you to concentrate."));

                }
                 if(value.equals("Rage")){
                     content.setText(Html.fromHtml("Great job on identifying your sign!<br><b>"+ value + "</b><br>In times of anger, your brain focuses on the cause of anger. This blocks other thoughts out, making it difficult for you to concentrate."));

                }
                 if(value.equals("Humiliation")){
                     content.setText(Html.fromHtml("Great job on identifying your sign!<br><b>"+ value + "</b><br>In times of anger, your brain focuses on the cause of anger. This blocks other thoughts out, making it difficult for you to concentrate."));

                }
                 if(value.equals("Anger about unrelated things")){
                     content.setText(Html.fromHtml("Great job on identifying your sign!<br><b>"+ value + "</b><br>In times of anger, your brain focuses on the cause of anger. This blocks other thoughts out, making it difficult for you to concentrate."));

                }
                 if(value.equals("Irritatibilty")){
                     content.setText(Html.fromHtml("Great job on identifying your sign!<br><b>"+ value + "</b><br>In times of anger, your brain focuses on the cause of anger. This blocks other thoughts out, making it difficult for you to concentrate."));

                }

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
                        intent.putExtra("course","anger");
                        intent.putExtra("day",1);
                        startActivity(intent);
                    }
                });
            }
        }
    }
}
