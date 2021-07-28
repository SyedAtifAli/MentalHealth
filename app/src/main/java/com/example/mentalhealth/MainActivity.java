package com.example.mentalhealth;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.example.mentalhealth.chatbot.ChatActivity;
import com.example.mentalhealth.fragments.DiaryFragment;
import com.example.mentalhealth.fragments.GamesFragment;
import com.example.mentalhealth.fragments.HomeFragment;
import com.example.mentalhealth.fragments.ProfileFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.luseen.luseenbottomnavigation.BottomNavigation.BottomNavigationItem;
import com.luseen.luseenbottomnavigation.BottomNavigation.BottomNavigationView;
import com.luseen.luseenbottomnavigation.BottomNavigation.OnBottomNavigationItemClickListener;

import org.jetbrains.annotations.NotNull;

import uk.co.deanwild.materialshowcaseview.MaterialShowcaseView;

public class MainActivity extends AppCompatActivity {

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //loading the default fragment
        loadFragment(new HomeFragment());

        String name = "";
        if (FirebaseAuth.getInstance().getCurrentUser().getDisplayName() != null) {
            name = FirebaseAuth.getInstance().getCurrentUser().getDisplayName();
            SaveSharedPreference.setUser(this, name);
        }

        drawerLayout = findViewById(R.id.my_drawer_layout);
        String finalName = name;
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull @NotNull View drawerView, float slideOffset) {
                //drawer name
                TextView Name = findViewById(R.id.drawer_name);
                Name.setText("Hi, " + finalName);


            }

            @Override
            public void onDrawerOpened(@NonNull @NotNull View drawerView) {

            }

            @Override
            public void onDrawerClosed(@NonNull @NotNull View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });


        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setBackgroundDrawable(
                new ColorDrawable(Color.parseColor("#f5f5f5")));


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
                } else if (index == 2) {
                    Intent intent = new Intent(MainActivity.this, ChatActivity.class);
                    startActivity(intent);
                } else if (index == 3) {
                    loadFragment((new DiaryFragment()));
                } else {
                    Intent intent = new Intent(MainActivity.this, ProfileFragment.class);
                    startActivity(intent);
                }
            }
        });


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

        NavigationView navigationView = findViewById(R.id.navigation_side);
        navigationView.setNavigationItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.nav_rate:
                    rateMe();
                    break;
                case R.id.nav_share:
                    try {
                        Intent intent = new Intent("android.intent.action.SEND");
                        intent.setType("text/plain");
                        intent.putExtra("android.intent.extra.SUBJECT", "Mental Health");
                        intent.putExtra("android.intent.extra.TEXT", "\nHey, I found an amazing app for our mental well-being with free premium therapies for limited time and it is easy to use too.\n\n" + "https://play.google.com/store/apps/details?id=" + getPackageName() + "\n\n");
                        this.startActivity(Intent.createChooser((Intent) intent, (CharSequence) "Well Done!! Share With.."));
                        break;
                    } catch (Exception exception) {
                        return true;
                    }
//                case R.id.nav_reminders:
//                    Intent intent = new Intent(MainActivity.this, Reminder.class);
//                    startActivity(intent);
//                    break;
                case R.id.nav_ask:
                    Intent intent = new Intent("android.intent.action.SENDTO",
                            Uri.fromParts("mailto", "team.yogaplus@gmail.com", (String) null));
                    StringBuilder i = new StringBuilder("\n\n\n\n\n\nDo not delete this - Android Version ");
                    i.append(Build.VERSION.SDK_INT);
                    intent.putExtra("android.intent.extra.TEXT", i.toString());
                    intent.putExtra("android.intent.extra.SUBJECT", "I have a question");
                    MainActivity.this.startActivity(Intent.createChooser(intent, "Send email..."));
                    break;
                case R.id.nav_feedback:
                    Intent intent2 = new Intent("android.intent.action.SENDTO",
                            Uri.fromParts("mailto", "team.yogaplus@gmail.com", (String) null));
                    StringBuilder o = new StringBuilder("\n\n\n\n\n\nDo not delete this - Android Version ");
                    o.append(Build.VERSION.SDK_INT);
                    intent2.putExtra("android.intent.extra.TEXT", o.toString());
                    intent2.putExtra("android.intent.extra.SUBJECT", "Feedback for mental health");
                    MainActivity.this.startActivity(Intent.createChooser(intent2, "Send email..."));
                    break;
                case R.id.nav_logout:
                    FirebaseAuth.getInstance().signOut();
                    Toast.makeText(this, "You are now signed out!", Toast.LENGTH_LONG).show();
                    break;
            }
            if (item.getItemId() == R.id.nav_rate) {
                rateMe();
            }

            return false;
        });
    }

    public boolean loadFragment(Fragment fragment) {
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

    // override the onOptionsItemSelected()
    // function to implement
    // the item click listener callback
    // to open and close the navigation
    // drawer when the icon is clicked


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(!drawerLayout.isOpen() && item.getItemId() == android.R.id.home){ // use android.R.id
            drawerLayout.openDrawer(Gravity.LEFT);
        }
        else if(drawerLayout.isOpen() && item.getItemId() == android.R.id.home){
            drawerLayout.close();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isOpen()) {
            drawerLayout.close();
        } else
            super.onBackPressed();

    }

    public void rateMe() {
        String str = "android.intent.action.VIEW";
        try {
            startActivity(new Intent(str, Uri.parse("market://details?id=" + getPackageName())));
        } catch (ActivityNotFoundException unused) {
            startActivity(new Intent(str, Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));
        }
    }
}