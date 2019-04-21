package com.itstep.battery;

public abstract class AbstractBattery implements Battery {

    private int charges;

    public AbstractBattery(int charges) {
        this.charges = charges;
    }

    protected void setCharges(int charges) {
        this.charges = charges;
    }

    protected int getCharges() {
        return charges;
    }

    @Override
    public boolean getCharge(int charges) {
        if (charges > 0 && this.charges >= charges) {
            this.charges -= charges;
            return true;

        }
        return false;
    }
}
