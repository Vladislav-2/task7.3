package com.itstep.Radio;

import com.itstep.light.Light;
import com.itstep.battery.Accumulator;
import com.itstep.flashlight.AccDBFLight;

public class HybridRadio extends AccDBFLight {

    private Light wave;
    private Light light;
    private Accumulator battery1;
    private Accumulator battery2;

    public HybridRadio (Light wave, Light light, Accumulator battery1, Accumulator battery2){
        super(light, battery1, battery2);
        this.battery1 = battery1;
        this.battery2 = battery2;
        this.light = light;
        this.wave = wave;
    }

    @Override
    public void turnOff() {
        super.turnOff();
    }

    @Override
    public boolean turnOn() {
        if (battery1.getCharge((wave.chargesToTurnOn()) / 2 + 1) && battery2.getCharge((wave.chargesToTurnOn()) / 2 + 1) && battery1.getCharge((light.chargesToTurnOn()) / 2) && battery2.getCharge((light.chargesToTurnOn()) / 2)){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Accumulator getAccumulator() {
        return super.getAccumulator2();
    }

    @Override
    public Accumulator getAccumulator2() {
        return super.getAccumulator();
    }

    @Override
    public int getAccCharge() {
        return super.getAccCharge();
    }

    @Override
    public int getAccCharge2() {
        return super.getAccCharge2();
    }
}
