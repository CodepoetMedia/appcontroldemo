package com.codepoetmedia.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.codepoetmedia.models.LightStatus;
import com.codepoetmedia.services.LightService;

/**
 * REST controller for managing light operations.
 * Provides endpoints to toggle the light state and set its status.
 */
@RestController
@RequestMapping("/api/lights")
public class LightController {

    private final LightService lightService;

    private static final String TOGGLE_MESSAGE = "Toggling light state.";
    private static final String SETTING_MESSAGE = "Setting light to ";

    /**
     * Constructor for LightController.
     *
     * @param lightService the service used to manage light operations
     */
    public LightController(LightService lightService) {
        this.lightService = lightService;
    }

    /**
     * Toggles the current state of the light.
     */
    @GetMapping("/toggle")
    @ResponseStatus(HttpStatus.OK)
    public void toggleLight() {
        System.out.println(TOGGLE_MESSAGE);
        lightService.toggleLight();
    }

    /**
     * Sets the status of the light.
     *
     * @param status the desired light status as a string (e.g., "ON" or "OFF")
     * @throws IllegalArgumentException if the provided status is invalid
     */
    @PostMapping("/set/{status}")
    @ResponseStatus(HttpStatus.OK)
    public void setLight(@PathVariable("status") String status) {
        System.out.println(SETTING_MESSAGE + status);
        lightService.setLight(LightStatus.fromString(status));
    }

}
