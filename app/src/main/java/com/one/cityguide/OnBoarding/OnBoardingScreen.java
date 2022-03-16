package com.one.cityguide.OnBoarding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.one.cityguide.R;
import com.one.cityguide.User.UserDashboard;

import java.util.ArrayList;

public class OnBoardingScreen extends AppCompatActivity {

    LinearLayout dotsLayout;
    TextView[] dots;
    Button startBtn;
    ViewPager2 viewPager;
    SliderAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding_screen);

        dotsLayout = findViewById(R.id.linearLayout_OnBoardingScreen);
        startBtn = findViewById(R.id.startBtn_OnBoardingScreen);

        ArrayList<Sliderdata> sliderdata = new ArrayList<>();
        sliderdata.add(new Sliderdata((R.drawable.onboarding_first_img), "Search Your Location"));
        sliderdata.add(new Sliderdata((R.drawable.onboarding_second_img), "Make A Call"));
        sliderdata.add(new Sliderdata((R.drawable.onboarding_third_img), "Add Missing Place"));
        sliderdata.add(new Sliderdata((R.drawable.onboarding_fourth_img), "Sit Back And Enjoy"));

        viewPager = findViewById(R.id.slider_OnBoardingScreen);
        adapter = new SliderAdapter(this, sliderdata);
        viewPager.setAdapter(adapter);

        addDots();
        changeDots(0);

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                changeDots(position);
            }
        });

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OnBoardingScreen.this, UserDashboard.class));
                finish();
            }
        });
    }

    private void addDots() {
        dots = new TextView[4];
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.light_white));
            dotsLayout.addView(dots[i]);
        }
    }

    private void changeDots(int position) {
        for (int i = 0; i < dots.length; i++) {
            if (i == position) {
                dots[position].setTextColor(getResources().getColor(R.color.colorSecondary));
            }else{
                dots[i].setTextColor(getResources().getColor(R.color.light_white));
            }
            if (position == dots.length - 1) {
                startBtn.setVisibility(View.VISIBLE);
            } else {
                startBtn.setVisibility(View.INVISIBLE);
            }
        }
    }
}