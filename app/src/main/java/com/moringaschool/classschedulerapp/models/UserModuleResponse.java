
package com.moringaschool.classschedulerapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class UserModuleResponse {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("position")
    @Expose
    private String position;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("moduleId")
    @Expose
    private Integer moduleId;

    /**
     * No args constructor for use in serialization
     * 
     */
    public UserModuleResponse() {
    }

    /**
     * 
     * @param name
     * @param position
     * @param moduleId
     * @param email
     */
    public UserModuleResponse(String position, String email, String name, Integer moduleId) {
        super();
        this.position = position;
        this.email = email;
        this.name = name;
        this.moduleId = moduleId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

}
