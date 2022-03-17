package com.one.cityguide.LoginAndSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.hbb20.CountryCodePicker;
import com.one.cityguide.R;

import org.w3c.dom.Text;

import java.util.Calendar;

public class RetailerSignup extends AppCompatActivity {

    TextView loginBtn;
    MaterialButton nextBtn;
    ImageView backBtn;
    TextInputLayout fullname, username, email, phonenumber, password;
    RadioGroup radioGroup;
    RadioButton selectedGender;
    DatePicker datePicker;
    String _fullname, _username, _email, _phonenumber, _password, _gender, _dob;
    Bundle bundle;
    CountryCodePicker countryCodePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retailer_signup);

        hooks();

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
                    intent.putExtra("type", "signup");
                    startActivity(intent);
                    finishAffinity();
            }
        });
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (datepickerValidate() & gendervalidate() & passwordValidator() & phonenumberValidator() & emailValidator() & usernameValidator() & fullnameValidator() ) {
                   addCountryCode();
                    Intent intent = new Intent(RetailerSignup.this, OTP_PinView.class);
                    intent.putExtra("type", false);
                    intent.putExtra("phonenumber", _phonenumber);
                    startActivity(intent);
                }
            }
        });
    }

    private void hooks() {
        nextBtn = findViewById(R.id.nextBtn_RetailerSignup);
        loginBtn = findViewById(R.id.loginBtn_RetailerSignup);
        backBtn = findViewById(R.id.backBtn_RetailerSignup);
        fullname = findViewById(R.id.fullNameInputlayout_RetailerSignup);
        username = findViewById(R.id.usernameInputlayout_RetailerSignup);
        email = findViewById(R.id.emailInputlayout_RetailerSignup);
        password = findViewById(R.id.passwordInputlayout_RetailerSignup);
        phonenumber = findViewById(R.id.phonenumberInputlayout_RetailerSignup);
        radioGroup = findViewById(R.id.radioGroup_RetailerSignup);
        datePicker = findViewById(R.id.datePicker_RetailerSignup);
        countryCodePicker = findViewById(R.id.countryCodePicker_RetailerSignup);
    }

    private void addCountryCode() {
        String _countrycode = countryCodePicker.getSelectedCountryCode();
        _phonenumber = "+" + _countrycode + _phonenumber;
    }

    private boolean fullnameValidator() {
        String name = fullname.getEditText().getText().toString().trim();

        if (name.isEmpty()) {
            fullname.setError("Field cannot be empty!");
            fullname.getEditText().requestFocus();
            return false;
        } else if(name.matches(".*[0-9].*")) {
            fullname.setError("Please enter valid name!");
            fullname.getEditText().requestFocus();
            return false;
        } else if(name.matches(".*[_.()$&@].*")) {
            fullname.setError("Please enter valid name!");
            fullname.getEditText().requestFocus();
            return false;
        } else {
            fullname.setError(null);
            fullname.setErrorEnabled(false);
            _fullname = name;
            return true;
        }
    }

    private boolean usernameValidator() {
        String name = username.getEditText().getText().toString().trim();

        if (name.isEmpty()) {
            username.setCounterEnabled(true);
            username.setError("Field cannot be empty!");
            username.getEditText().requestFocus();
            return false;
        } else if (name.length() > 15) {
            username.setCounterEnabled(true);
            username.setError("Username is too large!");
            username.getEditText().requestFocus();
            return false;
        } else if (name.contains(" ")) {
            username.setCounterEnabled(true);
            username.setError("No white spaces are allowed!");
            username.getEditText().requestFocus();
            return false;
        } else {
            username.setError(null);
            username.setErrorEnabled(false);
            username.setCounterEnabled(false);
            _username = name;
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

    private boolean emailValidator() {
        String mail = email.getEditText().getText().toString().trim();

        if (!Patterns.EMAIL_ADDRESS.matcher(mail).matches()) {
            email.setError("Invalid email!");
            email.getEditText().requestFocus();
            return false;
        } else {
            email.setError(null);
            email.setErrorEnabled(false);
            _email = mail;
            return true;
        }
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

    private boolean gendervalidate() {
        selectedGender = findViewById(radioGroup.getCheckedRadioButtonId());
        _gender = selectedGender.getText().toString();
        return true;
    }

    private boolean datepickerValidate() {
        int currentYEAR = Calendar.getInstance().get(Calendar.YEAR);
        int userAGE = datePicker.getYear();
        int isAgeValid = currentYEAR - userAGE;

        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();

        _dob = day + "/" + month + "/" + year;

        if(isAgeValid<14){
            Toast.makeText(this, "You are not eligible", Toast.LENGTH_SHORT).show();
            return false;
        }else{
            return true;
        }
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(RetailerSignup.this, RetailerLoginAndSignup.class));
        finishAffinity();
    }
}