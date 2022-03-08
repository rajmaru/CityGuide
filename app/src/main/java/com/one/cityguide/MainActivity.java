package com.one.cityguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.one.cityguide.Common.OnBoardingScreen;
import com.one.cityguide.Common.SliderAdapter;
import com.one.cityguide.Common.Sliderdata;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SharedPreferences onBoardingScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SplashScreen.installSplashScreen(this);
        setContentView(R.layout.activity_main);

        onBoardingScreen = getSharedPreferences("onBoardingScreen", MODE_PRIVATE);
        boolean isFirstTime = onBoardingScreen.getBoolean("isFirstTime", true);

        if (isFirstTime) {
            SharedPreferences.Editor editor = onBoardingScreen.edit();
            editor.putBoolean("isFirstTime", true);
            editor.apply();
            startActivity(new Intent(this, OnBoardingScreen.class));
        } else {
            startActivity(new Intent(this, UserDashboard.class));
        }
        finish();
    }
}