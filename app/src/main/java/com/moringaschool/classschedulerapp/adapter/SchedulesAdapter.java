package com.moringaschool.classschedulerapp.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.classschedulerapp.R;
import com.moringaschool.classschedulerapp.models.SchedulerResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SchedulesAdapter extends RecyclerView.Adapter<SchedulesAdapter.SchedulesViewHolder>  {


    List<SchedulerResponse> mSchedules;
    Context mContext;

    public SchedulesAdapter(List<SchedulerResponse> mSchedules, Context mContext) {
        this.mSchedules = mSchedules;
        this.mContext = mContext;
    }

    @Override
    public  SchedulesAdapter.SchedulesViewHolder onCreateViewHolder(ViewGroup parent, int ViewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.schedule_item,parent,false);
        SchedulesViewHolder holder = new SchedulesViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(SchedulesAdapter.SchedulesViewHolder holder, int position){
        holder.bindSession(mSchedules.get(position));
    }

    @Override
    public int getItemCount() {
        return mSchedules.size();
    }


    public class SchedulesViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_title_schedule_item) TextView mTitleSchedule;
        @BindView(R.id.tv_description_schedule_item) TextView mDescriptionSchedule;
        @BindView(R.id.tv_start_time) TextView mStartTime;
        @BindView(R.id.tv_end_time) TextView mEndTime;

        private Context mContext;

        public SchedulesViewHolder(@NonNull View itemView ) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            mContext = itemView.getContext();
        }

        public void bindSession(SchedulerResponse session){
            mTitleSchedule.setText(session.getSessionName());
            mDescriptionSchedule.setText(session.getDescription());
            mStartTime.setText(session.getStartTime());
            mEndTime.setText(session.getEndTime());

            Log.d("name",session.getSessionName());
        }
    }


}
