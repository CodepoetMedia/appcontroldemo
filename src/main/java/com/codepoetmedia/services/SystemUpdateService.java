package com.codepoetmedia.services;

/**
 * Service interface for managing system updates.
 * Provides methods to check for updates.
 */
public interface SystemUpdateService {

    /**
     * Checks for available system updates.
     * @return true if updates are available, false otherwise.
     */
    void checkForUpdates();
} 
