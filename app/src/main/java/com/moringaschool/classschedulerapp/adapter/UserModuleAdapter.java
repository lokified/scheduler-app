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
import com.moringaschool.classschedulerapp.models.UserModuleResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserModuleAdapter extends RecyclerView.Adapter<UserModuleAdapter.UsermoduleViewHolder>  {


    List<UserModuleResponse> mUsermodules;
    Context mContext;

    public UserModuleAdapter(List<UserModuleResponse> mUsermodules, Context mContext) {
        this.mUsermodules = mUsermodules;
        this.mContext = mContext;
    }

    @Override
    public  UserModuleAdapter.UsermoduleViewHolder onCreateViewHolder(ViewGroup parent, int ViewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.usermodule_item,parent,false);
        UsermoduleViewHolder holder = new UsermoduleViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(UserModuleAdapter.UsermoduleViewHolder holder, int position){
        holder.bindUsermodule(mUsermodules.get(position));
    }

    @Override
    public int getItemCount() {
        return mUsermodules.size();
    }


    public class UsermoduleViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_username_item) TextView mUsername;
        @BindView(R.id.tv_userPosition_item) TextView mUserPosition;
        @BindView(R.id.tv_useremail_item) TextView mUserEmail;
//        @BindView(R.id.tv_useremodule_item) TextView mUserModule;

        private Context mContext;

        public UsermoduleViewHolder(@NonNull View itemView ) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            mContext = itemView.getContext();
        }

        public void bindUsermodule(UserModuleResponse usermodule){
            mUsername.setText(usermodule.getName());
            mUserPosition.setText(usermodule.getPosition());
            mUserEmail.setText(usermodule.getEmail());
//            mUserModule.setText(usermodule.getModuleId());
        }
    }


}
