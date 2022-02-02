package com.moringaschool.classschedulerapp.UI;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.moringaschool.classschedulerapp.R;
import com.moringaschool.classschedulerapp.SchedulesAPI;
import com.moringaschool.classschedulerapp.SchedulesClient;
import com.moringaschool.classschedulerapp.adapter.ModulesAdapter;
import com.moringaschool.classschedulerapp.adapter.SchedulesAdapter;
import com.moringaschool.classschedulerapp.adapter.UserModuleAdapter;
import com.moringaschool.classschedulerapp.models.ModuleResponse;
import com.moringaschool.classschedulerapp.models.SchedulerResponse;
import com.moringaschool.classschedulerapp.models.UserModuleResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class UserModuleFragment extends Fragment{
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.recyclerViewUserModule) RecyclerView recyclerView;
    @BindView(R.id.errorUserModule) TextView errorUser;

    public UserModuleFragment() {
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
        View view = inflater.inflate(R.layout.fragment_user_module, container, false);

        ButterKnife.bind(this, view);

        String Item = getActivity().getIntent().getExtras().getString("moduleid");
        int id = Integer.parseInt(Item);

        SchedulesAPI client = SchedulesClient.getClient();

        Call<List<UserModuleResponse>> call = client.getModuleByUser(id);

        call.enqueue(new Callback<List<UserModuleResponse>>() {
            @Override
            public void onResponse(Call<List<UserModuleResponse>> call, Response<List<UserModuleResponse>> response) {
                List<UserModuleResponse> usermoduleList = response.body();

                Log.e("ronald", usermoduleList.get(0).getName());

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());

                recyclerView.setAdapter(new UserModuleAdapter(usermoduleList, getContext()));
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(layoutManager);
            }

            @Override
            public void onFailure(Call<List<UserModuleResponse>> call, Throwable t) {

                errorUser.setText("No users in the module");
                errorUser.setVisibility(View.VISIBLE);
            }
        });
        return view;
    }

}