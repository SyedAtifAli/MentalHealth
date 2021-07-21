package com.example.mentalhealth.well_bieng_guide.start;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mentalhealth.R;
import com.example.mentalhealth.well_bieng_guide.Resilience.Activity.RES_START;

public class How_help_fragment extends Fragment {

    String course, title ,get_start , how_help, day;
    Context context;
    int flag = 0; // flag 0 means get start , 1 means how help

    How_help_fragment(String course , String title , String get_start , String how_help , Context context, String day){
        this.course = course;
        this.title = title;
        this.get_start = get_start;
        this.how_help = how_help;
        this.context = context;
        this.day = day;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.how_help,null);

        TextView Title = v.findViewById(R.id.how_help_title);
        TextView content = v.findViewById(R.id.how_help_content);
        TextView box_title = v.findViewById(R.id.howhelp);
        Button next = v.findViewById(R.id.how_help_nextButton);
        ImageView close = v.findViewById(R.id.how_help_cross);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, RES_START.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });

        Title.setText(title);
        content.setText(get_start);
        box_title.setText("Getting Started");

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag == 0){
                    content.setText(how_help);
                    box_title.setText("How Will This Help?");
                    flag = 1;
                }
                if(flag == 1){
                    flag = 2;

                }
                else if(flag == 2){
                    if(course.equals("res")){
                        if(day.equals("Day 1")){
                            Intent intent = new Intent(context,Bullets.class);
                            intent.putExtra("title",title);
                            intent.putExtra("course",course);
                            intent.putExtra("day",day);
                            startActivity(intent);
                        }
                        else if(day.equals("Day 2")){
                            Intent intent = new Intent(context,Para.class);
                            intent.putExtra("course",course);
                            intent.putExtra("day",2);
                            startActivity(intent);
                        }
                    }

                }
            }
        });


        return v;
    }
}
