package com.moringaschool.classschedulerapp.UI;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.moringaschool.classschedulerapp.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

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

Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_schedule);
        ButterKnife.bind(this);

        addScheduleButton.setOnClickListener(this);
        editStartDate.setOnClickListener(this);
        editEndDate.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR,year);
                calendar.set(Calendar.MONTH,month);
                calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);

                updateCalendar();
            }

            private void updateCalendar() {
                String Format = "MM/dd/yy";

                SimpleDateFormat sdf = new SimpleDateFormat(Format, Locale.US);
                editStartDate.setText(sdf.format(calendar.getTime()));
            }
        };
        String scheduleTitle = editScheduleTitle.getText().toString();
        if(view == addScheduleButton){
            Intent intent = new Intent(AddScheduleActivity.this, ScheduleActivity.class);
            startActivity(intent);
            Toast.makeText(this, "successfully added", Toast.LENGTH_LONG).show();
        }
        if(view == editStartDate){
            new DatePickerDialog(AddScheduleActivity.this,date,calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
        }
        if(view == editEndDate){
            new DatePickerDialog(AddScheduleActivity.this,date,calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
        }
    }
}