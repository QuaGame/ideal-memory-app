package com.george.android.calendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.george.android.calendar.ui.MainActivity;
import com.george.android.calendar.ui.RegisterActivity;
import com.george.android.calendar.utils.TextValidator;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    TextInputLayout textEmail;
    TextInputLayout textPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnLogin = findViewById(R.id.loginButton);
        Button btnRegister = findViewById(R.id.toRegisterActivityButton);
        textEmail = findViewById(R.id.emailTextInputEditText);
        textPassword = findViewById(R.id.passwordTextInputEditText);

        btnLogin.setOnClickListener(v -> {

            String email = Objects.requireNonNull(textEmail.getEditText()).getText().toString();
            String password = Objects.requireNonNull(textEmail.getEditText()).getText().toString();

            if (!validateFields(email, password)){
                return;
            }

            Intent nameIntent = new Intent(this, MainActivity.class);
            startActivity(nameIntent);
        });

        btnRegister.setOnClickListener(v -> startActivity(new Intent(this, RegisterActivity.class)));
    }

    private boolean validateFields(String email, String password) {
        return TextValidator.validateText(email, textEmail) & TextValidator.validateText(password, textPassword);
    }

}