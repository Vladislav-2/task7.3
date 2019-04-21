package com.itstep;

import com.itstep.flashlight.AccumulatorFlashLight;
import com.itstep.flashlight.FlashLight;

public interface FlashlightFactory {

    FlashLight createFlashLight(String lightType, String batteryType);

    AccumulatorFlashLight createFlashLight(String lightType);

    FlashLight createSimpleRadio(String waveType, String batteryType);

    AccumulatorFlashLight createAccRadio(String waveType);

    FlashLight createDoubleBatteryFlashLight (String lightType, String batteryType1, String batteryType2);

    AccumulatorFlashLight createAccDBFLight(String lightType, String batteryType1, String batteryType2);

    AccumulatorFlashLight createHybridRadio(String waveType, String lightType, String battery1, String battery2);

    AccumulatorFlashLight createLEDFlashLight(String batteryType1, String batteryType2, String batteryType3, String light);
}
