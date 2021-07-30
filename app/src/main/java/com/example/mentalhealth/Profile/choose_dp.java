package com.example.mentalhealth.Profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mentalhealth.R;
import com.example.mentalhealth.SaveSharedPreference;

public class choose_dp extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_dp);
        ImageView a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p;
        ImageView selecteddp = findViewById(R.id.preview_dp);

        a = findViewById(R.id.dp1);
        b = findViewById(R.id.dp2);
        c = findViewById(R.id.dp3);
        d = findViewById(R.id.dp4);
        e = findViewById(R.id.dp5);
        f = findViewById(R.id.dp6);
        g = findViewById(R.id.dp7);
        h = findViewById(R.id.dp8);
        i = findViewById(R.id.dp9);
        j = findViewById(R.id.dp10);
        k = findViewById(R.id.dp11);
        l = findViewById(R.id.dp12);
        m = findViewById(R.id.dp13);
        n = findViewById(R.id.dp14);
        o = findViewById(R.id.dp15);
        p = findViewById(R.id.dp16);

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveSharedPreference.setDp(choose_dp.this, 1);
               selecteddp.setImageResource(getImg(SaveSharedPreference.getDP(choose_dp.this)));
               selecteddp.setImageResource(getImg(SaveSharedPreference.getDP(choose_dp.this)));
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveSharedPreference.setDp(choose_dp.this, 2);
               selecteddp.setImageResource(getImg(SaveSharedPreference.getDP(choose_dp.this)));
               selecteddp.setImageResource(getImg(SaveSharedPreference.getDP(choose_dp.this)));
            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveSharedPreference.setDp(choose_dp.this, 3);
               selecteddp.setImageResource(getImg(SaveSharedPreference.getDP(choose_dp.this)));
               selecteddp.setImageResource(getImg(SaveSharedPreference.getDP(choose_dp.this)));
            }
        });
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveSharedPreference.setDp(choose_dp.this, 4);
               selecteddp.setImageResource(getImg(SaveSharedPreference.getDP(choose_dp.this)));
               selecteddp.setImageResource(getImg(SaveSharedPreference.getDP(choose_dp.this)));
            }
        });
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveSharedPreference.setDp(choose_dp.this, 5);
               selecteddp.setImageResource(getImg(SaveSharedPreference.getDP(choose_dp.this)));
            }
        });
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveSharedPreference.setDp(choose_dp.this, 6);
               selecteddp.setImageResource(getImg(SaveSharedPreference.getDP(choose_dp.this)));
            }
        });
        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveSharedPreference.setDp(choose_dp.this, 7);
               selecteddp.setImageResource(getImg(SaveSharedPreference.getDP(choose_dp.this)));
            }
        });
        h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveSharedPreference.setDp(choose_dp.this, 8);
               selecteddp.setImageResource(getImg(SaveSharedPreference.getDP(choose_dp.this)));
            }
        });
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveSharedPreference.setDp(choose_dp.this, 9);
               selecteddp.setImageResource(getImg(SaveSharedPreference.getDP(choose_dp.this)));
            }
        });
        j.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveSharedPreference.setDp(choose_dp.this, 10);
               selecteddp.setImageResource(getImg(SaveSharedPreference.getDP(choose_dp.this)));
            }
        });
        k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveSharedPreference.setDp(choose_dp.this, 11);
               selecteddp.setImageResource(getImg(SaveSharedPreference.getDP(choose_dp.this)));
            }
        });
        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveSharedPreference.setDp(choose_dp.this, 12);
               selecteddp.setImageResource(getImg(SaveSharedPreference.getDP(choose_dp.this)));
            }
        });
        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveSharedPreference.setDp(choose_dp.this, 13);
               selecteddp.setImageResource(getImg(SaveSharedPreference.getDP(choose_dp.this)));
            }
        });
        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveSharedPreference.setDp(choose_dp.this, 14);
               selecteddp.setImageResource(getImg(SaveSharedPreference.getDP(choose_dp.this)));
            }
        });
        o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveSharedPreference.setDp(choose_dp.this, 15);
               selecteddp.setImageResource(getImg(SaveSharedPreference.getDP(choose_dp.this)));
            }
        });
        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveSharedPreference.setDp(choose_dp.this, 16);
               selecteddp.setImageResource(getImg(SaveSharedPreference.getDP(choose_dp.this)));
            }
        });

        ImageButton save = findViewById(R.id.save_dp);
        ImageButton back = findViewById(R.id.back_dp);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(choose_dp.this,Edit_profile_act.class);
                startActivity(intent);
                finish();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choose_dp.super.onBackPressed();
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

}
