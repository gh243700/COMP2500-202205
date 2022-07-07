package academy.pocu.comp2500.lab8;

public class Schedule {
    private final int tickAt;
    private final int tickTill;
    private boolean isValid;

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public boolean isValid() {
        return isValid;
    }

    public int getTickAt() {
        return tickAt;
    }

    public int getTickTill() {
        return tickTill;
    }

    public Schedule(int tickAt, int tickTill) {
        this.tickAt = tickAt;
        this.tickTill = tickTill;
    }
}
