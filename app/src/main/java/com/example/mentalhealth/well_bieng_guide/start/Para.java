package com.example.mentalhealth.well_bieng_guide.start;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mentalhealth.R;

public class Para extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.para_activity);

        String course;
        int day;
        course = getIntent().getStringExtra("course");
        day = getIntent().getIntExtra("day", 1);

        TextView content = findViewById(R.id.para_content);
        TextView title = findViewById(R.id.para_title);
        Button next = findViewById(R.id.para_next);


        if(course.equals("res")){
            if(day == 1){
                title.setText("Understanding Resilience");
                content.setText( Html.fromHtml("<b>The 3 C's of resilience</b><br><br>" +
                        "In psychology, resilience is defined as the ability to adapt well in the face of adversity,<br>" +
                        "trauma, tragedy, threats and significant sources of stress. According to the psycologist<br>" +
                        "Susan Kobasa, there are 3 elements that are necessary to cultivate resilience, namely-challenge, commitment and control.<br><br>" +
                        "<b>Element 1: Challenge</b><br><br>" + " According to the first element, resilience involves " +
                        "not getting paralysed in the face of adversity. It " +
                        "means shifting your perspective to look at setbacks " +
                        "as a challenge that can be overcome. Being resilient" +
                        "means approaching challenges with an open mind, " +
                        "looking at failures as lessons, and considering " +
                        "obstacles as opportunities for personal growth.<br><br>" +
                        "<b>Element 2: Commitment</b><br><br>"+
                        " The second element emphasises the fact that " +
                        "resilience involves having a high sense of " +
                        "commitment. It means having deep and meaningful " +
                        "relationships with others which will motivate you " +
                        "to move forward. Essentially, your commitment and " +
                        "care will encourage you to keep going even when " +
                        "faced with adversities.<br><br>"+
                        "<b>Element 3: Control</b><br><br>"+
                        " And finally, the last element denotes that resilience " +
                        "means focusing your time and energy on situations " +
                        "you have control over. Instead of worrying about " +
                        "what you cannot change or don't have control over, " +
                        "you work towards things that are controllable. " +
                        "By doing so, you will feel more confident and " +
                        "empowered to take on any challenges.") );
                next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Para.this,WriteSomething.class);
                        intent.putExtra("course","res");
                        intent.putExtra("day",1);
                        startActivity(intent);
                    }
                });
            }
            else if(day == 2){
                title.setText("How to do this activity");
                content.setText( Html.fromHtml("<b>Understand what strength is</b><br><br>" +
                        "Your strengths are good qualities that you feel you " +
                        "possess. In addition to including things you are good " +
                        "at, your strengths also involve things you enjoy " +
                        "doing. When you have a good understanding of " +
                        "your strengths, you can use them to fulfil your goals " +
                        "and create a better life for yourself. <br><br>" +
                        "<b>Identify your strengths</b><br><br>" +
                        "We all possess distinct strengths that help us grow " +
                        "and flourish in life. Take a moment to think about all " +
                        "your strengths. You might be surprised by what you " +
                        "learn. For instance, you may come to the realisation " +
                        "that you are diligent and creative as you have been " +
                        "working long hours and finding creative solutions to " +
                        "problems. <br><br>" +
                        "<b>Rank your strengths</b><br><br>" +
                        "On the next screen, we will ask you to rank your " +
                        "strengths based on how frequently you display " +
                        "them. Alternatively, you can also rank them based " +
                        "on how strongly you think you possess them. " +
                        "Following the previous example, you may rank " +
                        "diligence and creativity as the highest on your list.<br<br>" +
                        "<bNurture your strengths </b><br><br>" +
                        "After you are sure of your ranking, you can click " +
                        "on the next screen. We will show you the top 2 " +
                        "strengths you see in yourself. We'll also suggest " +
                        "ways for you to encourage and nurture these " +
                        "strengths. From the top 2, pick any 1 strength that " +
                        "you would like to nurture."));
                next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Para.this,drag_list.class);
                        intent.putExtra("course","res");
                        intent.putExtra("day",2);
                        startActivity(intent);
                    }
                });


            }
            else if(day == 3){
                title.setText("Why is it important to identify people you can lean on?");
                content.setText( Html.fromHtml("<b>It helps you fell less lonely</b><br><br>" +
                        "A person who Is surrounded by well-wishers may" +
                        "still find themselves feeling lonely because they" +
                        "don't feel connected to the people around them." +
                        "Whereas, when you recognise that you have people" +
                        "in your life who are supporting you, and who you" +
                        "can connect to, you feel less lonely, even when you" +
                        "are alone. <br><br>" +
                        "<b>It makes life memorable </b><br><br>" +
                        "All humans have a basic need for social connection." +
                        "When you have loved ones around you during" +
                        "happy moments it fulfils this need. It also enhances" +
                        "the positive emotions you experience at such times" +
                        "and makes feel warm and connected.<br><br>"+
                        "<b>It helps you feel supported </b><br><br>"+
                        "On the other hand, having loved ones supporting" +
                        "you during a period of sadness or stress can help" +
                        "you cope with the situation better, and protects you" +
                        "against maladaptive behaviours. <br><br>"+
                        "<b>It improves your health </b><br><br>"+
                        "Poor social support has been linked to depression," +
                        "alcohol use, and heart disease. Improving social" +
                        "support has long term benefits on your health," +
                        "immunity, and longevity. "));
                next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Para.this,WriteSomething.class);
                        intent.putExtra("course","res");
                        intent.putExtra("day",3);
                        startActivity(intent);
                    }
                });


            }
        }



    }
}
