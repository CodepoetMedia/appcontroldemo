package com.codepoetmedia.models;

public class AirConditionerVO {
    private Integer id;
    private String name;
    private AirConditionerStatus status;
    private Double temperature;

    // Getter for id
    public Integer getId() {
        return id;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for status
    public AirConditionerStatus getStatus() {
        return status;
    }

    // Getter for status
    public Double getTemperature() {
        return temperature;
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
    public void setStatus(AirConditionerStatus status) {
        this.status = status;
    }

    // Setter for temperature
    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public void setTemperature(String strTemperature) {
        try {
            Double parseTemperature = Double.parseDouble(strTemperature);
            if (temperature > 16.0 && temperature < 30.0) {
                // No changes
                this.temperature = parseTemperature;
            }
            setStatus(AirConditionerStatus.ON);
        } catch (NumberFormatException e) {
            setStatus(AirConditionerStatus.fromString(strTemperature));
        }
    }
}
