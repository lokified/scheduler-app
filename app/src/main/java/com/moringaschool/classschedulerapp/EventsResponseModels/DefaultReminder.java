
package com.moringaschool.classschedulerapp.EventsResponseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
@SuppressWarnings("ALL")
public class DefaultReminder {

    @SerializedName("method")
    @Expose
    private String method;
    @SerializedName("minutes")
    @Expose
    private long minutes;

    /**
     * No args constructor for use in serialization
     * 
     */
    public DefaultReminder() {
    }

    /**
     * 
     * @param method
     * @param minutes
     */
    public DefaultReminder(String method, long minutes) {
        super();
        this.method = method;
        this.minutes = minutes;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public long getMinutes() {
        return minutes;
    }

    public void setMinutes(long minutes) {
        this.minutes = minutes;
    }

}
