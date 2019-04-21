package com.itstep.flashlight;

import com.itstep.battery.Accumulator;
import com.itstep.light.Light;

public class SimpleAccFlashLight extends SimpleFlashLight implements AccumulatorFlashLight {

    private Accumulator accumulator;

    public SimpleAccFlashLight(Accumulator battery, Light light) {
        super(battery, light);
        this.accumulator = battery;
    }

    @Override
    public Accumulator getAccumulator() {
        return accumulator;
    }

    @Override
    public Accumulator getAccumulator2() {
        return null;
    }

    @Override
    public Accumulator getAccumulator3() {
        return null;
    }

    @Override
    public int getAccCharge() {
        return accumulator.getCharge();
    }

    @Override
    public int getAccCharge2() {
        return 0;
    }

    @Override
    public int getAccCharge3() {
        return 0;
    }

    public int quantitiesOfCharge(String battery){ return 0;}

}
