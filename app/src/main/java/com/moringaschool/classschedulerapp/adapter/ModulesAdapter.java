package com.moringaschool.classschedulerapp.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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
import com.moringaschool.classschedulerapp.UI.AddUserToModuleActivity;
import com.moringaschool.classschedulerapp.UI.LandingActivity;
import com.moringaschool.classschedulerapp.UI.UserModuleFragment;
//import com.moringaschool.classschedulerapp.UI.UsermoduleActivity;
import com.moringaschool.classschedulerapp.UI.UsermoduleActivity;
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


    public class ModulesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.tv_title_module_item) TextView mTitleModule;
        private Context mContext;
        AlertDialog.Builder alertBuilder;

        public ModulesViewHolder(@NonNull View itemView ) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        public void bindModules(ModuleResponse module){
            mTitleModule.setText(module.getName());

            Log.d("name",module.getName());
        }

        @Override
        public void onClick(View view) {
            int itemPosition = getLayoutPosition();
            String moduleName = mModules.get(itemPosition).getName();
            int moduleid = mModules.get(itemPosition).getId();
            alertBuilder = new AlertDialog.Builder(mContext);

            alertBuilder.setTitle(moduleName).setMessage(moduleName + " Details")
                    .setCancelable(true)
                    .setPositiveButton("View Students", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(mContext, "students", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(mContext, UsermoduleActivity.class);
                            intent.putExtra("moduleid",String.valueOf(moduleid));
                            mContext.startActivity(intent);
                        }
                    })


                    .setNegativeButton("Add Students To Module", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(mContext, "modules", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(mContext, UsermoduleActivity.class);
                            intent.putExtra("moduleid",String.valueOf(moduleid));
                            intent.putExtra("moduleName",moduleName);

                            mContext.startActivity(intent);
                        }
                    }).show();

        }
    }

}
