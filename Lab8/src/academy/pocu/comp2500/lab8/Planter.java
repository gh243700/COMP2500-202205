package academy.pocu.comp2500.lab8;

import java.util.ArrayList;

public class Planter {
    private final int WATER_CONSUME_PER_DAY = -2;
    private int waterAmount;
    private ArrayList<SmartDevice> smartDevices = new ArrayList<>();
    private ArrayList<ISprayable> sprayables = new ArrayList<>();
    private ArrayList<IDrainable> drainables = new ArrayList<>();
    private ArrayList<IWaterDetectable> waterDetectables = new ArrayList<>();

    public void addWaterAmount(int waterAmount) {
        this.waterAmount = Math.max(0 , this.waterAmount + waterAmount);
    }

    public int getWaterAmount() {
        return waterAmount;
    }

    public Planter(int waterAmount) {
        this.waterAmount = waterAmount;
    }

    public void installSmartDevice(SmartDevice smartDevice) {
        smartDevices.add(smartDevice);
        smartDevice.install(this);
    }

    public void installSprinkler(ISprayable iSprayable) {
        this.sprayables.add(iSprayable);
    }

    public void installWaterDetector(IWaterDetectable iWaterDetectable) {
        this.waterDetectables.add(iWaterDetectable);
    }

    public void installDrainer(IDrainable iDrainable) {
        this.drainables.add(iDrainable);
    }

    public void tick() {
        for (IWaterDetectable iWaterDetectable : waterDetectables) {
            iWaterDetectable.detect(waterAmount);
        }

        for (SmartDevice smartDevice : smartDevices) {
            smartDevice.onTick();
        }

        for (ISprayable iSprayable : sprayables) {
            iSprayable.spray(this);
        }

        addWaterAmount(WATER_CONSUME_PER_DAY);

        for (IDrainable iDrainable : drainables) {
            iDrainable.drain(this);
        }
    }

}
