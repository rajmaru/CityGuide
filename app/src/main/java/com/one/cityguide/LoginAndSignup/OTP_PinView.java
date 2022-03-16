package com.one.cityguide.LoginAndSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.mukesh.OtpView;
import com.one.cityguide.R;
import com.one.cityguide.User.UserDashboard;

public class OTP_PinView extends AppCompatActivity {

    OtpView otpView;
    Button verify;
    ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_pin_view);

        Bundle bundle = getIntent().getExtras();
        boolean type = bundle.getBoolean("type");

        verify = findViewById(R.id.verify_OTPPinView);
        backBtn= findViewById(R.id.backBtn_OTPPinView);
        otpView = findViewById(R.id.otpText_OTPPinView);
        otpView.requestFocus();

        if(type){
            verify.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(OTP_PinView.this, Password_Updated.class));
                    finishAffinity();
                }
            });
        }else{
            verify.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(OTP_PinView.this, UserDashboard.class));
                    finishAffinity();
                }
            });
        }

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OTP_PinView.super.onBackPressed();
            }
        });
    }
}