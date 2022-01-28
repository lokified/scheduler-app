package com.moringaschool.classschedulerapp.UI;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.moringaschool.classschedulerapp.R;
import com.moringaschool.classschedulerapp.SchedulesAPI;
import com.moringaschool.classschedulerapp.SchedulesClient;
import com.moringaschool.classschedulerapp.adapter.AnnouncementAdapter;
import com.moringaschool.classschedulerapp.adapter.SchedulesAdapter;
import com.moringaschool.classschedulerapp.models.Announcement;
import com.moringaschool.classschedulerapp.models.SchedulerResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnnouncementsListFragment extends Fragment implements View.OnClickListener {

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.recyclerView2) RecyclerView mRecyclerView;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.add_announcement) FloatingActionButton mAddAnnouncement;

    public AnnouncementsListFragment() {
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

        mAddAnnouncement.setOnClickListener(this);

        SchedulesAPI client = SchedulesClient.getClient();

        Call<List<Announcement>> call = client.getAllAnnouncements();

        call.enqueue(new Callback<List<Announcement>>() {
            @Override
            public void onResponse(Call<List<Announcement>> call, Response<List<Announcement>> response) {

                List<Announcement> announcementList = response.body();

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());

                mRecyclerView.setAdapter(new AnnouncementAdapter(announcementList, getContext()));
                mRecyclerView.setHasFixedSize(true);
                mRecyclerView.setLayoutManager(layoutManager);
            }

            @Override
            public void onFailure(Call<List<Announcement>> call, Throwable t) {

                Toast.makeText(getActivity(), "something went wrong", Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }

    @Override
    public void onClick(View view) {
        if(view == mAddAnnouncement){
            Intent intent = new Intent(getActivity(), AddAnnouncementActivity.class);
            startActivity(intent);

        }
    }
}