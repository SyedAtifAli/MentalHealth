package com.example.mentalhealth.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.mentalhealth.MainActivity;
import com.example.mentalhealth.Profile.Edit_profile_act;
import com.example.mentalhealth.R;
import com.example.mentalhealth.SaveSharedPreference;
import com.example.mentalhealth.Smiley.Smiley_DBHelper;
import com.google.firebase.auth.FirebaseAuth;

public class ProfileFragment extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_profile);

        Smiley_DBHelper smiley_dbHelper = new Smiley_DBHelper(this);
        int smile = smiley_dbHelper.getSmile();

        ImageView dp = findViewById(R.id.profile_avatar);
        dp.setImageResource(getImg(SaveSharedPreference.getDP(this)));

        TextView name = findViewById(R.id.profile_name);
        CardView mood = findViewById(R.id.mood_track);
        TextView mood_count = mood.findViewById(R.id.profile_count);
        mood_count.setText(""+smile);
        smiley_dbHelper.close();

        String naam = "";
        if (FirebaseAuth.getInstance().getCurrentUser().getDisplayName() != null) {
            naam = FirebaseAuth.getInstance().getCurrentUser().getDisplayName();
            SaveSharedPreference.setUser(this, naam);
        }
        else{
            naam = SaveSharedPreference.getUser(this);
        }

        name.setText(naam);

        ImageView edit = findViewById(R.id.edit_profile);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileFragment.this, Edit_profile_act.class);
                startActivity(intent);
            }
        });

    }

    private int getImg(int dp) {
        if(dp == 1){
            return R.drawable.avatar1;
        }if(dp == 2){
            return R.drawable.avatar2;
        }if(dp == 3){
            return R.drawable.avatar3;
        }if(dp == 4){
            return R.drawable.avatar4;
        }if(dp == 5){
            return R.drawable.avatar5;
        }if(dp == 6){
            return R.drawable.avatar6;
        }if(dp == 7){
            return R.drawable.avatar7;
        }if(dp == 8){
            return R.drawable.avatar8;
        }if(dp == 9){
            return R.drawable.avatar9;
        }if(dp == 10){
            return R.drawable.avatar10;
        }if(dp == 11){
            return R.drawable.avatar11;
        }if(dp == 12){
            return R.drawable.avatar12;
        }if(dp == 13){
            return R.drawable.avatar13;
        }if(dp == 14){
            return R.drawable.avatar14;
        }if(dp == 15){
            return R.drawable.avatar15;
        }
        else{
            return R.drawable.avatar16;
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ProfileFragment.this, MainActivity.class);
        startActivity(intent);
        finishAffinity();
    }
}
