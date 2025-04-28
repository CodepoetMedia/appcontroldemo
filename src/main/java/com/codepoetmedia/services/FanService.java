package com.codepoetmedia.services;

import com.codepoetmedia.models.FanSpeed;

/**
 * Service interface for managing fan operations.
 * Provides methods to control the fan's speed and manage its state.
 */
public interface FanService {

    /**
     * Sets the speed of the fan.
     *
     * @param speed the desired fan speed, as a {@link FanSpeed} enum
     */
    void setFanSpeed(FanSpeed speed);
}