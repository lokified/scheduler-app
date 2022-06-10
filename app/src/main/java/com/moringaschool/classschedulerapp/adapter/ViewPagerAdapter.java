package com.moringaschool.classschedulerapp.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.moringaschool.classschedulerapp.UI.AnnouncementsListFragment;
import com.moringaschool.classschedulerapp.UI.ModulesFragment;
import com.moringaschool.classschedulerapp.UI.ScheduleFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm)
    {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position)
    {
        Fragment fragment = null;
        if (position == 0)
            fragment = new ModulesFragment();
        else if (position == 1)
            fragment = new ScheduleFragment();
        else if (position == 2)
            fragment = new AnnouncementsListFragment();

        return fragment;
    }

    @Override
    public int getCount()
    {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position)
    {
        String title = null;
        if (position == 0)
            title = "Modules";
        else if (position == 1)
            title = "Schedules";
        else if (position == 2)
            title = "Announcements";

        return title;
    }
}
