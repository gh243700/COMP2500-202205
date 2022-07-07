package academy.pocu.comp2500.lab8;

public abstract class SmartDevice {

    protected boolean isOn;
    protected int onAt;
    protected int tick;


    public abstract void onTick();

    public abstract void install(Planter planter);

    public boolean isOn() {
        return isOn;
    }
    public int getTicksSinceLastUpdate() {
        return tick - onAt;
    }


}
