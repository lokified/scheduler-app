
package com.moringaschool.classschedulerapp.EventsResponseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
@SuppressWarnings("ALL")
public class Reminders {

    @SerializedName("useDefault")
    @Expose
    private boolean useDefault;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Reminders() {
    }

    /**
     * 
     * @param useDefault
     */
    public Reminders(boolean useDefault) {
        super();
        this.useDefault = useDefault;
    }

    public boolean isUseDefault() {
        return useDefault;
    }

    public void setUseDefault(boolean useDefault) {
        this.useDefault = useDefault;
    }

}
