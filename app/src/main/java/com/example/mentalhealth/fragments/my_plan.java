package com.example.mentalhealth.fragments;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mentalhealth.R;
import com.example.mentalhealth.Smiley.Smiley_DBHelper;

public class my_plan extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myplan);

        Smiley_DBHelper smiley_dbHelper = new Smiley_DBHelper(this);
        int smile = smiley_dbHelper.getSmile();
        TextView textView = findViewById(R.id.plan_content);


        if (smile == 1) {
            textView.setText( Html.fromHtml("<b>Looks like you are not feeling your best currently</b><br><br>Here are some Tips for you<br><br>" +
                    "Drink more Water, at least 8 Glasses per day<br><br>" +
                    "Take a day off and do a fast and rest<br><br>" +
                    "Be with people who treat you well<br><br>"+
                    "Have a “green” smoothie<br><br>" +
                    "Accept what's not perfect.<br><br>" +
                    "Take a warm or hot shower<br><br>" +
                    "Do some yoga"));
        }
        if (smile == 2) {
            textView.setText( Html.fromHtml("<b>Looks like you are not feeling your best currently</b><br><br>Here are some Tips for you<br><br>" +
                    "Drink more Water, at least 8 Glasses per day<br><br>" +
                    "Acknowledge that all emotions come from within<br><br>" +
                    "Remind yourself that this moment is your most precious resource.<br><br>" +
                    "Take a warm or hot shower<br><br>" +
                    "Accept what's not perfect.<br><br>" +
                    "Be with people who treat you well<br><br>"+
                    "Do some yoga"));
        }
        if (smile == 3) {
            textView.setText( Html.fromHtml("<b>So You are just Okay?</b><br><br>Lets make you feel great, Here are some Tips for you<br><br>" +
                    "Drink more Water, at least 8 Glasses per day<br><br>" +
                    "Acknowledge that all emotions come from within<br><br>" +
                    "Take a day off and do a fast and rest<br><br>" +
                    "Don’t resist where you are; BE where you are.<br><br>" +
                    "Take a warm or hot shower<br><br>" +
                    "Focus on what goes well.<br><br>" +
                    "Do some yoga"));
        }
        if (smile == 4) {
            textView.setText( Html.fromHtml("<bYou are looking great today</b><br><br>Here are some Tips for you<br><br>" +
                    "Drink more Water, at least 8 Glasses per day<br><br>" +
                    "See challenges as stepping-stones<br><br>" +
                    "Curl up with a good book and enjoy some fiction<br><br>" +
                    "Take a warm or hot shower<br><br>" +
                    "Acknowledge that all emotions come from within<br><br>" +
                    "Do some yoga"));
        }
        if (smile == 5) {
            textView.setText( Html.fromHtml("<b>You are looking great today</b><br><br>Here are some Tips for you<br><br>" +
                    "Drink more Water, at least 8 Glasses per day<br><br>" +
                    "Visualize a better life after failure.<br><br>" +
                    "Do some cardio to get your blood pumping or go for a walk<br><br>" +
                    "Take a warm or hot shower<br><br>"+
                    "Acknowledge that all emotions come from within<br><br>" +
                    "Do some yoga"));
        }
    smiley_dbHelper.close();
    }
}
