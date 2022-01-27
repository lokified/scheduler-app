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

public class ScheduleActivity extends AppCompatActivity{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

    }

}