package com.moringaschool.classschedulerapp;

import com.moringaschool.classschedulerapp.models.SchedulerResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SchedulesAPI {
    @GET("/sessions")
    Call<List<SchedulerResponse>> getAllSessions();
}
