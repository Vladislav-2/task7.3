package com.itstep.Waves;

import com.itstep.light.Light;

public class MediumWave implements Light {

    @Override
    public int chargesToTurnOn() {
        return 10;
    }
}
