package com.moringaschool.classschedulerapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.classschedulerapp.R;
import com.moringaschool.classschedulerapp.models.Announcement;

import org.w3c.dom.Text;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AnnouncementAdapter extends RecyclerView.Adapter<AnnouncementAdapter.AnnouncementViewHolder> {

    List<Announcement> mAnnouncement;
    Context mContext;

    public AnnouncementAdapter(List<Announcement> mAnnouncement, Context mContext) {
        this.mAnnouncement = mAnnouncement;
        this.mContext = mContext;
    }

    @Override
    public  AnnouncementAdapter.AnnouncementViewHolder onCreateViewHolder(ViewGroup parent, int ViewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.announcement_item,parent,false);
        AnnouncementAdapter.AnnouncementViewHolder holder = new AnnouncementViewHolder(view);

        return holder;
    }
    @Override
    public void onBindViewHolder(AnnouncementAdapter.AnnouncementViewHolder holder, int position){
        holder.bindAnnouncement(mAnnouncement.get(position));
    }

    @Override
    public int getItemCount() {
        return mAnnouncement.size();
    }

    public class AnnouncementViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_Title_Announcement_Item) TextView mAnnouncementTitle;
        @BindView(R.id.tv_Description_Announcement_Item) TextView mAnnouncementDescription;

        private Context mContext;

        public AnnouncementViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindAnnouncement(Announcement announcement) {
            mAnnouncementTitle.setText(announcement.getTitle());
            mAnnouncementDescription.setText(announcement.getDescription());
        }
    }
}
