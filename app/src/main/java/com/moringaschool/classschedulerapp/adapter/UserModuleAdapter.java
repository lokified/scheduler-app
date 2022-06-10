package com.moringaschool.classschedulerapp.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.classschedulerapp.R;
import com.moringaschool.classschedulerapp.models.SchedulerResponse;
import com.moringaschool.classschedulerapp.models.UserModuleResponse;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserModuleAdapter extends RecyclerView.Adapter<UserModuleAdapter.UsermoduleViewHolder>  {


    List<UserModuleResponse> mUsermodules;
    List<Integer> userids = new ArrayList<>();
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


    public class UsermoduleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.tv_username_item) TextView mUsername;
        @BindView(R.id.tv_userPosition_item) TextView mUserPosition;
        @BindView(R.id.tv_useremail_item) TextView mUserEmail;

        private Context mContext;

        public UsermoduleViewHolder(@NonNull View itemView ) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        public void bindUsermodule(UserModuleResponse usermodule){
            mUsername.setText(usermodule.getName());
            mUserPosition.setText(usermodule.getPosition());
            mUserEmail.setText(usermodule.getEmail());
//            mUserModule.setText(usermodule.getModuleId());
        }

        @Override
        public void onClick(View v) {
            int i= getLayoutPosition();
            int id = mUsermodules.get(i).getId();
            if(userids.contains(id)){
                Toast.makeText(mContext,"Added to array", Toast.LENGTH_SHORT).show();

            }else {
                userids.add(id);
                Toast.makeText(mContext, String.valueOf(id), Toast.LENGTH_SHORT).show();
            }

        }
    }


}
