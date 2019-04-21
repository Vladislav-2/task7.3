package com.itstep.flashlight;

import com.itstep.battery.Accumulator;

public interface AccumulatorFlashLight extends FlashLight {

    Accumulator getAccumulator();

    Accumulator getAccumulator2();

    Accumulator getAccumulator3();

    int getAccCharge();

    int getAccCharge2();

    int getAccCharge3();

    int quantitiesOfCharge(String battery);
}
