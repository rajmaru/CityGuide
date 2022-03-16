package com.one.cityguide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AllCategoriesActivity extends AppCompatActivity {

    ImageView backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_categories);

        hooks();

        backBtnClicked();

    }

    private void hooks() {
        backBtn = findViewById(R.id.backBtn_RetailerLogin);
    }

    private void backBtnClicked() {
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AllCategoriesActivity.super.onBackPressed();
            }
        });
    }
}