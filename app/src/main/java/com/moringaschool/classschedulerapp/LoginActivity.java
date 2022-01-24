package com.moringaschool.classschedulerapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.et_email) TextInputEditText editEmail;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.et_password) TextInputEditText editPassword;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.btn_login) Button loginButton;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.tv_sign_up_link) TextView signUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        loginButton.setOnClickListener(this);
        signUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String userEmail = Objects.requireNonNull(editEmail.getText()).toString();
        if(view == loginButton){
            Toast.makeText(this, userEmail, Toast.LENGTH_LONG).show();
        }
        if(view == signUp){
            Toast.makeText(this, "sign Up", Toast.LENGTH_LONG).show();
        }
    }
}