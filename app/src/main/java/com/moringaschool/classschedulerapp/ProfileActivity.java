package com.moringaschool.classschedulerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;

public class ProfileActivity extends AppCompatActivity {
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.iv_Add_Edit_Profile_Avatar) ImageView myPhoto;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.et_Add_Edit_Profile_First_Name) TextView myFirstName;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.et_Add_Edit_Profile_Last_Name) TextView myLastName;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.et_Add_Edit_Profile_Email_Value) TextView myEmail;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.tv_Add_Edit_Profile__Address_Value) TextView myAddress;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.tv__Add_Edit_Profile_Bio_Value) TextView myBio;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.ib__Add_Edit_Profile_Social_Links_LinkedIn) ImageButton myLinkedInUrl;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.ib_Add_Edit_Profile_Social_Links_Twitter) ImageButton myTwitterUrl;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.ib_Add_Edit_Profile_Social_Links_Facebook) ImageButton myFacebookUrl;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.ib_Add_Edit_Profile_Social_Links_Instagram) ImageButton myInstagramUrl;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.et_Add_Edit_Profile_Website) EditText myWebsiteUrl;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.et_Add_Edit_Profile_Phone_Number) EditText myPhoneNumber;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.tv_Add_Edit_Profile_DoB_Value) TextView myDateOfBirth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }
}