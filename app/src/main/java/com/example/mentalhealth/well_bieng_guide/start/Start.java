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
            else if(day.equals("Day 2")){
                return "In difficult times, do you tend to focus more on your weaknesses? Today's activity will help change that! Learn how to recognise your strengths, so you can build resilience in the face of distress.";
            }
            else if(day.equals("Day 3")){
                return "Having people who you can lean on during difficult times improves your coping ability. Today's activity will help you recognise the people in your life who you can lean on";
            }
        }
        else if(course.equals("anx")){

        }
        else if(course.equals("lon")){

        }
        else if(course.equals("anxiety")){
            if(day.equals("Day 1")) {
                return "Do you ever wonder what you can do to lessen the negative impact of anxiety? We've got you covered. Today's audio exercise will leave you feeling calm and relaxed in a matter of minutes";
            }
        }else if(course.equals("stress")){
            if(day.equals("Day 1")) {
                return "Stressful times can have a negative impact on yur mind and body. Belly breathing, also called diaphragmatic breathing, will help you change the way you breath in order to protect you from stress.";
            }
        }else if(course.equals("anger")){
            if(day.equals("Day 1")) {
                return "Do you now what happens to your mind and body when you are angry? Today's activity will help you identify and better understand the different signs of anger.";
            }
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
            else if(day.equals("Day 2")){
                return "Resilence is the ability to recover from challenges. Identifying and nurturing your strengths can help you build the confidence to fight through difficult situations when they arise";
            }
            else if(day.equals("Day 3")){
                return "";
            }
        }
        else if(course.equals("anxiety")){
            if(day.equals("Day 1")) {
                return "Quick Muscle Relaxation is a technique that targets areas in your body that typically hold tension. Doing this exercise enables you to let go of anxiety and feel at ease, physically and mentally.";
            }
        } else if(course.equals("stress")){
            if(day.equals("Day 1")) {
                return "As the name suggests, this activity involves breathing frm your belly. This deeper form of breathing can reduce heart rate and stabilise blood pressure. As a result, it can relax your body and mind.";
            }
        }else if(course.equals("anger")){
            if(day.equals("Day 1")) {
                return "Anger doesn't go from 0 to 100 without any warning - there are several signs of anger to watch out for. Recognising these signs can help you take action before your anger gets out of hand.";
            }
        }
        return "";
    }
}
