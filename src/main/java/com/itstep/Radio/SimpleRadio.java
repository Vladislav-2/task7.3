package com.itstep.Radio;

import com.itstep.battery.Battery;
import com.itstep.flashlight.FlashLight;
import com.itstep.light.Light;

public class SimpleRadio implements FlashLight {

    private Battery battery;
    private Light wave;
    private boolean isEneble;

    @Override
    public boolean turnOn() {
        if (isEneble != true && battery.getCharge(wave.chargesToTurnOn())){
            isEneble = true;
        }
        return isEneble;
    }

    @Override
    public void turnOff() {
        isEneble = false;
    }

    public SimpleRadio(Battery battery, Light wave){
        this.battery = battery;
        this.wave = wave;
    }
}
