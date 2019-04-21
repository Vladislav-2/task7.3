package com.itstep.flashlight;

import com.itstep.light.Light;
import com.itstep.battery.Accumulator;

public class AccDBFLight implements AccumulatorFlashLight{

    private boolean isEneble;
    private Light light;
    private Accumulator battery1;
    private Accumulator battery2;

    public AccDBFLight(Light lightType, Accumulator battery1, Accumulator battery2){
        this.light = lightType;
        this.battery1 = battery1;
        this.battery2 = battery2;
    }

    @Override
    public boolean turnOn(){
        if (isEneble != true && battery1.getCharge((light.chargesToTurnOn()) / 2) && battery2.getCharge((light.chargesToTurnOn()) / 2)){
            isEneble = true;
        }
        return  isEneble;
    }

    @Override
    public void turnOff() {
        isEneble = false;
    }

    @Override
    public Accumulator getAccumulator() {
        return battery1;
    }

    public Accumulator getAccumulator2(){
        return battery2;
    }

    @Override
    public Accumulator getAccumulator3() {
        return null;
    }

    @Override
    public int getAccCharge() {
        return battery1.getCharge();
    }

    @Override
    public int getAccCharge2(){
        return battery2.getCharge();
    }

    @Override
    public int getAccCharge3() {
        return 0;
    }

    public int quantitiesOfCharge(String battery){
        return 0;
    }
}
