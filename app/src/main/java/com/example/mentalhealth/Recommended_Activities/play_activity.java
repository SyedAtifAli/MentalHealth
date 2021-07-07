package com.example.mentalhealth.Recommended_Activities;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mentalhealth.R;

import java.util.concurrent.TimeUnit;

public class play_activity extends AppCompatActivity {

    private double startTime = 0;
    private double finalTime = 0;
    public static int oneTimeOnly = 0;
    int flag = 0;
    private Handler myHandler = new Handler();
    MediaPlayer mediaPlayer;
    TextView activity_time;
    SeekBar seekbar;


    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_activity);

        String title, details;
        int song;
        Intent intent = getIntent();
        title = intent.getStringExtra("title");
        details = intent.getStringExtra("details");
        song = intent.getIntExtra("sound", R.raw.deep);

        TextView Title = findViewById(R.id.activity_title);
        TextView Detail = findViewById(R.id.activity_details);

        ImageButton back = findViewById(R.id.activity_back);
        back.setOnClickListener(v -> play_activity.super.onBackPressed());

        Title.setText(title);
        Detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(play_activity.this, details, Toast.LENGTH_LONG).show();
            }
        });

        mediaPlayer = MediaPlayer.create(this, song);
        seekbar =  findViewById(R.id.activity_seekbar);
        seekbar.setClickable(false);

        activity_time = findViewById(R.id.activity_time);



        ImageButton play = findViewById(R.id.activity_play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag == 0) { //flag = 0  means not playing
                    mediaPlayer.start();


                    play.setImageResource(R.drawable.ic_pause_white);

                    finalTime = mediaPlayer.getDuration();
                    startTime = mediaPlayer.getCurrentPosition();

                    if (oneTimeOnly == 0) {
                        seekbar.setMax((int) finalTime);
                        oneTimeOnly = 1;
                    }

                    long startMin = TimeUnit.MILLISECONDS.toMinutes((long) startTime);
                    long startSec = TimeUnit.MILLISECONDS.toSeconds((long) startTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) startTime));

                    long endMin = TimeUnit.MILLISECONDS.toMinutes((long) finalTime);
                    long endSec = TimeUnit.MILLISECONDS.toSeconds((long) finalTime) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                                    finalTime));

                    String time = String.format("%d:%d/%d:%d", startMin, startSec, endMin, endSec);

                    activity_time.setText(time);

                    seekbar.setProgress((int) startTime);
                    myHandler.postDelayed(UpdateSongTime, 100);
                    flag = 1;
                } else {

                    mediaPlayer.pause();
                    play.setImageResource(R.drawable.ic_play_arrow_white);



                    flag = 0;
                }
            }
        });
    }
    private Runnable UpdateSongTime = new Runnable() {
        public void run() {
            startTime = mediaPlayer.getCurrentPosition();
            long startMin = TimeUnit.MILLISECONDS.toMinutes((long) startTime);
            long startSec = TimeUnit.MILLISECONDS.toSeconds((long) startTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) startTime));

            long endMin = TimeUnit.MILLISECONDS.toMinutes((long) finalTime);
            long endSec = TimeUnit.MILLISECONDS.toSeconds((long) finalTime) -
                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                            finalTime));

            String time = String.format("%d:%d/%d:%d", startMin, startSec, endMin, endSec);
            activity_time.setText(time);

            seekbar.setProgress((int)startTime);
            myHandler.postDelayed(this, 100);
        }
    };

    @Override
    protected void onStop() {
        super.onStop();
        mediaPlayer.stop();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mediaPlayer.stop();
    }
}
