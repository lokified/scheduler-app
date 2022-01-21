
package com.moringaschool.classschedulerapp.EventsResponseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
@SuppressWarnings("ALL")
public class Key {

    @SerializedName("type")
    @Expose
    private String type;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Key() {
    }

    /**
     * 
     * @param type
     */
    public Key(String type) {
        super();
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
