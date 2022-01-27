package com.moringaschool.classschedulerapp.UI;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.moringaschool.classschedulerapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AnnouncementsFragment extends Fragment implements View.OnClickListener {

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.recyclerView2) RecyclerView recyclerView;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.button_add_announcement) FloatingActionButton btn_add_announcement;

    public AnnouncementsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_announcements, container, false);

        ButterKnife.bind(this, view);

        btn_add_announcement.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        if(view == btn_add_announcement){
            Intent intent = new Intent(getActivity(), AddAnnouncementActivity.class);
            startActivity(intent);
            Toast.makeText(getActivity(), "add announcement", Toast.LENGTH_LONG).show();
        }
    }
}