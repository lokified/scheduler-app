package com.moringaschool.classschedulerapp.UI;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
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


public class ScheduleFragment extends Fragment implements View.OnClickListener{
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.recyclerViewSchedule) RecyclerView recyclerView;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.button_add_note2) FloatingActionButton addNoteButton;
    private SchedulesAdapter schedulesAdapter;
//    @BindView(R.id.refreshLayout) SwipeRefreshLayout mRefresh;

    public ScheduleFragment() {
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
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);
        setHasOptionsMenu(true);

        ButterKnife.bind(this, view);
        addNoteButton.setOnClickListener(this);

        getSchedules();

//        mRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                getSchedules();
//
//                new Handler().postDelayed(new Runnable() {
//                    @Override public void run() {
//                        // Stop animation (This will be after 3 seconds)
//                        mRefresh.setRefreshing(false);
//                    }
//                }, 2000);
//            }
//        });

        return view;
    }


    public void getSchedules() {
        SchedulesAPI client = SchedulesClient.getClient();

        Call<List<SchedulerResponse>> call = client.getAllSessions();

        call.enqueue(new Callback<List<SchedulerResponse>>() {
            @Override
            public void onResponse(Call<List<SchedulerResponse>> call, Response<List<SchedulerResponse>> response) {

                List<SchedulerResponse> scheduleList = response.body();

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());

                schedulesAdapter = new SchedulesAdapter(scheduleList,getContext());

                recyclerView.setAdapter(schedulesAdapter);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(layoutManager);
            }

            @Override
            public void onFailure(Call<List<SchedulerResponse>> call, Throwable t) {

                Toast.makeText(getActivity(), "something went wrong", Toast.LENGTH_LONG).show();
            }
        });
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.search_menu, menu);
        MenuItem item = menu.findItem(R.id.search_session);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String userText) {
//                schedulesAdapter.getFilter().filter(userText);
                return false;
            }
        });
        super.onCreateOptionsMenu(menu,inflater);
    }

    @Override
    public void onClick(View view) {
        if(view == addNoteButton){
            Intent intent = new Intent(getActivity(), AddScheduleActivity.class);
            startActivity(intent);
        }
    }
}