package com.codepoetmedia.models;

public enum LightStatus {
    ON("ON"),
    OFF("OFF");

    private String status;

    public boolean isOn() {
        return this == ON;
    }

    LightStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public static LightStatus fromString(String status) {
        for (LightStatus lightStatus : LightStatus.values()) {
            if (lightStatus.getStatus().equals(status)) {
                return lightStatus;
            }
        }
        return OFF; // Default to OFF if no match found
    }
}
