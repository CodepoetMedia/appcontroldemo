package com.codepoetmedia.devices;

import com.codepoetmedia.models.AirConditionerStatus;
import com.codepoetmedia.models.AirConditionerVO;
import com.codepoetmedia.models.LightStatus;
import com.codepoetmedia.models.LightVO;
import com.codepoetmedia.models.FanSpeed;
import com.codepoetmedia.models.FanVO;

public class Devices {

    // These are mock devices for testing purposes
    // In a real-world application, these would be replaced with actual device instances
    // that interact with hardware or a cloud service.
    // For example, you might have a class that communicates with a smart home hub or a cloud API.

    static LightDevice lightDevice = new LightDevice(
        1, 
        "Living Room Light", 
        "ON");
    
    static FanDevice fanDevice = new FanDevice(
        2, 
        "Bathroom Fan", 
        "0");
    
    static AirConditionerDevice acDevice = new AirConditionerDevice(
        3, 
        "Main Floor AC", 
        "ON", 
        "21.7");

    public static LightVO getLightDeviceInfo() {
        // Converting LightDevice to LightVO
        LightVO lightVO = new LightVO();
        lightVO.setId(lightDevice.getId());
        lightVO.setName(lightDevice.getName());
        lightVO.setStatus(lightDevice.getStatus().equals("ON") ? LightStatus.ON : LightStatus.OFF);

        return lightVO;
    }

    public static FanVO getFanDeviceInfo() {
        // Converting FanDevice to FanVO
        FanVO fanVO = new FanVO();
        fanVO.setId(fanDevice.getId());
        fanVO.setName(fanDevice.getName());
        fanVO.setSpeed(FanSpeed.fromString(fanDevice.getSpeed()));

        return fanVO;
    }

    public static AirConditionerVO getAirConditionerDeviceInfo() {
        // Converting FanDevice to AirConditionerVO
        AirConditionerVO acVO = new AirConditionerVO();
        acVO.setId(acDevice.getId());
        acVO.setName(acDevice.getName());
        acVO.setStatus(AirConditionerStatus.fromString(acDevice.getStatus()));
        acVO.setTemperature(Double.parseDouble(acDevice.getTemperature()));

        return acVO;
    }

    public static void setLightDeviceInfo(LightVO light) {
        // Converting LightVO to LightDevice
        lightDevice.setStatus(light.getStatus().equals(LightStatus.ON) ? "ON" : "OFF");
    }

    public static void setFanDeviceInfo(FanVO fan) {
        // Converting FanVO to FanDevice
        fanDevice.setSpeed(fan.getSpeed().toString());
    }

    public static void setAirConditionerDeviceInfo(AirConditionerVO ac) {
        // Converting AirConditionerVO to AirConditionerDevice
        acDevice.setStatus(ac.getStatus().toString());
        acDevice.setTemperature(String.valueOf(ac.getTemperature()));
    }
    
}