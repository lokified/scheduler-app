package com.moringaschool.classschedulerapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.classschedulerapp.R;
import com.moringaschool.classschedulerapp.UI.ScheduleDetailActivity;
import com.moringaschool.classschedulerapp.models.SchedulerResponse;

import org.parceler.Parcels;

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


    public class SchedulesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.tv_title_schedule_item) TextView mTitleSchedule;
        @BindView(R.id.tv_description_schedule_item) TextView mDescriptionSchedule;
        @BindView(R.id.tv_start_time) TextView mStartTime;
        @BindView(R.id.tv_end_time) TextView mEndTime;

        private Context mContext;

        public SchedulesViewHolder(@NonNull View itemView ) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            mContext = itemView.getContext();

            itemView.setOnClickListener(this);
        }

        public void bindSession(SchedulerResponse session){
            mTitleSchedule.setText(session.getSessionName());
            mDescriptionSchedule.setText(session.getDescription());
            mStartTime.setText(session.getStartTime());
            mEndTime.setText(session.getEndTime());

            Log.d("name",session.getSessionName());
        }

        @Override
        public void onClick(View  v) {

            int itemPosition = getLayoutPosition();

            Intent intent = new Intent(mContext, ScheduleDetailActivity.class);
            intent.putExtra("session", Parcels.wrap(mSchedules));
            intent.putExtra("position", itemPosition);
            mContext.startActivity(intent);

            String name = mSchedules.get(itemPosition).getSessionName();

            Toast.makeText(mContext, name, Toast.LENGTH_SHORT).show();
        }
    }


}
