package com.itstep;

import com.itstep.flashlight.AccumulatorFlashLight;
import com.itstep.flashlight.FlashLight;
import org.junit.Assert;
import org.junit.Test;

public class FlashlightFactoryTest {

    private FlashlightFactory factory = new FlashLightFullCycleFactory();

    @Test
    public void chineseFlashlightTest(){

        FlashLight flashLight = factory.createFlashLight(
                FlashLightFullCycleFactory.GLOW_LAMP,
                FlashLightFullCycleFactory.CHINESE_BATTERY);

        for (int i = 0; i < 5; i++) {
            Assert.assertTrue(flashLight.turnOn());
            flashLight.turnOff();
        }
        Assert.assertFalse(flashLight.turnOn());
        flashLight.turnOff();
    }

    @Test
    public void duracellFlashlightTest(){

        FlashLight flashLight = factory.createFlashLight(
                FlashLightFullCycleFactory.GLOW_LAMP,
                FlashLightFullCycleFactory.DURACELL_BATTERY);

        for (int i = 0; i < 50; i++) {
            Assert.assertTrue(flashLight.turnOn());
            flashLight.turnOff();
        }
        Assert.assertFalse(flashLight.turnOn());
        flashLight.turnOff();
    }

    @Test
    public void accumulatorFlashlightTest(){

        AccumulatorFlashLight flashLight = factory.createFlashLight(
                FlashLightFullCycleFactory.GLOW_LAMP);

        for (int i = 0; i < 70; i++) {
            Assert.assertTrue(flashLight.turnOn());
            flashLight.turnOff();
        }
        Assert.assertFalse(flashLight.turnOn());
        flashLight.turnOff();

        Assert.assertEquals(0, flashLight.getAccCharge());

        flashLight.getAccumulator().recharge();

        Assert.assertEquals(700, flashLight.getAccCharge());

        Assert.assertTrue(flashLight.turnOn());
    }

    @Test
    public void simpleRadioTest(){

        FlashLight radio = factory.createSimpleRadio(
                FlashLightFullCycleFactory.LOW_WAVE,
                FlashLightFullCycleFactory.DURACELL_BATTERY);

        for (int i = 0; i < 71; i++) {
            Assert.assertTrue(radio.turnOn());
            radio.turnOff();
        }
        Assert.assertFalse(radio.turnOn());
        radio.turnOff();
    }

    @Test
    public void accRadiotTest(){

        AccumulatorFlashLight radio = factory.createAccRadio(
                FlashLightFullCycleFactory.LOW_WAVE);

        for (int i = 0; i < 100; i++) {
            Assert.assertTrue(radio.turnOn());
            radio.turnOff();
        }
        Assert.assertFalse(radio.turnOn());
        radio.turnOff();

        Assert.assertEquals(0, radio.getAccCharge());

        radio.getAccumulator().recharge();

        Assert.assertEquals(700, radio.getAccCharge());

        Assert.assertTrue(radio.turnOn());
    }

    @Test
    public void DoubleBatteryFlashLightTest(){

        FlashLight DBFlashLight = factory.createDoubleBatteryFlashLight(
                FlashLightFullCycleFactory.GLOW_LAMP,
                FlashLightFullCycleFactory.DURACELL_BATTERY,
                FlashLightFullCycleFactory.DURACELL_BATTERY);

        for (int i = 0; i < 100; i++){
            Assert.assertTrue(DBFlashLight.turnOn());
            DBFlashLight.turnOff();
        }
        Assert.assertFalse(DBFlashLight.turnOn());
        DBFlashLight.turnOff();
    }

    @Test
    public void AccDBFLightTest(){

        AccumulatorFlashLight ADBFL = factory.createAccDBFLight(
                FlashLightFullCycleFactory.GLOW_LAMP,
                FlashLightFullCycleFactory.ACCUMULATOR_700_BATTERY,
                FlashLightFullCycleFactory.ACCUMULATOR_700_BATTERY);

        for (int i = 0; i < 140; i++){
            Assert.assertTrue(ADBFL.turnOn());
            ADBFL.turnOff();
        }
        Assert.assertFalse(ADBFL.turnOn());
        ADBFL.turnOff();

        Assert.assertEquals(0, ADBFL.getAccCharge());

        ADBFL.getAccumulator().recharge();

        Assert.assertEquals(700, ADBFL.getAccCharge());

        Assert.assertFalse(ADBFL.turnOn());

        Assert.assertEquals(0, ADBFL.getAccCharge2());

        ADBFL.getAccumulator2().recharge();

        Assert.assertEquals(700, ADBFL.getAccCharge2());

        Assert.assertTrue(ADBFL.turnOn());
    }

    @Test
    public void HybridRadioTest(){
        AccumulatorFlashLight Hybrid = factory.createHybridRadio(
                FlashLightFullCycleFactory.LOW_WAVE,
                FlashLightFullCycleFactory.GLOW_LAMP,
                FlashLightFullCycleFactory.ACCUMULATOR_700_BATTERY,
                FlashLightFullCycleFactory.ACCUMULATOR_700_BATTERY);
        for (int i = 0; i < 77; i++){ //charge 17 in to step (77)
            Assert.assertTrue(Hybrid.turnOn());
            Hybrid.turnOff();
        }
        Assert.assertFalse(Hybrid.turnOn());
        Hybrid.turnOff();

        Assert.assertEquals(3, Hybrid.getAccCharge());

        Hybrid.getAccumulator().recharge();

        Assert.assertEquals(3, Hybrid.getAccCharge());

        Assert.assertFalse(Hybrid.turnOn());

        Assert.assertEquals(700, Hybrid.getAccCharge2());

        Hybrid.getAccumulator2().recharge();

        Assert.assertEquals(700, Hybrid.getAccCharge2());

        Assert.assertTrue(Hybrid.turnOn());
    }

    @Test
    public void LEDFlashLightTest() {
        AccumulatorFlashLight LED = factory.createLEDFlashLight(
                FlashLightFullCycleFactory.ACCUMULATOR_700_BATTERY,
                FlashLightFullCycleFactory.ACCUMULATOR_700_BATTERY,
                FlashLightFullCycleFactory.ACCUMULATOR_700_BATTERY,
                FlashLightFullCycleFactory.LED_LAMP);

        for (int i = 0; i < 700; i++) {
            Assert.assertTrue(LED.turnOn());
            LED.turnOff();
        }
        Assert.assertFalse(LED.turnOn());
        LED.turnOff();

        Assert.assertEquals(0, LED.getAccCharge());

        LED.getAccumulator().recharge();

        Assert.assertEquals(700, LED.getAccCharge());

        Assert.assertFalse(LED.turnOn());

        Assert.assertEquals(0, LED.getAccCharge2());

        LED.getAccumulator2().recharge();

        Assert.assertEquals(700, LED.getAccCharge2());

        Assert.assertFalse(LED.turnOn());

        Assert.assertEquals(0, LED.getAccCharge3());

        LED.getAccumulator3().recharge();

        Assert.assertEquals(700, LED.getAccCharge3());

        Assert.assertTrue(LED.quantitiesOfCharge("battery(2)") != 0);
    }
}
