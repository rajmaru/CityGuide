package com.one.cityguide.LoginAndSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.one.cityguide.R;
import com.one.cityguide.User.UserDashboard;

public class RetailerLoginAndSignup extends AppCompatActivity {

    ImageView backBtn;
    MaterialButton loginBtn, signupBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retailer_login_signup);

        loginBtn = findViewById(R.id.loginBtn_RetailerLoginSignup);
        signupBtn = findViewById(R.id.signupBtn_RetailerLoginSignup);
        backBtn = findViewById(R.id.backBtn_RetailerLoginSignup);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RetailerLoginAndSignup.this, UserDashboard.class));
                finishAffinity();
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RetailerLoginAndSignup.this, RetailerLogin.class);
                intent.putExtra("type","loginsignup");
                startActivity(intent);
                finishAffinity();
            }
        });

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RetailerLoginAndSignup.this, RetailerSignup.class));
                finishAffinity();
            }
        });

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(RetailerLoginAndSignup.this, UserDashboard.class));
        finishAffinity();
    }
}