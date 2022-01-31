package com.moringaschool.classschedulerapp;

import android.se.omapi.Session;

import com.moringaschool.classschedulerapp.models.Announcement;
import com.moringaschool.classschedulerapp.models.ModuleResponse;
import com.moringaschool.classschedulerapp.models.SchedulerResponse;
import com.moringaschool.classschedulerapp.models.UserModuleResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface SchedulesAPI {
    @POST("/sessions/new")
    Call<SchedulerResponse> addSession(@Body SchedulerResponse session);

    @GET("/sessions")
    Call<List<SchedulerResponse>> getAllSessions();

    @POST("/announcements/new")
    Call<Announcement> addAnnouncement(@Body Announcement announcement);

    @GET("/announcements")
    Call<List<Announcement>> getAllAnnouncements();

    @POST("/modules/new")
    Call<ModuleResponse> addModule(@Body ModuleResponse module);

    @GET("/modules")
    Call<List<ModuleResponse>> getAllModules();

    @POST("/user/:userId/modules/:moduleId")
    Call<UserModuleResponse> addUserModule(@Body UserModuleResponse usermodule);

    @GET("userModule/:userId")
    Call<List<UserModuleResponse>> getModuleByUser();

}
