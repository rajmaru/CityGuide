package com.one.cityguide.LoginAndSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.one.cityguide.R;
import com.one.cityguide.User.UserDashboard;

public class RetailerLogin extends AppCompatActivity {

    TextView createAccountBtn;
    ImageView backBtn;
    MaterialButton forgotPasswordBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retailer_login);

        Bundle bundle = getIntent().getExtras();
        String type = bundle.getString("type");

        backBtn = findViewById(R.id.backBtn_RetailerLogin);
        createAccountBtn = findViewById(R.id.createAccountBtn_RetailerLogin);
        forgotPasswordBtn = findViewById(R.id.forgotPasswordBtn_RetailerLogin);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (type) {
                    case "userdashboard":
                        startActivity(new Intent(RetailerLogin.this, UserDashboard.class));
                        finish();
                        break;
                    case "passwordupdated":
                        startActivity(new Intent(RetailerLogin.this, Password_Updated.class));
                        finish();
                        break;
                    case "signup":
                        startActivity(new Intent(RetailerLogin.this, RetailerSignup.class));
                        finish();
                        break;
                    default:
                        startActivity(new Intent(RetailerLogin.this, RetailerLoginAndSignup.class));
                        finish();
                        break;
                }
            }
        });

        createAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RetailerLogin.this, RetailerSignup.class));
                finish();
            }
        });

        forgotPasswordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RetailerLogin.this, Forgot_Password.class));
            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Bundle bundle = getIntent().getExtras();
        String type = bundle.getString("type");
        switch (type) {
            case "userdashboard":
                startActivity(new Intent(RetailerLogin.this, UserDashboard.class));
                finishAffinity();
                break;
            case "passwordupdated":
                startActivity(new Intent(RetailerLogin.this, Password_Updated.class));
                finishAffinity();
                break;
            case "signup":
                startActivity(new Intent(RetailerLogin.this, RetailerSignup.class));
                finishAffinity();
                break;
            default:
                startActivity(new Intent(RetailerLogin.this, RetailerLoginAndSignup.class));
                finishAffinity();
                break;
        }
    }
}