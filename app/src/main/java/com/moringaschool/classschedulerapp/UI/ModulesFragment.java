package com.moringaschool.classschedulerapp.UI;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.moringaschool.classschedulerapp.R;
import com.moringaschool.classschedulerapp.SchedulesAPI;
import com.moringaschool.classschedulerapp.SchedulesClient;
import com.moringaschool.classschedulerapp.adapter.ModulesAdapter;
import com.moringaschool.classschedulerapp.adapter.SchedulesAdapter;
import com.moringaschool.classschedulerapp.models.ModuleResponse;
import com.moringaschool.classschedulerapp.models.SchedulerResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ModulesFragment extends Fragment implements View.OnClickListener{
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.recyclerViewModule) RecyclerView recyclerView;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.button_add_module) FloatingActionButton addModuleButton;
    @BindView(R.id.refreshLayoutModule) SwipeRefreshLayout mRefresh;

    public ModulesFragment() {
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
        View view = inflater.inflate(R.layout.fragment_modules, container, false);

        ButterKnife.bind(this, view);
        addModuleButton.setOnClickListener(this);

        getModule();

        mRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getModule();

                new Handler().postDelayed(new Runnable() {
                    @Override public void run() {
                        // Stop animation (This will be after 3 seconds)
                        mRefresh.setRefreshing(false);
                    }
                }, 2000);
            }
        });

        return view;
    }

    public void getModule() {
        SchedulesAPI client = SchedulesClient.getClient();

        Call<List<ModuleResponse>> call = client.getAllModules();

        call.enqueue(new Callback<List<ModuleResponse>>() {
            @Override
            public void onResponse(Call<List<ModuleResponse>> call, Response<List<ModuleResponse>> response) {

                List<ModuleResponse> moduleList = response.body();

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());

                recyclerView.setAdapter(new ModulesAdapter(moduleList, getContext()));
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(layoutManager);
            }

            @Override
            public void onFailure(Call<List<ModuleResponse>> call, Throwable t) {

                Toast.makeText(getActivity(), "something went wrong", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        if(view == addModuleButton){
            Intent intent = new Intent(getActivity(), AddModuleActivity.class);
            startActivity(intent);
        }
    }
}