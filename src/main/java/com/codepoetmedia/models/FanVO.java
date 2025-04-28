package com.codepoetmedia.models;

public class FanVO {
    private Integer id;
    private String name;
    private FanSpeed speed;

    // Getter for id
    public Integer getId() {
        return id;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for status
    public FanSpeed getSpeed() {
        return speed;
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
    public void setSpeed(FanSpeed speed) {
        this.speed = speed;
    }
}
