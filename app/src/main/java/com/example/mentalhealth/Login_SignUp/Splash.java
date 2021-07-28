package com.example.mentalhealth.Login_SignUp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.example.mentalhealth.R;

public class Splash extends AppCompatActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.splash);
        getWindow().setFlags(1024, 1024);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Splash.this.startActivity(new Intent(Splash.this, OnBoardingScreen.class));
                Splash.this.finish();
            }
        }, 1800);
    }
}
