package com.moringaschool.classschedulerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddScheduleActivity extends AppCompatActivity implements View.OnClickListener{
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.et_Add_Schedule_Title) EditText editScheduleTitle;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.et_Add_Schedule_Location) EditText editScheduleLocation;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.et_Add_Schedule_Description) EditText editScheduleDescription;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.et_Add_Schedule_Start_Date) EditText editStartDate;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.et_Add_Schedule_Start_Time) EditText editStartTime;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.et_Add_Schedule_Finish_Date) EditText editEndDate;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.et_Add_Schedule_Finish_Time) EditText editEndTime;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.btn_Add_Schedule_Login) Button addScheduleButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_schedule);
        ButterKnife.bind(this);

        addScheduleButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String scheduleTitle = editScheduleTitle.getText().toString();
        if(view == addScheduleButton){
            Intent intent = new Intent(AddScheduleActivity.this, ScheduleActivity.class);
            startActivity(intent);
            Toast.makeText(this, "successfully added", Toast.LENGTH_LONG).show();
        }
    }
}