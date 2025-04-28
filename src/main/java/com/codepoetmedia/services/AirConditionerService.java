package com.codepoetmedia.services;

/**
 * Service interface for managing air conditioner operations.
 * Provides methods to turn the air conditioner on/off, set its temperature, and manage its status.
 */
public interface AirConditionerService {

    /**
     * Turns on the air conditioner.
     */
    void turnOn();

    /**
     * Turns off the air conditioner.
     */
    void turnOff();

    /**
     * Sets the temperature of the air conditioner.
     *
     * @param temperature the desired temperature to set, as a {@link Double}
     */
    void setTemperature(Double temperature);
}