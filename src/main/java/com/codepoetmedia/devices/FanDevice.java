package com.codepoetmedia.devices;

public class FanDevice {
    private Integer id;
    private String name;
    private String speed;

    public FanDevice(Integer id, String name, String speed) {
        this.id = id;
        this.name = name;
        this.speed = speed;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpeed() {
        return speed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }
}
