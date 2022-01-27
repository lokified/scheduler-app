package com.moringaschool.classschedulerapp.models;

import java.sql.Timestamp;
import java.util.Objects;

public class Session {
    private int id;
    private String sessionName;
    private String invitationLink;
    private Timestamp startTime;
    private Timestamp endTime;
    private String description;

    private String type;

    public Session(String sessionName, String invitationLink, String startTime, String endTime, String description, String type) {
        this.sessionName = sessionName;
        this.invitationLink = invitationLink;
        this.startTime = convertStringToTimestamp(startTime);
        this.endTime  = convertStringToTimestamp(endTime);
        this.description = description;
        this.type = type;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInvitationLink() {
        return invitationLink;
    }
    public Timestamp convertStringToTimestamp(String dateString){
        return Timestamp.valueOf(dateString);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Session session = (Session) o;
        return id == session.id && sessionName.equals(session.sessionName) && invitationLink.equals(session.invitationLink) && startTime.equals(session.startTime) && endTime.equals(session.endTime) && description.equals(session.description) && type.equals(session.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sessionName, invitationLink, startTime, endTime, description, type);
    }

    public void setInvitationLink(String invitationLink) {
        this.invitationLink = invitationLink;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
