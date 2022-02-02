package com.moringaschool.classschedulerapp.UI;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.moringaschool.classschedulerapp.Constants;
import com.moringaschool.classschedulerapp.R;
import com.moringaschool.classschedulerapp.SchedulesAPI;
import com.moringaschool.classschedulerapp.models.Announcement;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddAnnouncementActivity extends AppCompatActivity implements View.OnClickListener{
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.et_Add_Announcement_Title) EditText announcement_Title;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.et_Add_Announcement_Description) EditText announcement_description;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.btn_Add_Announcement_Login) Button btn_add_announcement;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_announcement);

        ButterKnife.bind(this);

        btn_add_announcement.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view == btn_add_announcement){
            String title = announcement_Title.getText().toString();
            String description = announcement_description.getText().toString();

            postAnnouncement(title,1,description);

            Intent intent = new Intent(AddAnnouncementActivity.this, AltLandingActivity.class);
            startActivity(intent);
            finish();
        }
    }

    public void postAnnouncement(String title, int userId, String description) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SchedulesAPI schedulesAPI = retrofit.create(SchedulesAPI.class);

        Announcement announcement = new Announcement( title,  userId,  description);

        Call<Announcement> call = schedulesAPI.addAnnouncement(announcement);

        call.enqueue(new Callback<Announcement>() {
            @Override
            public void onResponse(Call<Announcement> call, Response<Announcement> response) {

            }

            @Override
            public void onFailure(Call<Announcement> call, Throwable t) {

                Toast.makeText(AddAnnouncementActivity.this, "something went wrong", Toast.LENGTH_LONG).show();
            }
        });
    }
}