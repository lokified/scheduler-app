package com.moringaschool.classschedulerapp.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.moringaschool.classschedulerapp.UI.ScheduleDetailFragment;
import com.moringaschool.classschedulerapp.models.SchedulerResponse;

import java.util.List;

public class DetailViewPager extends FragmentPagerAdapter {
    private List<SchedulerResponse> mSession;


    public DetailViewPager(@NonNull FragmentManager fm, int behavior, List<SchedulerResponse> session) {
        super(fm,behavior);
        mSession = session;
    }

    @Override
    public Fragment getItem(int position) {
        return ScheduleDetailFragment.newInstance(mSession);
    }

    @Override
    public int getCount() {
        return mSession.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mSession.get(position).getSessionName();
    }
}
