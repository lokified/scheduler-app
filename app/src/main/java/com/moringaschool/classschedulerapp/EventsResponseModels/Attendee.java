
package com.moringaschool.classschedulerapp.EventsResponseModels;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Attendee {

    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("responseStatus")
    @Expose
    private String responseStatus;
    @SerializedName("organizer")
    @Expose
    private boolean organizer;
    @SerializedName("self")
    @Expose
    private boolean self;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Attendee() {
    }

    /**
     * 
     * @param organizer
     * @param self
     * @param responseStatus
     * @param email
     */
    public Attendee(String email, String responseStatus, boolean organizer, boolean self) {
        super();
        this.email = email;
        this.responseStatus = responseStatus;
        this.organizer = organizer;
        this.self = self;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }

    public boolean isOrganizer() {
        return organizer;
    }

    public void setOrganizer(boolean organizer) {
        this.organizer = organizer;
    }

    public boolean isSelf() {
        return self;
    }

    public void setSelf(boolean self) {
        this.self = self;
    }

}
