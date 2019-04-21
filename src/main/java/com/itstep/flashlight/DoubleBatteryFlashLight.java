package com.itstep.flashlight;

import com.itstep.battery.Battery;
import com.itstep.light.Light;

public class DoubleBatteryFlashLight implements FlashLight{

    private Light light;
    private Battery battery2;
    private Battery battery1;
    private boolean isEneble;

    public DoubleBatteryFlashLight (Battery battery1, Battery battery2, Light light){
        this.light = light;
        this.battery1 = battery1;
        this.battery2 = battery2;
    }

    @Override
    public boolean turnOn() {
        if (isEneble != true && battery1.getCharge((light.chargesToTurnOn()) / 2) && battery2.getCharge((light.chargesToTurnOn()) / 2)){
            isEneble = true;
        }
        return isEneble;
    }

    @Override
    public void turnOff() {
        isEneble = false;
    }
}
