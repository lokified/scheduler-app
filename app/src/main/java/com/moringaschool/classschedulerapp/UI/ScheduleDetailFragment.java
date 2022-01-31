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

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ScheduleDetailFragment extends Fragment {

    @BindView(R.id.sessionNameLabel) TextView mSessionNameLabel;

    private List<SchedulerResponse> mSessions;
    private SchedulerResponse mSession;

    public ScheduleDetailFragment() {
        // Required empty public constructor
    }


    public static ScheduleDetailFragment newInstance(List<SchedulerResponse> session) {
        ScheduleDetailFragment fragment = new ScheduleDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("session", Parcels.wrap(session));

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSessions = Parcels.unwrap(getArguments().getParcelable("session"));


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_schedule_detail, container, false);
        ButterKnife.bind(this, view);

        //mSessionNameLabel.setText(mSession.getSessionName());


        return view;
    }
}