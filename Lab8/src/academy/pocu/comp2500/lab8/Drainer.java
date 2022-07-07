package academy.pocu.comp2500.lab8;

public class Drainer extends SmartDevice implements IDrainable, IWaterDetectable {
    private static final int FLUSH_AMOUNT = -7;
    private final int OPERATE_AT;
    private boolean before;

    public Drainer(int operate) {
        OPERATE_AT = operate;
    }

    @Override
    public void onTick() {
        tick++;
        if (before != isOn) {
            onAt = tick;
            before = isOn;
        }
    }

    @Override
    public void install(Planter planter) {
        planter.installDrainer(this);
        planter.installWaterDetector(this);
    }

    @Override
    public void drain(Planter planter) {
        if (isOn == true) {
            planter.addWaterAmount(FLUSH_AMOUNT);
        }
    }

    @Override
    public void detect(int waterLevel) {
        if (waterLevel >= OPERATE_AT) {
            isOn = true;
        } else {
            isOn = false;
        }
    }
}
