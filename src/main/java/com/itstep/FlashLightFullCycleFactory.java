package com.itstep;

import com.itstep.Radio.AccRadio;
import com.itstep.Radio.HybridRadio;
import com.itstep.Radio.SimpleRadio;
import com.itstep.Waves.LowWave;
import com.itstep.Waves.MediumWave;
import com.itstep.battery.*;
import com.itstep.flashlight.*;
import com.itstep.light.GlowLamp;
import com.itstep.light.LEDLamp;
import com.itstep.light.Light;

public class FlashLightFullCycleFactory implements FlashlightFactory {

    //batteries
    public static final String CHINESE_BATTERY = "chinese_battery";
    public static final String DURACELL_BATTERY = "duracell_battery";
    public static final String ACCUMULATOR_700_BATTERY = "accumulator";
    public static final String LOW_WAVE = "low_wave";
    public static final String MEDIUM_WAVE = "medium_wave";
    public static final String LED_LAMP = "led_lamp";

    //lamps
    public static final String GLOW_LAMP = "glow_lamp";

    @Override
    public FlashLight createFlashLight(String lightType, String batteryType) {
        Light lamp = getLamp(lightType);
        Battery battery = getBattery(batteryType);
        if (lamp != null && battery != null) {
            return new SimpleFlashLight(battery, lamp);
        } else {
            return null;
        }
    }

    @Override
    public AccumulatorFlashLight createFlashLight(String lightType) {
        Light lamp = getLamp(lightType);

        if (lamp != null) {
            return new SimpleAccFlashLight(new SimpleAccumulator(700), lamp);
        } else {
            return null;
        }
    }

    @Override
    public FlashLight createSimpleRadio(String waveType, String batteryType) {
        Battery battery = getBattery(batteryType);
        Light wave = getWave(waveType);

        if (battery != null && wave != null){
            return new SimpleRadio(battery,wave);
        } else {
            return null;
        }
    }

    @Override
    public AccumulatorFlashLight createAccRadio(String waveType) {
        Light wave = getWave(waveType);

        if ( wave != null){
            return new AccRadio(new SimpleAccumulator(700),wave);
        } else {
            return null;
        }
    }

    @Override
    public FlashLight createDoubleBatteryFlashLight(String lightType, String batteryType1, String batteryType2) {
        Light lamp = getLamp(lightType);
        Battery battery1 = getBattery(batteryType1);
        Battery battery2 = getBattery(batteryType2);

        if (lamp != null && battery1 != null && battery2 != null){
            return new DoubleBatteryFlashLight(battery1, battery2, lamp);
        }
        else {
            return null;
        }
    }

    @Override
    public AccumulatorFlashLight createAccDBFLight(String lightType, String batteryType1, String batteryType2) {
        Light lamp = getLamp(lightType);
        Accumulator battery1 = new SimpleAccumulator(700);
        Accumulator battery2 = new SimpleAccumulator(700);

        if (lamp != null) {
            return new AccDBFLight(lamp, battery1, battery2);
        } else {
              return null;
        }
    }

    @Override
    public AccumulatorFlashLight createHybridRadio(String waveType, String lightType, String battery1, String battery2) {
        Light wave = getWave(waveType);
        Light lamp = getLamp(lightType);
        Accumulator accumulator1 = new SimpleAccumulator(700);
        Accumulator accumulator2 = new SimpleAccumulator(700);

        if (lamp != null && wave != null){
            return  new HybridRadio(wave, lamp, accumulator1, accumulator2);
        } else {
            return null;
        }
    }

    @Override
    public AccumulatorFlashLight createLEDFlashLight(String batteryType1, String batteryType2, String batteryType3, String light) {
        Light lamp = getLamp(light);
        Accumulator battery1 = new SimpleAccumulator(700);
        Accumulator battery2 = new SimpleAccumulator(700);
        Accumulator battery3 = new SimpleAccumulator(700);

        if (lamp != null) {
            return new LEDFlashLight(battery1, battery2, battery3, lamp);
        } else {
            return null;
        }
    }

    private Light getWave(String waveType){
        switch (waveType){
            case LOW_WAVE:
                return new LowWave();
            case MEDIUM_WAVE:
                return new MediumWave();
            default:
                return null;
        }
    }

    private Battery getBattery(String batteryType) {
        switch (batteryType) {
            case CHINESE_BATTERY:
                return new ChineseNoNameBattery();
            case DURACELL_BATTERY:
                return new DuracellBattery();
            case ACCUMULATOR_700_BATTERY:
                return new SimpleAccumulator(700);
            default:
                return null;
        }

    }

    private Light getLamp(String lightType) {
        switch (lightType) {
            case GLOW_LAMP:
                return new GlowLamp();
            case LED_LAMP:
                return new LEDLamp();
            default:
                return null;
        }

    }
}
