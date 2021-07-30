package com.example.mentalhealth.Profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mentalhealth.R;
import com.example.mentalhealth.SaveSharedPreference;
import com.example.mentalhealth.fragments.ProfileFragment;

public class Edit_profile_act extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_profile);

        String[] gender = { "Male", "Female", "Other"};

        EditText name = findViewById(R.id.name_et_ep);
        EditText email = findViewById(R.id.height_et_ep);
        ImageView imageView = findViewById(R.id.select_pic);
        Spinner spin = findViewById(R.id.gender_spinner);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,gender);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SaveSharedPreference.setGender(Edit_profile_act.this,getGender(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Edit_profile_act.this,choose_dp.class);
                startActivity(intent);
            }
        });


        imageView.setImageResource(getImg(SaveSharedPreference.getDP(this)));
        name.setText(SaveSharedPreference.getUser(this));
        email.setText(SaveSharedPreference.getEmail(this));

        Button save = findViewById(R.id.save_ep);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!name.getText().toString().trim().isEmpty() && !email.getText().toString().trim().isEmpty()){
                    SaveSharedPreference.setUser(Edit_profile_act.this,name.getText().toString().trim());
//                    SaveSharedPreference.setEma(Edit_profile_act.this,email.getText().toString().trim());
                    Intent intent = new Intent(Edit_profile_act.this, ProfileFragment.class);
                    startActivity(intent);
                    finishAffinity();
                }
                else
                {
                    Toast.makeText(Edit_profile_act.this, "Please enter correct details", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private String getGender(int position) {
        if(position == 0){
            return "Male";
        }if(position == 1){
            return "Female";
        }
        else{
            return "Other";
        }
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
}
