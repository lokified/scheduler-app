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
import com.moringaschool.classschedulerapp.models.ModuleResponse;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddModuleActivity extends AppCompatActivity implements View.OnClickListener{
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.et_Add_Module_Title) EditText editModuleTitle;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.btn_Add_Module_Button) Button addModuleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_module);
        ButterKnife.bind(this);

        editModuleTitle.setOnClickListener(this);
        addModuleButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view == addModuleButton){
            String title = editModuleTitle.getText().toString();
            Log.d("err",title);

            postModule(title);

            Intent intent = new Intent(AddModuleActivity.this, AltLandingActivity.class);
            startActivity(intent);
        }

    }

    public void postModule(String name) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SchedulesAPI schedulesAPI = retrofit.create(SchedulesAPI.class);

        ModuleResponse module = new ModuleResponse(name);

        Call<ModuleResponse> call = schedulesAPI.addModule(module);

        call.enqueue(new Callback<ModuleResponse>() {
            @Override
            public void onResponse(Call<ModuleResponse> call, Response<ModuleResponse> response) {

                int response1 = response.code();
                Log.d("success", String.valueOf(response1));
                Toast.makeText(AddModuleActivity.this, "posted", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<ModuleResponse> call, Throwable t) {

                Toast.makeText(AddModuleActivity.this, "something went wrong", Toast.LENGTH_LONG).show();
            }
        });
    }
}