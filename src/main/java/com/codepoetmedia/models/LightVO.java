package com.codepoetmedia.models;

public class LightVO {
    private Integer id;
    private String name;
    private LightStatus status;

    // Getter for id
    public Integer getId() {
        return id;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for status
    public LightStatus getStatus() {
        return status;
    }

    // Setter for name
    public void setId(Integer id) {
        this.id = id;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Setter for status
    public void setStatus(LightStatus status) {
        this.status = status;
    }

}
