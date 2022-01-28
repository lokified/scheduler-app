
package com.moringaschool.classschedulerapp.models;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModuleResponse {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ModuleResponse() {
    }

    /**
     * 
     * @param name
     */
    public ModuleResponse(String name) {
        super();
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
