package com.moringaschool.classschedulerapp.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import com.moringaschool.classschedulerapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AltLandingActivity extends AppCompatActivity {
    @BindView(R.id.toolbar) Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alt_landing);
        ButterKnife.bind(this);

        //use custom toolbar as actionbar
        setSupportActionBar(toolbar);

    }
}