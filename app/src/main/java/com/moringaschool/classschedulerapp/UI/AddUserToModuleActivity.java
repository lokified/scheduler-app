package com.moringaschool.classschedulerapp.UI;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.moringaschool.classschedulerapp.Constants;
import com.moringaschool.classschedulerapp.R;
import com.moringaschool.classschedulerapp.SchedulesAPI;
import com.moringaschool.classschedulerapp.models.ModuleResponse;
import com.moringaschool.classschedulerapp.models.SchedulerResponse;
import com.moringaschool.classschedulerapp.models.UserModuleResponse;

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

public class AddUserToModuleActivity extends AppCompatActivity implements View.OnClickListener{
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.et_Name) EditText editUserName;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.et_Email) EditText editUserEmail;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.et_Position) EditText editUserPosition;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.et_ModuleId) EditText editUserModuleId;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.btn_Add_UserModule) Button addUserModuleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_user_to_module);
        ButterKnife.bind(this);

        editUserName.setOnClickListener(this);
        editUserEmail.setOnClickListener(this);
        editUserPosition.setOnClickListener(this);
        editUserModuleId.setOnClickListener(this);
        addUserModuleButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view == addUserModuleButton){
            String name = editUserName.getText().toString();
            String email = editUserEmail.getText().toString();
            String position = editUserPosition.getText().toString();
            int moduleId = editUserModuleId.getId();

            postUserModule(name,email,position,moduleId);

            Intent intent = new Intent(AddUserToModuleActivity.this, LandingActivity.class);
            startActivity(intent);
        }

    }

    public void postUserModule(String name,String email, String position,int moduleId) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SchedulesAPI schedulesAPI = retrofit.create(SchedulesAPI.class);

        UserModuleResponse usermodule = new UserModuleResponse(name,email,position,moduleId);

        Call<UserModuleResponse> call = schedulesAPI.addUserModule(usermodule);

        call.enqueue(new Callback<UserModuleResponse>() {
            @Override
            public void onResponse(Call<UserModuleResponse> call, Response<UserModuleResponse> response) {

                int response1 = response.code();
                Log.d("success", String.valueOf(response1));
                Toast.makeText(AddUserToModuleActivity.this, "Added", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<UserModuleResponse> call, Throwable t) {

                Toast.makeText(AddUserToModuleActivity.this, "something went wrong", Toast.LENGTH_LONG).show();
            }
        });
    }
}