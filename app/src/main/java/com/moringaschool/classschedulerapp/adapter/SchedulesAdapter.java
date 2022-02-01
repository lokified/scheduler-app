package com.moringaschool.classschedulerapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.classschedulerapp.R;
import com.moringaschool.classschedulerapp.UI.ScheduleDetailActivity;
import com.moringaschool.classschedulerapp.models.SchedulerResponse;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SchedulesAdapter extends RecyclerView.Adapter<SchedulesAdapter.SchedulesViewHolder>  implements Filterable {


    private static List <SchedulerResponse> mSchedules;
    private static List<SchedulerResponse> UnFilteredSchedules;
    Context mContext;

    public SchedulesAdapter(List<SchedulerResponse> schedules, Context mContext) {
        mSchedules = schedules;
        UnFilteredSchedules = new ArrayList<>(mSchedules);
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

    @Override
    public Filter getFilter() {
        return FilteredSessions;
    }
    private final Filter FilteredSessions = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<SchedulerResponse> FilteredSessions = new ArrayList<>();
            if (charSequence == null || charSequence.length() == 0 ){
                FilteredSessions.addAll(UnFilteredSchedules);
            }
            else{
                String userSearchString = charSequence.toString().toLowerCase().trim();
                for(SchedulerResponse oneSession : UnFilteredSchedules){
                    if(oneSession.getSessionName().toLowerCase().contains(userSearchString)){
                        FilteredSessions.add(oneSession);
                    }
                }

            }
            FilterResults matchedsessions = new FilterResults();
            matchedsessions.values = FilteredSessions;
            return matchedsessions;
        }

        @SuppressLint("NotifyDataSetChanged")
        @Override
        protected void publishResults(CharSequence charSequence, FilterResults matchedVideos) {
            mSchedules.clear();
            mSchedules.addAll((List)matchedVideos.values);
            notifyDataSetChanged();
        }
    };


    public static class SchedulesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @SuppressLint("NonConstantResourceId")
        @BindView(R.id.tv_title_schedule_item) TextView mTitleSchedule;
        @SuppressLint("NonConstantResourceId")
        @BindView(R.id.tv_description_schedule_item) TextView mDescriptionSchedule;
        @SuppressLint("NonConstantResourceId")
        @BindView(R.id.tv_start_time) TextView mStartTime;
        @SuppressLint("NonConstantResourceId")
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
