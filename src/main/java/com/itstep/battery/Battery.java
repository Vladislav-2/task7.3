package com.itstep.battery;

public interface Battery {

    /**
     * Returns true if internal charge is enough and reduces internal charge for given value.
     * If not enough - return false.
     *
     * @param charges
     * @return
     */
    boolean getCharge(int charges);

}
