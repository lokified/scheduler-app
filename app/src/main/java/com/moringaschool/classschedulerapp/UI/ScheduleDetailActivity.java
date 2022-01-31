package com.moringaschool.classschedulerapp.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Parcel;

import com.moringaschool.classschedulerapp.R;
import com.moringaschool.classschedulerapp.adapter.DetailViewPager;
import com.moringaschool.classschedulerapp.models.ModuleResponse;
import com.moringaschool.classschedulerapp.models.SchedulerResponse;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ScheduleDetailActivity extends AppCompatActivity {

    @BindView(R.id.viewPagerDetail) ViewPager mViewDetail;

    private DetailViewPager mAdapter;
    private List<SchedulerResponse> mSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_detail);

        ButterKnife.bind(this);

        mSession = Parcels.unwrap(getIntent().getParcelableExtra("session"));
        int startingPosition = getIntent().getIntExtra("position",0);

        mAdapter = new DetailViewPager(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,mSession);
        mViewDetail.setAdapter(mAdapter);
        mViewDetail.setCurrentItem(startingPosition);
    }
}