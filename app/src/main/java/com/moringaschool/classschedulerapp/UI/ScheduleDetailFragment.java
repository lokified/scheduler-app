package com.moringaschool.classschedulerapp.UI;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.moringaschool.classschedulerapp.R;
import com.moringaschool.classschedulerapp.models.SchedulerResponse;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ScheduleDetailFragment extends Fragment {

    @BindView(R.id.tv_Schedule_Detail_Start_Time) TextView tv_Schedule_Detail_Start_Time;
    @BindView(R.id.tv_Schedule_Detail_Finish_Time) TextView tv_Schedule_Detail_Finish_Time;
    @BindView(R.id.tv_Schedule_Detail_Location) TextView tv_Schedule_Detail_Location;
    @BindView(R.id.tv_Schedule_Detail_Description) TextView tv_Schedule_Detail_Description;

    private SchedulerResponse mSession;


    public ScheduleDetailFragment() {
        // Required empty public constructor
    }


    public static ScheduleDetailFragment newInstance(SchedulerResponse session) {
        ScheduleDetailFragment fragment = new ScheduleDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("session", Parcels.wrap(session));

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSession = Parcels.unwrap(getArguments().getParcelable("session"));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_schedule_detail, container, false);
        ButterKnife.bind(this, view);

        tv_Schedule_Detail_Start_Time.setText(mSession.getStartTime());
        tv_Schedule_Detail_Finish_Time.setText(mSession.getEndTime());
        tv_Schedule_Detail_Location.setText(mSession.getInvitationLink());
        tv_Schedule_Detail_Description.setText(mSession.getDescription());

        return view;
    }
}