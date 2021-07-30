package com.example.mentalhealth.well_bieng_guide.start;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mentalhealth.R;

import java.util.concurrent.TimeUnit;


public class play_activity3 extends AppCompatActivity {

    private double startTime = 0;
    private double finalTime = 0;
    public static int oneTimeOnly = 0;
    int flag = 0;
    private Handler myHandler = new Handler();
    MediaPlayer mediaPlayer;
    TextView activity_time;
    SeekBar seekbar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_activity3);
        ImageButton play = findViewById(R.id.activity_play3);

        if (!isOnline()) {
            play.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    new FancyGifDialog.Builder(play_activity3.this)
//                            .setTitle("Granny eating chocolate dialog box") // You can also send title like R.string.from_resources
//                            .setMessage("This is a granny eating chocolate dialog box. This library is used to help you easily create fancy gify dialog.") // or pass like R.string.description_from_resources
//                            .setTitleTextColor(R.color.black)
//                            .setDescriptionTextColor(R.color.black)
//                            .setNegativeBtnText("Cancel") // or pass it like android.R.string.cancel
//                            .setPositiveBtnBackground(R.color.fourtholor)
//                            .setPositiveBtnText("Ok") // or pass it like android.R.string.ok
//                            .setNegativeBtnBackground(R.color.mdtp_dark_gray)
//                            .setGifResource(R.drawable.gif1)   //Pass your Gif here
//                            .isCancellable(true)
//                            .OnPositiveClicked(new FancyGifDialogListener() {
//                                @Override
//                                public void OnClick() {
//                                    Toast.makeText(play_activity3.this, "Ok", Toast.LENGTH_SHORT).show();
//                                }
//                            })
//                            .OnNegativeClicked(new FancyGifDialogListener() {
//                                @Override
//                                public void OnClick() {
//                                    Toast.makeText(play_activity3.this, "Cancel", Toast.LENGTH_SHORT).show();
//                                }
//                            })
//                            .build();
//
//                    NoInternetDialog noInternetDialog = new NoInternetDialog.Builder(play_activity3.this).build();
                }
            });
        } else {


            String title;
            int song, day;
            Intent intent = getIntent();
            title = intent.getStringExtra("title");
            song = intent.getIntExtra("sound", R.raw.deepbreathing);

            TextView Title = findViewById(R.id.activity_title3);

            Title.setText(title);

            mediaPlayer = MediaPlayer.create(this, song);
            seekbar = findViewById(R.id.activity_seekbar3);
            seekbar.setClickable(false);

            activity_time = findViewById(R.id.activity_time3);

            findViewById(R.id.activity_done3).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (title.equals("Quick Muscle Relaxation")) {

                        Intent intent1 = new Intent(play_activity3.this, nutshell.class);
                        intent1.putExtra("course", "anxiety");
                        intent1.putExtra("day", 1);
                        startActivity(intent1);

                    } else if (title.equals("Belly Breathing")){

                        Intent intent1 = new Intent(play_activity3.this, nutshell.class);
                        intent1.putExtra("course", "stress");
                        intent1.putExtra("day", 1);
                        startActivity(intent1);

                    }
                }
            });


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
    }

    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        } else {
            return false;
        }
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

            seekbar.setProgress((int) startTime);
            myHandler.postDelayed(this, 100);
        }
    };

    @Override
    protected void onStop() {
        super.onStop();
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }

    }

    @Override
    public void onBackPressed() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
        super.onBackPressed();
    }


}

