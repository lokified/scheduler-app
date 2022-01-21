
package com.moringaschool.classschedulerapp.EventsResponseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
@SuppressWarnings("ALL")
public class ConferenceSolution {

    @SerializedName("key")
    @Expose
    private Key key;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("iconUri")
    @Expose
    private String iconUri;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ConferenceSolution() {
    }

    /**
     * 
     * @param name
     * @param key
     * @param iconUri
     */
    public ConferenceSolution(Key key, String name, String iconUri) {
        super();
        this.key = key;
        this.name = name;
        this.iconUri = iconUri;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconUri() {
        return iconUri;
    }

    public void setIconUri(String iconUri) {
        this.iconUri = iconUri;
    }

}
