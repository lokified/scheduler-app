package com.moringaschool.classschedulerapp.models;

public class Announcements {
    private int id;
    private String title;
    private int userId;
    private String description;

    public Announcements(String title, int userId, String description) {
        this.title = title;
        this.userId = userId;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Announcements that = (Announcements) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        if (!title.equals(that.title)) return false;
        return description.equals(that.description);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + title.hashCode();
        result = 31 * result + userId;
        result = 31 * result + description.hashCode();
        return result;
    }
}


