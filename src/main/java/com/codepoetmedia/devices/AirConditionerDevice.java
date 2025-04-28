package com.codepoetmedia.devices;

public class AirConditionerDevice {
    private Integer id;
    private String name;
    private String status;
    private String temperature;

    public AirConditionerDevice(Integer id, String name, String status, String temperature) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.temperature = temperature;
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

    public String getTemperature() {
        return temperature;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }
}
