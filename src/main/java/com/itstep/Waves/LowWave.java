package com.itstep.Waves;

import com.itstep.light.Light;

public class LowWave implements Light {

    @Override
    public int chargesToTurnOn() {
        return 7;
    }
}
