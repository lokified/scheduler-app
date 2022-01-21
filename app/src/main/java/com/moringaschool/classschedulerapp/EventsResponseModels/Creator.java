
package com.moringaschool.classschedulerapp.EventsResponseModels;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
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
