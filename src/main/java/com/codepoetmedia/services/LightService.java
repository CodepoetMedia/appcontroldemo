package com.codepoetmedia.services;

import com.codepoetmedia.models.LightStatus;

/**
 * Interface for controlling light devices.
 */
public interface LightService {

    /**
     * Set the light to a specific state.
     */
    void setLight(LightStatus lightStatus);

    /**
     * Toggles the light's current state.
     * If the light is on, it will be turned off.
     * If the light is off, it will be turned on.
     */
    void toggleLight();
}