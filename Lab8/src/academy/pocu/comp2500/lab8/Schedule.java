package academy.pocu.comp2500.lab8;

public class Schedule {
    private final int tickAt;
    private final int tickTill;


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
