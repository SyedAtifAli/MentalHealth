package com.example.mentalhealth.well_bieng_guide;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mentalhealth.MainActivity;
import com.example.mentalhealth.R;
import com.example.mentalhealth.well_bieng_guide.Anxiety.Activity.Anxiety_START;
import com.example.mentalhealth.well_bieng_guide.Loneliness.Activity.Loneliness_Start;
import com.example.mentalhealth.well_bieng_guide.Resilience.Activity.RES_START;
import com.example.mentalhealth.well_bieng_guide.SelfLove.Activity.Selflove_START;
import com.wajahatkarim3.easyflipview.EasyFlipView;

import uk.co.deanwild.materialshowcaseview.MaterialShowcaseSequence;
import uk.co.deanwild.materialshowcaseview.ShowcaseConfig;

public class Well_Being_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable  Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wellbieng);

        TextView resilience = findViewById(R.id.WB_resilience);
        resilience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Well_Being_Activity.this, RES_START.class);
                startActivity(intent);
            }
        });

        TextView loneliness = findViewById(R.id.WB_lonliness);
        loneliness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Well_Being_Activity.this, Loneliness_Start.class);
                startActivity(intent);
            }
        });
        TextView anxiety = findViewById(R.id.WB_anxiety);
        anxiety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Well_Being_Activity.this, Anxiety_START.class);
                startActivity(intent);
            }
        });
        TextView sellfove = findViewById(R.id.WB_selflove);
        sellfove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Well_Being_Activity.this, Selflove_START.class);
                startActivity(intent);
            }
        });

        EasyFlipView easyFlipView = findViewById(R.id.showcase_1);

        ShowcaseConfig config = new ShowcaseConfig();
        config.setDelay(500); // half second between each showcase view


        MaterialShowcaseSequence sequence = new MaterialShowcaseSequence(this, "wellbeing");

        sequence.setConfig(config);

        sequence.addSequenceItem(easyFlipView,
                "Introducing your very own 2021 well-being guide\nTap on the cards to know the details.", "GOT IT");

        sequence.addSequenceItem(resilience,
                "Click on the name of the course to start it.", "GOT IT");


        sequence.start();



    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Well_Being_Activity.this, MainActivity.class);
        startActivity(intent);
        finishAffinity();
    }
}
