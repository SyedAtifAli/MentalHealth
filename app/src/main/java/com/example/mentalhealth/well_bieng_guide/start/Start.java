package com.example.mentalhealth.well_bieng_guide.start;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.mentalhealth.R;

public class Start extends AppCompatActivity {

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.start_acts);

        Intent intent = getIntent();
        String course = intent.getStringExtra("course");
        String day = intent.getStringExtra("day");
        String title = intent.getStringExtra("title");

        Log.d("abcde", course + " " + day + " " + title);

        String start = getStart(day,course);
        String help = HowHelp(day,course);
        loadFragment(new How_help_fragment(course,title,start,help,this,day));

    }
    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.start_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    private String getStart(String day,String course){

        if(course.equals("res")){
            if(day.equals("Day 1")){
                return "the new wave of the virus has come with its own set of challenges. If you're struggling to cope, know that you're not alone. We're here to help you build resilience and cope a little bit better.";
            }
            if(day.equals("Day 2")){
                return "blahblah";
            }
        }
        else if(course.equals("anx")){

        }
        else if(course.equals("lon")){

        }
        else{
            //self love
        }
    return "null";
    }

    private String HowHelp(String day, String course){
        if(course.equals("res")){
            if(day.equals("Day 1")){
                return "Understanding what resilience means will hep you identify and implement stategies to build resilience in your own life. This can even better prepare you to deal with any challenges you encounter.";
            }
        }
        return "";
    }
}
