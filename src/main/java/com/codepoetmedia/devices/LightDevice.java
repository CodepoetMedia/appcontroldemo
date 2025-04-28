package com.codepoetmedia.devices;

public class LightDevice {
    private Integer id;
    private String name;
    private String status;

    public LightDevice(Integer id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}