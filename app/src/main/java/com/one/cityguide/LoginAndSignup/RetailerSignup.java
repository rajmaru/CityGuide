package com.one.cityguide.LoginAndSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.one.cityguide.R;

import org.w3c.dom.Text;

public class RetailerSignup extends AppCompatActivity {

    TextView loginBtn;
    MaterialButton nextBtn;
    ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retailer_signup);

        nextBtn = findViewById(R.id.nextBtn_RetailerSignup);
        loginBtn = findViewById(R.id.loginBtn_RetailerSignup);
        backBtn = findViewById(R.id.backBtn_RetailerSignup);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RetailerSignup.this, RetailerLoginAndSignup.class));
                finishAffinity();
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RetailerSignup.this, RetailerLogin.class);
                intent.putExtra("type","signup");
                startActivity(intent);
                finishAffinity();
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RetailerSignup.this, Make_Selection.class);
                intent.putExtra("type",false);
                startActivity(intent);
                finishAffinity();
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(RetailerSignup.this, RetailerLoginAndSignup.class));
        finishAffinity();
    }
}