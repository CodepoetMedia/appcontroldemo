package com.codepoetmedia.services;

import org.springframework.stereotype.Service;

import com.codepoetmedia.devices.Devices;
import com.codepoetmedia.models.AirConditionerStatus;
import com.codepoetmedia.models.AirConditionerVO;

@Service
public class AirConditionerServiceImpl implements AirConditionerService {

    private Double defaultTemperature = 22.0; // Default temperature for the air conditioner

    @Override
    public void turnOn() {
        // Turn on the air conditioner and set its temperature to the default value if it's within range
        AirConditionerVO airConditioner = Devices.getAirConditionerDeviceInfo();
        airConditioner.setStatus(AirConditionerStatus.ON);
        // Set the temperature to default if it's not already set
        if (airConditioner.getTemperature() > 16.0 
            && airConditioner.getTemperature() < 30.0) {
                airConditioner.setTemperature(defaultTemperature);
        }
        // Update the air conditioner device information in the system
        Devices.setAirConditionerDeviceInfo(airConditioner);
        System.out.println(airConditioner.getName() + " is turned ON.");
    }

    @Override
    public void turnOff() {
        // Turn off the air conditioner
        AirConditionerVO airConditioner = Devices.getAirConditionerDeviceInfo();
        airConditioner.setStatus(AirConditionerStatus.OFF);
        // Update the air conditioner device information in the system
        Devices.setAirConditionerDeviceInfo(airConditioner);
        System.out.println(airConditioner.getName() + " is turned OFF.");
    }

    @Override
    public void setTemperature(Double temperature) {
        // Set the temperature of the air conditioner
        AirConditionerVO airConditioner = Devices.getAirConditionerDeviceInfo();
        airConditioner.setTemperature(temperature);
        // Update the air conditioner device information in the system
        Devices.setAirConditionerDeviceInfo(airConditioner);
        System.out.println(airConditioner.getName() + " temperature set to " + temperature + " degrees.");
    }
   
}
