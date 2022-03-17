package com.one.cityguide.LoginAndSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.hbb20.CountryCodePicker;
import com.one.cityguide.R;
import com.one.cityguide.User.UserDashboard;

public class RetailerLogin extends AppCompatActivity {

    TextView createAccountBtn;
    ImageView backBtn;
    MaterialButton forgotPasswordBtn, loginBtn;
    TextInputLayout phonenumber, password;
    String _phonenumber, _password;
    CountryCodePicker countryCodePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retailer_login);

        Bundle bundle = getIntent().getExtras();
        String type = bundle.getString("type");

        hooks();

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(passwordValidator() & phonenumberValidator()) {
                   addCountryCode();
                   Intent intent = new Intent(RetailerLogin.this, OTP_PinView.class);
                   intent.putExtra("phonenumber", _phonenumber);
                   startActivity(intent);
                }
            }
        });
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
        forgotPasswordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RetailerLogin.this, Forgot_Password.class));
            }
        });
        createAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RetailerLogin.this, RetailerSignup.class));
                finish();
            }
        });
    }

    private void hooks() {
        backBtn = findViewById(R.id.backBtn_RetailerLogin);
        createAccountBtn = findViewById(R.id.createAccountBtn_RetailerLogin);
        forgotPasswordBtn = findViewById(R.id.forgotPasswordBtn_RetailerLogin);
        phonenumber = findViewById(R.id.phonenumberInputlayout_RetailerLogin);
        password = findViewById(R.id.passwordInputlayout_RetailerLogin);
        loginBtn = findViewById(R.id.loginBtn_RetailerLogin);
        countryCodePicker = findViewById(R.id.countryCodePicker_RetailerLogin);
    }

    private void addCountryCode() {
        String  _countrycode = countryCodePicker.getSelectedCountryCode();
        _phonenumber = "+" + _countrycode + _phonenumber;
    }

    private boolean phonenumberValidator() {
        String number = phonenumber.getEditText().getText().toString().trim();

        if(number.length()<10){
            phonenumber.setError("Too small!");
            phonenumber.setCounterEnabled(true);
            phonenumber.getEditText().requestFocus();
            return false;
        }else if(number.length()>10){
            phonenumber.setError("Too large!");
            phonenumber.setCounterEnabled(true);
            phonenumber.getEditText().requestFocus();
            return false;
        }else if (!Patterns.PHONE.matcher(number).matches()) {
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

    private boolean passwordValidator() {
        String pass = password.getEditText().getText().toString().trim();

        if (pass.isEmpty()) {
            password.setError("Field cannot be empty!");
            password.getEditText().requestFocus();
            return false;
        } else if (pass.contains(" ")) {
            password.setError("No white spaces are allowed!");
            password.getEditText().requestFocus();
            return false;
        } else if(!pass.matches(".*[0-9].*")) {
            password.setError("At least one digit!");
            password.getEditText().requestFocus();
            return false;
        } else if (!pass.matches(".*[a-z].*")) {
            password.setError("At least one lowercase!");
            password.getEditText().requestFocus();
            return false;
        } else if (!pass.matches(".*[A-Z].*")) {
            password.setError("At least one uppercase!");
            password.getEditText().requestFocus();
            return false;
        } else if (!pass.matches(".*[_.()$&@].*")) {
            password.setError("At least one special character!");
            password.getEditText().requestFocus();
            return false;
        } else {
            password.setError(null);
            password.setErrorEnabled(false);
            _password = pass;
            return true;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
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