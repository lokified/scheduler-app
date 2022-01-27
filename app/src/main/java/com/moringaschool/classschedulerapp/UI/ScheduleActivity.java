package com.moringaschool.classschedulerapp.UI;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.moringaschool.classschedulerapp.R;
import com.moringaschool.classschedulerapp.SchedulesAPI;
import com.moringaschool.classschedulerapp.SchedulesClient;
import com.moringaschool.classschedulerapp.models.SchedulesResponse;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScheduleActivity extends AppCompatActivity implements View.OnClickListener{
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.recyclerViewSchedule) RecyclerView recyclerView;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.button_add_note2) FloatingActionButton addNoteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        ButterKnife.bind(this);
        addNoteButton.setOnClickListener(this);

        SchedulesAPI client = SchedulesClient.getClient();
        Call<SchedulesResponse> call = client.getAllSessions();

        call.enqueue(new Callback<SchedulesResponse>() {
            @Override
            public void onResponse(Call<SchedulesResponse> call, Response<SchedulesResponse> response) {
                if (response.isSuccessful()) {
                    SchedulesResponse json = response.body();
                    Log.i("data",json.toString());

                }
            }

            @Override
            public void onFailure(Call<SchedulesResponse> call, Throwable t) {

            }

        });

    }

    @Override
    public void onClick(View view) {
        if(view == addNoteButton){
            Intent intent = new Intent(ScheduleActivity.this, AddScheduleActivity.class);
            startActivity(intent);
            Toast.makeText(this, "schedule activity", Toast.LENGTH_SHORT).show();
        }
    }
}