
package com.moringaschool.classschedulerapp.EventsResponseModels;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class ConferenceData {

    @SerializedName("entryPoints")
    @Expose
    private List<EntryPoint> entryPoints = null;
    @SerializedName("conferenceSolution")
    @Expose
    private ConferenceSolution conferenceSolution;
    @SerializedName("conferenceId")
    @Expose
    private String conferenceId;
    @SerializedName("signature")
    @Expose
    private String signature;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ConferenceData() {
    }

    /**
     * 
     * @param entryPoints
     * @param conferenceId
     * @param signature
     * @param conferenceSolution
     */
    public ConferenceData(List<EntryPoint> entryPoints, ConferenceSolution conferenceSolution, String conferenceId, String signature) {
        super();
        this.entryPoints = entryPoints;
        this.conferenceSolution = conferenceSolution;
        this.conferenceId = conferenceId;
        this.signature = signature;
    }

    public List<EntryPoint> getEntryPoints() {
        return entryPoints;
    }

    public void setEntryPoints(List<EntryPoint> entryPoints) {
        this.entryPoints = entryPoints;
    }

    public ConferenceSolution getConferenceSolution() {
        return conferenceSolution;
    }

    public void setConferenceSolution(ConferenceSolution conferenceSolution) {
        this.conferenceSolution = conferenceSolution;
    }

    public String getConferenceId() {
        return conferenceId;
    }

    public void setConferenceId(String conferenceId) {
        this.conferenceId = conferenceId;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

}
