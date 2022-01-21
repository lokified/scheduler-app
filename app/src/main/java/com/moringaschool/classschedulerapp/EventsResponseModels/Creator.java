
package com.moringaschool.classschedulerapp.EventsResponseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
@SuppressWarnings("ALL")
public class Creator {

    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("self")
    @Expose
    private boolean self;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Creator() {
    }

    /**
     * 
     * @param self
     * @param email
     */
    public Creator(String email, boolean self) {
        super();
        this.email = email;
        this.self = self;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isSelf() {
        return self;
    }

    public void setSelf(boolean self) {
        this.self = self;
    }

}
