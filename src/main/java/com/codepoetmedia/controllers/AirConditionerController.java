package com.codepoetmedia.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.codepoetmedia.services.AirConditionerService;

/**
 * REST controller for managing air conditioner operations.
 * Provides endpoints to turn the air conditioner on/off and set its temperature.
 */
@RestController
@RequestMapping("/api/ac")
public class AirConditionerController {
    
    private final AirConditionerService airConditionerService;

    private static final String INVALID_TEMPERATURE_MESSAGE = "Invalid temperature value: ";
    private static final String TEMPERATURE_SETTING_MESSAGE = "Setting air conditioner temperature to ";

    /**
     * Constructor for AirConditionerController.
     *
     * @param airConditionerService the service used to manage air conditioner operations
     */
    public AirConditionerController(AirConditionerService airConditionerService) {
        this.airConditionerService = airConditionerService;
    }

    /**
     * Turns on the air conditioner.
     */
    @GetMapping("/turnOn")
    @ResponseStatus(HttpStatus.OK)
    public void turnOn() {
        airConditionerService.turnOn();
    }

    /**
     * Turns off the air conditioner.
     */
    @GetMapping("/turnOff")
    @ResponseStatus(HttpStatus.OK)
    public void turnOff() {
        airConditionerService.turnOff();
    }

    /**
     * Sets the temperature of the air conditioner.
     *
     * @param temperature the desired temperature as a string
     * @throws ResponseStatusException if the temperature value is invalid
     */
    @PostMapping("/setTemperature/{temperature}")
    @ResponseStatus(HttpStatus.OK)
    public void setTemperature(@PathVariable("temperature") String temperature) {
        System.out.println(TEMPERATURE_SETTING_MESSAGE + temperature);
        // Convert the temperature to a double
        Double tempValue;
        try {
            tempValue = Double.parseDouble(temperature);
            airConditionerService.setTemperature(tempValue);
        } catch (NumberFormatException e) {
            System.out.println(INVALID_TEMPERATURE_MESSAGE + temperature);
            // Handle the error, e.g., return an error response or log the error
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, INVALID_TEMPERATURE_MESSAGE + temperature);
        }
    }
}
