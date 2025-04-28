package com.codepoetmedia.services;

import org.springframework.stereotype.Service;

import com.codepoetmedia.devices.Devices;
import com.codepoetmedia.models.LightStatus;
import com.codepoetmedia.models.LightVO;
import com.codepoetmedia.models.FanSpeed;
import com.codepoetmedia.models.FanVO;
import com.codepoetmedia.models.AirConditionerStatus;
import com.codepoetmedia.models.AirConditionerVO;

@Service
public class SystemUpdateServiceImpl implements SystemUpdateService {

    private static final String UPDATE_URL = "https://example.com/update"; // Replace with actual update URL

    LightStatus lightStatus;
    FanSpeed fanSpeed;
    AirConditionerStatus airConditionerStatus;

    AirConditionerVO acDevice;
    FanVO fanDevice;
    LightVO lightDevice;

    @Override
    public void checkForUpdates() {
        // Simulate checking for updates
        System.out.println("Checking for updates...");
        boolean updateAvailable = mockExternalUpdateCheck();

        if (updateAvailable) {
            System.out.println("Update available! Turning off devices...");
            turnOffDevices();
            downloadUpdate();
            installUpdate();
            restoreDevices();
            System.out.println("Update installed successfully!");
        } else {
            System.out.println("No updates available.");
        }
    }

    private boolean mockExternalUpdateCheck() {
        // Simulate an external update check
        return true;
    }

    private void downloadUpdate() {
        // Logic to download the update
        System.out.println("Downloading update from " + UPDATE_URL + "...");
        try {
            // Simulate a 2-second download time
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Download complete!");
    }
    
    private void installUpdate() {
        // Logic to download the update
        System.out.println("Installing update...");
        // Simulate install time
        try {
            Thread.sleep(2000); // Simulate a 2-second download time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Installation complete!");
    }

    private void turnOffDevices() {
        // Load all the devices
        // These are mock devices for testing purposes
        lightDevice = Devices.getLightDeviceInfo();
        fanDevice = Devices.getFanDeviceInfo();
        acDevice = Devices.getAirConditionerDeviceInfo();

        // Save the current state of devices before turning them off
        lightStatus = lightDevice.getStatus();
        fanSpeed = fanDevice.getSpeed();
        airConditionerStatus = acDevice.getStatus();

        // Set the state to off
        lightDevice.setStatus(LightStatus.OFF);
        fanDevice.setSpeed(FanSpeed.OFF);
        acDevice.setStatus(AirConditionerStatus.OFF);

        // Logic to turn off devices
        Devices.setLightDeviceInfo(lightDevice);
        Devices.setFanDeviceInfo(fanDevice);
        Devices.setAirConditionerDeviceInfo(acDevice);
        System.out.println("All devices turned off.");
    }

    private void restoreDevices() {
        // Restore the devices to their previous state
        lightDevice.setStatus(lightStatus);
        fanDevice.setSpeed(fanSpeed);
        acDevice.setStatus(airConditionerStatus);

        // Logic to restore devices
        Devices.setLightDeviceInfo(lightDevice);
        Devices.setFanDeviceInfo(fanDevice);
        Devices.setAirConditionerDeviceInfo(acDevice);
        System.out.println("Devices restored to their previous state.");
    }
    
}