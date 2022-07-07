package academy.pocu.comp2500.lab8;

public class Drainer extends SmartDevice implements IDrainable, IWaterDetectable {
    private static final int FLUSH_AMOUNT = -7;
    private final int OPERATE_AT;
    private int waterLevel;

    public Drainer(int operate) {
        OPERATE_AT = operate;
    }

    public int getWaterLevel() {
        return waterLevel;
    }

    @Override
    public void onTick() {

        if (waterLevel >= OPERATE_AT) {
            if (isOn == false) {
                onAt = tick;
                isOn = true;
            }
        } else {
            if (isOn == true) {
                onAt = tick;
                isOn = false;
            }
        }

        tick++;
    }

    @Override
    public void install(Planter planter) {
        planter.installDrainer(this);
        planter.installWaterDetector(this);
        waterLevel = planter.getWaterAmount();
    }

    @Override
    public void drain(Planter planter) {
        if (isOn == true) {
            planter.addWaterAmount(FLUSH_AMOUNT);
            waterLevel += FLUSH_AMOUNT;
        }
    }

    @Override
    public void detect(int waterLevel) {
        this.waterLevel = waterLevel;
    }
}
