package com.moringaschool.classschedulerapp.UI;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.moringaschool.classschedulerapp.R;
import com.moringaschool.classschedulerapp.SchedulesAPI;
import com.moringaschool.classschedulerapp.SchedulesClient;
import com.moringaschool.classschedulerapp.adapter.SchedulesAdapter;
import com.moringaschool.classschedulerapp.models.SchedulerResponse;

import java.util.List;

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

       Call<List<SchedulerResponse>> call = client.getAllSessions();

       call.enqueue(new Callback<List<SchedulerResponse>>() {
           @Override
           public void onResponse(Call<List<SchedulerResponse>> call, Response<List<SchedulerResponse>> response) {

               List<SchedulerResponse> scheduleList = response.body();

               RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ScheduleActivity.this);

               recyclerView.setAdapter(new SchedulesAdapter(scheduleList, getApplicationContext()));
               recyclerView.setHasFixedSize(true);
               recyclerView.setLayoutManager(layoutManager);
           }

           @Override
           public void onFailure(Call<List<SchedulerResponse>> call, Throwable t) {

               Toast.makeText(ScheduleActivity.this, "something went wrong", Toast.LENGTH_LONG).show();
           }
       });
    }

    @Override
    public void onClick(View view) {
        if(view == addNoteButton){
            Intent intent = new Intent(ScheduleActivity.this, AddScheduleActivity.class);
            startActivity(intent);
//            Toast.makeText(this, "schedule activity", Toast.LENGTH_SHORT).show();
        }
    }

    //inflate the search menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int id = menuItem.getItemId();

        if(id == R.id.action_logout) {
            logOut();
            Toast.makeText(this, "You are logged out", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(menuItem);
    }

    //logs out the user
    public void logOut() {
        FirebaseAuth.getInstance().signOut();

        Intent intent = new Intent(ScheduleActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}