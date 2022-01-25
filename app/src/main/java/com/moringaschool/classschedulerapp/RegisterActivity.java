package com.moringaschool.classschedulerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.et_full_name) TextInputEditText editFullName;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.et_email) TextInputEditText editEmailAddress;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.et_password_sign_up) TextInputEditText editPassword1;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.et_confirm_password_sign_up) TextInputEditText editPassword2;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.btn_register) Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ButterKnife.bind(this);

        signUpButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if(view == signUpButton){
            Intent intent = new Intent(RegisterActivity.this, ScheduleActivity.class);
            startActivity(intent);
            Toast.makeText(this, "register", Toast.LENGTH_LONG).show();
        }
    }
}