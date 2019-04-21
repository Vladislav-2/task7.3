package com.itstep.flashlight;

import com.itstep.battery.Accumulator;
import com.itstep.light.Light;

public class LEDFlashLight extends AccDBFLight{

    private Light light;
    private Accumulator battery1;
    private Accumulator battery2;
    private Accumulator battery3;

    public LEDFlashLight (Accumulator battery_1, Accumulator battery_2, Accumulator battery_3, Light lightType){
        super(lightType, battery_1, battery_2);
        this.light = lightType;
        this.battery1 = battery_1;
        this.battery2 = battery_2;
        this.battery3 = battery_3;
    }

    public int quantitiesOfCharge(String battery){
        switch(battery) {
            case "battery(1)":
                return battery1.getCharge();
            case "battery(2)":
                return battery2.getCharge();
            case "battery(3)":
                return battery3.getCharge();
            default:
                return 0;
        }
    }

    @Override
    public boolean turnOn() {
        if (battery1.getCharge((light.chargesToTurnOn()) / 3) && battery2.getCharge((light.chargesToTurnOn()) / 3) && battery3.getCharge((light.chargesToTurnOn()) / 3)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void turnOff() {
        super.turnOff();
    }

    @Override
    public Accumulator getAccumulator() {
        return super.getAccumulator();
    }

    @Override
    public Accumulator getAccumulator2() {
        return super.getAccumulator2();
    }

    @Override
    public Accumulator getAccumulator3() {
        return battery3;
    }

    @Override
    public int getAccCharge() {
        return super.getAccCharge();
    }

    @Override
    public int getAccCharge2() {
        return super.getAccCharge2();
    }

    @Override
    public int getAccCharge3() {
        return battery3.getCharge();
    }
}
