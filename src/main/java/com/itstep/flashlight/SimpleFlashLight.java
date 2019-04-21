package com.itstep.flashlight;

import com.itstep.battery.Battery;
import com.itstep.light.Light;

public class SimpleFlashLight implements FlashLight {

    private Battery battery;
    private Light light;
    private boolean enabled;

    public SimpleFlashLight(Battery battery, Light light) {
        this.battery = battery;
        this.light = light;
    }

    @Override
    public boolean turnOn() {
        if (!enabled) {
            enabled = battery.getCharge(light.chargesToTurnOn());
            return enabled;
        } else {
            return enabled;
        }
    }

    @Override
    public void turnOff() {
        enabled = false;
    }
}
