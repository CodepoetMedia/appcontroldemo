package com.codepoetmedia.services;

import org.springframework.stereotype.Service;

import com.codepoetmedia.devices.Devices;
import com.codepoetmedia.models.LightStatus;
import com.codepoetmedia.models.LightVO;

@Service
public class LightServiceImpl implements LightService {

    // This class is responsible for managing the light device.
    // It provides methods to turn the light on, turn it off, and toggle its state.

    @Override
    public void setLight(LightStatus lightStatus) {
        // Set the light status based on the provided value
        LightVO light = Devices.getLightDeviceInfo();
        light.setStatus(lightStatus);
        // Update the light device information in the system
        Devices.setLightDeviceInfo(light);
        System.out.println(light.getName() + " turned " + lightStatus);
    }

    @Override
    public void toggleLight() {
        // Toggle the current state of the light
        LightVO light = Devices.getLightDeviceInfo();
        System.out.println("Current status of " + light.getName() + ": " + light.getStatus());
        // Toggle the light status
        // If the light is ON, turn it OFF; if it's OFF, turn it ON
        if (light.getStatus().isOn()) {
            light.setStatus(LightStatus.OFF);
        } else {
            light.setStatus(LightStatus.ON);
        }
        // Update the light device information in the system
        Devices.setLightDeviceInfo(light);
        System.out.println(light.getName() + " toggled to " + light.getStatus());
    }
}
