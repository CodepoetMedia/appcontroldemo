package com.codepoetmedia.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.codepoetmedia.services.SystemUpdateService;

/**
 * REST controller for managing system updates.
 * Provides endpoints to check for updates, download updates, and install updates.
 */
@RestController
@RequestMapping("/api/system")
public class SystemUpdateController {

    // This class is responsible for managing system updates.
    // It will contain methods to check for updates, download updates, and install updates.

    private final SystemUpdateService systemUpdateService;

    private static final String CHECKING_MESSAGE = "Checking for system updates...";

    /**
     * Constructor for SystemUpdateController.
     *
     * @param systemUpdateService the service used to manage system updates
     */   
    public SystemUpdateController(SystemUpdateService systemUpdateService) {
        this.systemUpdateService = systemUpdateService;
    }

    /**
     * Checks for available system updates.
     * This method triggers the system update service to check for updates.
     */
    @GetMapping("/checkForUpdates")
    @ResponseStatus(HttpStatus.OK)
    public void checkForUpdates() {
        System.out.println(CHECKING_MESSAGE);
        systemUpdateService.checkForUpdates();
    }

}
