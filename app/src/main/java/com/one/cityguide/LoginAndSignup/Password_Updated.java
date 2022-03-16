package com.one.cityguide.LoginAndSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.one.cityguide.R;

public class Password_Updated extends AppCompatActivity {

    ImageView backBtn;
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_updated);

        loginBtn = findViewById(R.id.loginBtn_password_updated);
        backBtn = findViewById(R.id.backBtn_password_updated);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Password_Updated.this, RetailerLogin.class);
                intent.putExtra("type","passupdated");
                startActivity(intent);
                finishAffinity();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(Password_Updated.this, RetailerLogin.class));
        finishAffinity();
    }
}