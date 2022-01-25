package com.moringaschool.classschedulerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddAnnouncementActivity extends AppCompatActivity implements View.OnClickListener{
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.et_Add_Announcement_Title) EditText announcement_Title;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.et_Add_Announcement_Description) EditText announcement_description;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.btn_Add_Announcement_Login) Button btn_add_announcement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_announcement);

        ButterKnife.bind(this);

        btn_add_announcement.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view == btn_add_announcement){
            String title = announcement_Title.getText().toString();
            String description = announcement_description.getText().toString();

            Toast.makeText(this, title +"::"+ description, Toast.LENGTH_SHORT).show();
        }
    }
}