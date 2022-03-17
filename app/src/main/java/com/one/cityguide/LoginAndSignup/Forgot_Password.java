package com.one.cityguide.LoginAndSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.hbb20.CountryCodePicker;
import com.one.cityguide.R;

public class Forgot_Password extends AppCompatActivity {

    MaterialButton nextBtn;
    ImageView backBtn;
    TextInputLayout phonenumber;
    String _phonenumber;
    CountryCodePicker countryCodePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        hooks();

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (phonenumberValidator()) {
                    addCountryCode();
                    Intent intent = new Intent(Forgot_Password.this, OTP_PinView.class);
                    intent.putExtra("type", true);
                    intent.putExtra("phonenumber", _phonenumber);
                    startActivity(intent);
                }
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Forgot_Password.super.onBackPressed();
            }
        });
    }

    private void hooks() {
        backBtn = findViewById(R.id.backBtn_ForgotPassword);
        nextBtn = findViewById(R.id.nextBtn_ForgotPassword);
        phonenumber = findViewById(R.id.phonenumberInputlayout_ForgotPassword);
        countryCodePicker = findViewById(R.id.countryCodePicker_ForgotPassword);
    }


    private void addCountryCode() {
        String _countrycode = countryCodePicker.getSelectedCountryCode();
        _phonenumber = "+" + _countrycode + _phonenumber;
    }

    private boolean phonenumberValidator() {
        String number = phonenumber.getEditText().getText().toString().trim();

        if (number.length() < 10) {
            phonenumber.setError("Too small!");
            phonenumber.setCounterEnabled(true);
            phonenumber.getEditText().requestFocus();
            return false;
        } else if (number.length() > 10) {
            phonenumber.setError("Too large!");
            phonenumber.setCounterEnabled(true);
            phonenumber.getEditText().requestFocus();
            return false;
        } else if (!Patterns.PHONE.matcher(number).matches()) {
            phonenumber.setError("Invalid number!");
            phonenumber.setCounterEnabled(true);
            phonenumber.getEditText().requestFocus();
            return false;
        } else {
            phonenumber.setError(null);
            phonenumber.setCounterEnabled(false);
            phonenumber.setErrorEnabled(false);
            _phonenumber = number;
            return true;
        }
    }
}