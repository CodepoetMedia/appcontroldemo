package com.codepoetmedia.models;

public enum AirConditionerStatus {
    ON("ON"),
    OFF("OFF");

    private String status;

    public boolean isOn() {
        return this == ON;
    }

    AirConditionerStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public static AirConditionerStatus fromString(String status) {
        for (AirConditionerStatus acStatus : AirConditionerStatus.values()) {
            if (acStatus.getStatus().equals(status)) {
                return acStatus;
            }
        }
        return OFF; // Default to OFF if no match found
    }

}
