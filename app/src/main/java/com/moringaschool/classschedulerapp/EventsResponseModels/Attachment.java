
package com.moringaschool.classschedulerapp.EventsResponseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
@SuppressWarnings("ALL")
public class Attachment {

    @SerializedName("fileUrl")
    @Expose
    private String fileUrl;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("mimeType")
    @Expose
    private String mimeType;
    @SerializedName("iconLink")
    @Expose
    private String iconLink;
    @SerializedName("fileId")
    @Expose
    private String fileId;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Attachment() {
    }

    /**
     * 
     * @param iconLink
     * @param fileUrl
     * @param mimeType
     * @param title
     * @param fileId
     */
    public Attachment(String fileUrl, String title, String mimeType, String iconLink, String fileId) {
        super();
        this.fileUrl = fileUrl;
        this.title = title;
        this.mimeType = mimeType;
        this.iconLink = iconLink;
        this.fileId = fileId;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getIconLink() {
        return iconLink;
    }

    public void setIconLink(String iconLink) {
        this.iconLink = iconLink;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

}
