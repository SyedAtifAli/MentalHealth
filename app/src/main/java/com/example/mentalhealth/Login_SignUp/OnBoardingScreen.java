package com.example.mentalhealth.Login_SignUp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.mentalhealth.MainActivity;
import com.example.mentalhealth.R;
import com.example.mentalhealth.SaveSharedPreference;
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

public class OnBoardingScreen extends AppCompatActivity {
    /* access modifiers changed from: private */
    public Button back;
    /* access modifiers changed from: private */
    public int currentPage;
    /* access modifiers changed from: private */
    public int[] layouts = {R.layout.first_slide, R.layout.second_slide, R.layout.third_slide};
    /* access modifiers changed from: private */
    public Button next;
    private WormDotsIndicator wormDotsIndicator;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (SaveSharedPreference.getRef(this)) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
        setContentView((int) R.layout.activity_on_boarding_screenm);
        final ViewPager pager = (ViewPager) findViewById(R.id.viewPager);
        pager.setAdapter(new ViewPagerAdapter(this.layouts, this));
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            public void onPageSelected(int position) {
                int unused = OnBoardingScreen.this.currentPage = position;
                if (OnBoardingScreen.this.currentPage == 0) {
                    OnBoardingScreen.this.back.setEnabled(false);
                    OnBoardingScreen.this.next.setEnabled(true);
                    OnBoardingScreen.this.back.setVisibility(View.INVISIBLE);
                } else if (OnBoardingScreen.this.currentPage == OnBoardingScreen.this.layouts.length - 1) {
                    OnBoardingScreen.this.back.setEnabled(true);
                    OnBoardingScreen.this.next.setEnabled(true);
                    OnBoardingScreen.this.back.setVisibility(View.VISIBLE);
                    OnBoardingScreen.this.next.setText("FINISH");
                } else {
                    OnBoardingScreen.this.back.setEnabled(true);
                    OnBoardingScreen.this.next.setEnabled(true);
                    OnBoardingScreen.this.back.setVisibility(View.VISIBLE);
                    OnBoardingScreen.this.next.setText("NEXT");
                }
            }

            public void onPageScrollStateChanged(int state) {
            }
        });
        this.wormDotsIndicator = (WormDotsIndicator) findViewById(R.id.worm_dots_indicator);
        Button button = (Button) findViewById(R.id.buttonBack);
        this.back = button;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                pager.setCurrentItem(OnBoardingScreen.this.currentPage - 1);
            }
        });
        Button button2 = (Button) findViewById(R.id.buttonNext);
        this.next = button2;
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (OnBoardingScreen.this.currentPage == OnBoardingScreen.this.layouts.length - 1) {
                    SaveSharedPreference.setRef(OnBoardingScreen.this, true);
                    OnBoardingScreen.this.startActivity(new Intent(OnBoardingScreen.this, SignUp.class));
                    OnBoardingScreen.this.finish();
                    return;
                }
                pager.setCurrentItem(OnBoardingScreen.this.currentPage + 1);
            }
        });
        this.wormDotsIndicator.setViewPager(pager);
    }
}
