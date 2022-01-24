package com.moringaschool.classschedulerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddEditProfileActivity extends AppCompatActivity implements View.OnClickListener {
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.iv_Add_Edit_Profile_Avatar) ImageView userPhoto;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.et_Add_Edit_Profile_First_Name) EditText editFirstName;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.et_Add_Edit_Profile_Last_Name) EditText editLastName;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.et_Add_Edit_Profile_Email_Value) EditText editEmail;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.tv_Add_Edit_Profile__Address_Value) EditText editAddress;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.tv__Add_Edit_Profile_Bio_Value) EditText editBio;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.ib__Add_Edit_Profile_Social_Links_LinkedIn) ImageButton editLinkedInUrl;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.ib_Add_Edit_Profile_Social_Links_Twitter) ImageButton editTwitterUrl;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.ib_Add_Edit_Profile_Social_Links_Facebook) ImageButton editFacebookUrl;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.ib_Add_Edit_Profile_Social_Links_Instagram) ImageButton editInstagramUrl;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.et_Add_Edit_Profile_Website) EditText editWebsiteUrl;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.et_Add_Edit_Profile_Phone_Number) EditText editPhoneNumber;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.tv_Add_Edit_Profile_DoB_Value) EditText editDateOfBirth;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.submitButton) Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_profile);
        ButterKnife.bind(this);
        submitButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String firstName = editFirstName.getText().toString();
        if(view == submitButton){
            Toast.makeText(this, firstName, Toast.LENGTH_SHORT).show();
        }
    }
}