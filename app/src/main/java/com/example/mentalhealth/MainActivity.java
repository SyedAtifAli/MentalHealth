package com.example.mentalhealth;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.mentalhealth.chatbot.ChatActivity;
import com.example.mentalhealth.fragments.DiaryFragment;
import com.example.mentalhealth.fragments.GamesFragment;
import com.example.mentalhealth.fragments.HomeFragment;
import com.example.mentalhealth.fragments.ProfileFragment;
import com.luseen.luseenbottomnavigation.BottomNavigation.BottomNavigationItem;
import com.luseen.luseenbottomnavigation.BottomNavigation.BottomNavigationView;
import com.luseen.luseenbottomnavigation.BottomNavigation.OnBottomNavigationItemClickListener;

import uk.co.deanwild.materialshowcaseview.MaterialShowcaseView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //loading the default fragment
        loadFragment(new HomeFragment());

     BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
     bottomNavigationView.setElevation(0);

        BottomNavigationItem bottomNavigationItem1 = new BottomNavigationItem
                ("Home", ContextCompat.getColor(this, R.color.white), R.drawable.ic_home);
        BottomNavigationItem bottomNavigationItem2 = new BottomNavigationItem
                ("Activity", ContextCompat.getColor(this, R.color.white), R.drawable.ic_games);
        BottomNavigationItem bottomNavigationItem3 = new BottomNavigationItem
                ("", ContextCompat.getColor(this, R.color.white), R.drawable.ic_games);
        BottomNavigationItem bottomNavigationItem4 = new BottomNavigationItem
                ("Journal", ContextCompat.getColor(this, R.color.white), R.drawable.ic_diary);
        BottomNavigationItem bottomNavigationItem5 = new BottomNavigationItem
                ("Profile", ContextCompat.getColor(this, R.color.white), R.drawable.ic_profile);
        bottomNavigationView.addTab(bottomNavigationItem1);
        bottomNavigationView.addTab(bottomNavigationItem2);
        bottomNavigationView.addTab(bottomNavigationItem3);
        bottomNavigationView.addTab(bottomNavigationItem4);
        bottomNavigationView.addTab(bottomNavigationItem5);

        bottomNavigationView.isColoredBackground(false);
        bottomNavigationView.setItemActiveColorWithoutColoredBackground(Color.parseColor("#01BCD3"));



        bottomNavigationView.setOnBottomNavigationItemClickListener(new OnBottomNavigationItemClickListener() {
            @Override
            public void onNavigationItemClick(int index) {
                if (index == 0) {
                    loadFragment(new HomeFragment());
                } else if (index == 1) {
                    loadFragment((new GamesFragment()));
                }
                else if(index == 2){
                    Intent intent = new Intent(MainActivity.this, ChatActivity.class);
                    startActivity(intent);
                }
                else if (index == 3) {
                    loadFragment((new DiaryFragment()));
                } else {
                    loadFragment((new ProfileFragment()));
                }
            }
        });

//        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
//        bottomNavigationView.setItemIconTintList(null);
//        bottomNavigationView.setSelected(false);
//        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
//            switch (item.getItemId()) {
//                case R.id.home:
//                    loadFragment(new HomeFragment());
//                    break;
//                case R.id.activity:
//                    loadFragment(new GamesFragment());
//                    break;
//                case R.id.chat:
//
//                    break;
//                case R.id.diary:
//                    loadFragment(new DiaryFragment());
//                    break;
//                case R.id.profile:
//                    loadFragment(new ProfileFragment());
//                    break;
//
//            }
//            return false;
//        });
        ImageView main_fab = findViewById(R.id.main_FAB);

        new MaterialShowcaseView.Builder(this)
                .setTarget(main_fab)
                .setDismissText("GOT IT")
                .setContentText("Hi!! welcome aboard.\nYou can start a conversation\nwith alexa\njust tap on this button.")
                .setDelay(1000) // optional but starting animations immediately in onCreate can make them choppy
                .singleUse("alexa") // provide a unique ID used to ensure it is only shown once
                .show();

        main_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChatActivity.class);
                startActivity(intent);
            }
        });
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit();
            return true;
        }
        return false;
    }


}