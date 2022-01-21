
package com.moringaschool.classschedulerapp.EventsResponseModels;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class EntryPoint {

    @SerializedName("entryPointType")
    @Expose
    private String entryPointType;
    @SerializedName("uri")
    @Expose
    private String uri;
    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("pin")
    @Expose
    private String pin;
    @SerializedName("regionCode")
    @Expose
    private String regionCode;

    /**
     * No args constructor for use in serialization
     * 
     */
    public EntryPoint() {
    }

    /**
     * 
     * @param regionCode
     * @param pin
     * @param entryPointType
     * @param label
     * @param uri
     */
    public EntryPoint(String entryPointType, String uri, String label, String pin, String regionCode) {
        super();
        this.entryPointType = entryPointType;
        this.uri = uri;
        this.label = label;
        this.pin = pin;
        this.regionCode = regionCode;
    }

    public String getEntryPointType() {
        return entryPointType;
    }

    public void setEntryPointType(String entryPointType) {
        this.entryPointType = entryPointType;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

}
