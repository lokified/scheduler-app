package com.moringaschool.classschedulerapp.UI;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.moringaschool.classschedulerapp.Constants;
import com.moringaschool.classschedulerapp.R;
import com.moringaschool.classschedulerapp.SchedulesAPI;
import com.moringaschool.classschedulerapp.models.SchedulerResponse;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
                updateCalendar2();
            }

            private void updateCalendar() {
                String Format = "MM dd, yyyy";

                SimpleDateFormat sdf = new SimpleDateFormat(Format, Locale.US);
                editStartDate.setText(sdf.format(calendar.getTime()));
                editEndDate.setText(sdf.format(calendar.getTime()));
            }

            private void updateCalendar2() {
                String Format = "MM dd, yyyy";

                SimpleDateFormat sdf = new SimpleDateFormat(Format, Locale.US);
                editEndDate.setText(sdf.format(calendar.getTime()));
            }
        };


        if(view == addScheduleButton){
//            Jan 27, 2021 12:00:00 AM
            String title = editScheduleTitle.getText().toString();
            String description = editScheduleDescription.getText().toString();
            String link = editScheduleLocation.getText().toString();
            String startDate = editStartDate.getText().toString();
            String endDate = editEndDate.getText().toString();
            String startTime = startDate +" "+ editStartTime.getText().toString() + " AM";
            String endTime = endDate + " " + editEndTime.getText().toString();
            String type = editEndTime.getText().toString();

            Log.d("err",startTime  );

            postSession(title,link,startTime,endTime,description,type);


            Intent intent = new Intent(AddScheduleActivity.this, LandingActivity.class);
            startActivity(intent);
            //Toast.makeText(this, "successfully added", Toast.LENGTH_LONG).show();
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

    public void postSession(String sessionName, String invitationLink, String startTime, String endTime, String description, String type) {



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SchedulesAPI schedulesAPI = retrofit.create(SchedulesAPI.class);

        SchedulerResponse session = new SchedulerResponse( sessionName,  invitationLink,  startTime,  endTime,  description,  type);

        Call<SchedulerResponse> call = schedulesAPI.addSession(session);

        call.enqueue(new Callback<SchedulerResponse>() {
            @Override
            public void onResponse(Call<SchedulerResponse> call, Response<SchedulerResponse> response) {

                int response1 = response.code();
                Log.d("success", String.valueOf(response1));
                Toast.makeText(AddScheduleActivity.this, "posted", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<SchedulerResponse> call, Throwable t) {

                Toast.makeText(AddScheduleActivity.this, "something went wrong", Toast.LENGTH_LONG).show();
            }
        });
    }
}