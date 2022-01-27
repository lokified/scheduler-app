
package com.moringaschool.classschedulerapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.io.Serializable;

@Parcel
public class SchedulesResponse implements Serializable
{

    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("sessionName")
    @Expose
    private String sessionName;
    @SerializedName("invitationLink")
    @Expose
    private String invitationLink;
    @SerializedName("startTime")
    @Expose
    private String startTime;
    @SerializedName("endTime")
    @Expose
    private String endTime;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("type")
    @Expose
    private String type;
    private final static long serialVersionUID = -368631637724158390L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public SchedulesResponse() {
    }

    /**
     * 
     * @param sessionName
     * @param description
     * @param startTime
     * @param id
     * @param endTime
     * @param type
     * @param invitationLink
     */
    public SchedulesResponse(Long id, String sessionName, String invitationLink, String startTime, String endTime, String description, String type) {
        super();
        this.id = id;
        this.sessionName = sessionName;
        this.invitationLink = invitationLink;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public String getInvitationLink() {
        return invitationLink;
    }

    public void setInvitationLink(String invitationLink) {
        this.invitationLink = invitationLink;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
