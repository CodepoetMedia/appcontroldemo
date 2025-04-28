package com.codepoetmedia.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.codepoetmedia.models.FanSpeed;
import com.codepoetmedia.services.FanService;

/**
 * REST controller for managing fan operations.
 * Provides endpoints to turn the fan off and set its speed.
 */
@RestController
@RequestMapping("/api/fan")
public class FanController {

    private final FanService fanService;

    private static final String FANOFF_MESSAGE = "Turning fan off.";
    private static final String SETTING_MESSAGE = "Setting fan to ";
    private static final String INVALID_INPUT_MESSAGE = "Fan speed cannot be null or empty.";

    /**
     * Constructor for FanController.
     *
     * @param fanService the service used to manage fan operations
     */
    public FanController(FanService fanService) {
        this.fanService = fanService;
    }

    /**
     * Turns off the fan.
     */
    @GetMapping("/turnOff")
    @ResponseStatus(HttpStatus.OK)
    public void turnOff() {
        System.out.println(FANOFF_MESSAGE);
        fanService.setFanSpeed(FanSpeed.OFF);
    }

    /**
     * Sets the speed of the fan.
     *
     * @param fanSpeed the desired fan speed as a string
     * @throws IllegalArgumentException if the provided fan speed is invalid
     */
    @PostMapping("/speed/{fanSpeed}")
    @ResponseStatus(HttpStatus.OK)
    public void setSpeed(@PathVariable("fanSpeed") String fanSpeed) {
        System.out.println(SETTING_MESSAGE + fanSpeed);
        if (fanSpeed == null || fanSpeed.isEmpty()) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
        fanService.setFanSpeed(FanSpeed.fromString(fanSpeed));
    }
}
