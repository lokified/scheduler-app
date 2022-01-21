
package com.moringaschool.classschedulerapp.EventsResponseModels;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Item {

    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("etag")
    @Expose
    private String etag;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("htmlLink")
    @Expose
    private String htmlLink;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("updated")
    @Expose
    private String updated;
    @SerializedName("summary")
    @Expose
    private String summary;
    @SerializedName("creator")
    @Expose
    private Creator creator;
    @SerializedName("organizer")
    @Expose
    private Organizer organizer;
    @SerializedName("start")
    @Expose
    private Start start;
    @SerializedName("end")
    @Expose
    private End end;
    @SerializedName("iCalUID")
    @Expose
    private String iCalUID;
    @SerializedName("sequence")
    @Expose
    private long sequence;
    @SerializedName("attendees")
    @Expose
    private List<Attendee> attendees = null;
    @SerializedName("hangoutLink")
    @Expose
    private String hangoutLink;
    @SerializedName("conferenceData")
    @Expose
    private ConferenceData conferenceData;
    @SerializedName("reminders")
    @Expose
    private Reminders reminders;
    @SerializedName("eventType")
    @Expose
    private String eventType;
    @SerializedName("attachments")
    @Expose
    private List<Attachment> attachments = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Item() {
    }

    /**
     * 
     * @param summary
     * @param reminders
     * @param creator
     * @param attachments
     * @param kind
     * @param htmlLink
     * @param created
     * @param attendees
     * @param iCalUID
     * @param start
     * @param hangoutLink
     * @param eventType
     * @param sequence
     * @param organizer
     * @param conferenceData
     * @param etag
     * @param end
     * @param id
     * @param updated
     * @param status
     */
    public Item(String kind, String etag, String id, String status, String htmlLink, String created, String updated, String summary, Creator creator, Organizer organizer, Start start, End end, String iCalUID, long sequence, List<Attendee> attendees, String hangoutLink, ConferenceData conferenceData, Reminders reminders, String eventType, List<Attachment> attachments) {
        super();
        this.kind = kind;
        this.etag = etag;
        this.id = id;
        this.status = status;
        this.htmlLink = htmlLink;
        this.created = created;
        this.updated = updated;
        this.summary = summary;
        this.creator = creator;
        this.organizer = organizer;
        this.start = start;
        this.end = end;
        this.iCalUID = iCalUID;
        this.sequence = sequence;
        this.attendees = attendees;
        this.hangoutLink = hangoutLink;
        this.conferenceData = conferenceData;
        this.reminders = reminders;
        this.eventType = eventType;
        this.attachments = attachments;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHtmlLink() {
        return htmlLink;
    }

    public void setHtmlLink(String htmlLink) {
        this.htmlLink = htmlLink;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Creator getCreator() {
        return creator;
    }

    public void setCreator(Creator creator) {
        this.creator = creator;
    }

    public Organizer getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }

    public Start getStart() {
        return start;
    }

    public void setStart(Start start) {
        this.start = start;
    }

    public End getEnd() {
        return end;
    }

    public void setEnd(End end) {
        this.end = end;
    }

    public String getiCalUID() {
        return iCalUID;
    }

    public void setiCalUID(String iCalUID) {
        this.iCalUID = iCalUID;
    }

    public long getSequence() {
        return sequence;
    }

    public void setSequence(long sequence) {
        this.sequence = sequence;
    }

    public List<Attendee> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<Attendee> attendees) {
        this.attendees = attendees;
    }

    public String getHangoutLink() {
        return hangoutLink;
    }

    public void setHangoutLink(String hangoutLink) {
        this.hangoutLink = hangoutLink;
    }

    public ConferenceData getConferenceData() {
        return conferenceData;
    }

    public void setConferenceData(ConferenceData conferenceData) {
        this.conferenceData = conferenceData;
    }

    public Reminders getReminders() {
        return reminders;
    }

    public void setReminders(Reminders reminders) {
        this.reminders = reminders;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

}
