package com.codepoetmedia.services;

import org.springframework.stereotype.Service;

import com.codepoetmedia.devices.Devices;
import com.codepoetmedia.models.FanSpeed;
import com.codepoetmedia.models.FanVO;

@Service
public class FanServiceImpl implements FanService {

    @Override
    public void setFanSpeed(FanSpeed speed) {
        // Set the fan speed based on the provided value
        FanVO fan = Devices.getFanDeviceInfo();
        fan.setSpeed(speed);
        // Update the fan device information in the system
        Devices.setFanDeviceInfo(fan);
        System.out.println("Setting " + fan.getName() + " speed to " + speed.toString());
    }
}
