package com.example.mentalhealth.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mentalhealth.Profile.Edit_profile_act;
import com.example.mentalhealth.R;
import com.example.mentalhealth.SaveSharedPreference;
import com.google.firebase.auth.FirebaseAuth;

public class ProfileFragment extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_profile);

        String naam = "user198";

        TextView name = findViewById(R.id.profile_name);

        if (FirebaseAuth.getInstance().getCurrentUser().getDisplayName() != null) {
            naam = FirebaseAuth.getInstance().getCurrentUser().getDisplayName();
            SaveSharedPreference.setUser(this, FirebaseAuth.getInstance().getCurrentUser().getDisplayName());
        } else {
            naam = SaveSharedPreference.getUserName(this);
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


}
