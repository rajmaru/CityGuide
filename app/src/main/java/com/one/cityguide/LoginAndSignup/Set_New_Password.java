package com.one.cityguide.LoginAndSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.button.MaterialButton;
import com.one.cityguide.R;

public class Set_New_Password extends AppCompatActivity {

    MaterialButton saveBtn;
    ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_new_password);

        backBtn = findViewById(R.id.backBtn_SetNewPassword);
        saveBtn = findViewById(R.id.saveBtn_SetNewPassword);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Set_New_Password.this, Password_Updated.class));
                finishAffinity();
            }
        });
    }
}