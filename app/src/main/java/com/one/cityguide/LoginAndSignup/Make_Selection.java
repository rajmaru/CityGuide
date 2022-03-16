package com.one.cityguide.LoginAndSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.one.cityguide.R;

public class Make_Selection extends AppCompatActivity {

    ImageView backBtn;
    MaterialButton nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_selection);

        Bundle bundle = getIntent().getExtras();
        boolean type = bundle.getBoolean("type");

        backBtn = findViewById(R.id.backBtn_MakeSelection);
        nextBtn = findViewById(R.id.nextBtn_MakeSelection);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Make_Selection.super.onBackPressed();
            }
        });


        if(type){
            nextBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Make_Selection.this, OTP_PinView.class);
                    intent.putExtra("type",type);
                    startActivity(intent);
                }
            });
        }else{
            nextBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Make_Selection.this, OTP_PinView.class);
                    intent.putExtra("Type",type);
                    startActivity(intent);
                }
            });
        }

    }
}
