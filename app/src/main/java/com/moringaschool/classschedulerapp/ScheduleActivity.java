package com.moringaschool.classschedulerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import butterknife.BindView;
import butterknife.ButterKnife;

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