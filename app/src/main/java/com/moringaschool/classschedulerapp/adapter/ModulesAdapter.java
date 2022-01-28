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
import com.moringaschool.classschedulerapp.models.ModuleResponse;
import com.moringaschool.classschedulerapp.models.SchedulerResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ModulesAdapter extends RecyclerView.Adapter<ModulesAdapter.ModulesViewHolder>  {


    List<ModuleResponse> mModules;
    Context mContext;

    public ModulesAdapter(List<ModuleResponse> mModules, Context mContext) {
        this.mModules = mModules;
        this.mContext = mContext;
    }

    @Override
    public  ModulesAdapter.ModulesViewHolder onCreateViewHolder(ViewGroup parent, int ViewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.module_item,parent,false);
        ModulesViewHolder holder = new ModulesViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ModulesAdapter.ModulesViewHolder holder, int position){
        holder.bindModules(mModules.get(position));
    }

    @Override
    public int getItemCount() {
        return mModules.size();
    }


    public class ModulesViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_title_module_item) TextView mTitleModule;
        private Context mContext;

        public ModulesViewHolder(@NonNull View itemView ) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            mContext = itemView.getContext();
        }

        public void bindModules(ModuleResponse module){
            mTitleModule.setText(module.getName());

            Log.d("name",module.getName());
        }
    }


}
