package com.moringaschool.classschedulerapp;

import com.moringaschool.classschedulerapp.models.SchedulesResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SchedulesAPI {
    @GET("/sessions")
    Call<SchedulesResponse> getAllSessions(
    );
}
