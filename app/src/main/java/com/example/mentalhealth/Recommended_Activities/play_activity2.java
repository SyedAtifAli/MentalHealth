package com.example.mentalhealth.Recommended_Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mentalhealth.R;

public class play_activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_activity2);

        ImageButton back = findViewById(R.id.activity_back2);
        back.setOnClickListener(v -> play_activity2.super.onBackPressed());

        Intent intent = getIntent();
        String Title = intent.getStringExtra("title");
        String Details = intent.getStringExtra("details");
        int img = intent.getIntExtra("img",0);

        TextView tite = findViewById(R.id.activity_title2);
        tite.setText(Title);

        TextView details = findViewById(R.id.activity_details2);
        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(play_activity2.this, Details, Toast.LENGTH_SHORT).show();
            }
        });

        ImageView imageView = findViewById(R.id.activity_img2);
        imageView.setImageResource(img);


    }
}
