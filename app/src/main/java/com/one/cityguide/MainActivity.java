package com.one.cityguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.one.cityguide.OnBoarding.OnBoardingScreen;
import com.one.cityguide.User.UserDashboard;


public class MainActivity extends AppCompatActivity {

    SharedPreferences onBoardingPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SplashScreen.installSplashScreen(this);
        setContentView(R.layout.activity_main);

        onBoardingPreferences = getSharedPreferences("onBoardingScreen", MODE_PRIVATE);
        boolean isFirstTime = onBoardingPreferences.getBoolean("isFirstTime", true);

        if (isFirstTime) {
            SharedPreferences.Editor editor = onBoardingPreferences.edit();
            editor.putBoolean("isFirstTime", false);
            editor.apply();
            startActivity(new Intent(this, OnBoardingScreen.class));
        } else {
            startActivity(new Intent(this, UserDashboard.class));
        }
        finish();
    }
}