package com.example.mentalhealth.well_bieng_guide;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mentalhealth.R;
import com.example.mentalhealth.well_bieng_guide.Resilience.Activity.RES_START;

public class Well_Being_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wellbieng);

        TextView resilience  = findViewById(R.id.WB_resilience);
        resilience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Well_Being_Activity.this, RES_START.class);
                startActivity(intent);
            }
        });


    }
}
