package com.itstep.Radio;

import com.itstep.battery.Accumulator;
import com.itstep.flashlight.AccumulatorFlashLight;
import com.itstep.light.Light;

public class AccRadio implements AccumulatorFlashLight {

    private Accumulator accumulator;
    private Light wave;
    private boolean isEneble;

    @Override
    public boolean turnOn() {
        if (isEneble != true && accumulator.getCharge(wave.chargesToTurnOn())){
            isEneble = true;
        }
        return isEneble;
    }

    @Override
    public void turnOff() {
        isEneble = false;
    }

    @Override
    public Accumulator getAccumulator() {
        return accumulator;
    }

    @Override
    public int getAccCharge2() {
        return 0;
    }

    @Override
    public int getAccCharge() {
        return accumulator.getCharge();
    }

    @Override
    public Accumulator getAccumulator2() {
        return null;
    }

    @Override
    public int getAccCharge3() {
        return 0;
    }

    @Override
    public Accumulator getAccumulator3() {
        return null;
    }

    public AccRadio(Accumulator battery, Light wave){
        this.wave = wave;
        this.accumulator = battery;
    }

    public int quantitiesOfCharge(String battery){ return 0;}

}
