package academy.pocu.comp2500.lab11;

public class MyInteger {
    private int value;

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public MyInteger() {
        value = Integer.MAX_VALUE;
    }

    public MyInteger(int value) {
        this.value = value;
    }

}
