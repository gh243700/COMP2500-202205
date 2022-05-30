package academy.pocu.comp2500.lab5;

public class Move {
    private String name;
    private int power;
    private final int MAXIMUM_POWER;
    private int maximumPower;

    public Move(String name, int power, int maximumPower) {
        this.name = name;
        this.power = power;
        this.MAXIMUM_POWER = maximumPower;
        this.maximumPower = maximumPower;
    }

    public String getName() {
        return name;
    }

    public void recoverMaximumPowerByOne() {
        if (maximumPower < MAXIMUM_POWER) {
            maximumPower++;
        }
    }

    public int getPower() {
        return power;
    }

    public boolean canUseMove() {
        if (maximumPower <= 0) {
            return false;
        }

        maximumPower--;

        return true;
    }

}
