package com.one.cityguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.one.cityguide.OnBoardingScreen.OnBoardingScreen;
import com.one.cityguide.User.UserDashboard;

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
            editor.putBoolean("isFirstTime", false);
            editor.apply();
            startActivity(new Intent(this, OnBoardingScreen.class));
        } else {
            startActivity(new Intent(this, UserDashboard.class));
        }
        finish();
    }
}