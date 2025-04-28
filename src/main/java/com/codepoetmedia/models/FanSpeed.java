package com.codepoetmedia.models;

public enum FanSpeed {
    OFF("0"),
    LOW("1"),
    HIGH("2");

    private String speed;

    public boolean isOn() {
        return this != OFF;
    }

    FanSpeed(String speed) {
        this.speed = speed;
    }

    public String getSpeed() {
        return speed;
    }

    public static FanSpeed fromString(String speed) {
        for (FanSpeed fanSpeed : FanSpeed.values()) {
            if (fanSpeed.getSpeed().equals(speed)) {
                return fanSpeed;
            }
        }
        return OFF; // Default to OFF if no match found
    }
}
