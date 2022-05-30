package academy.pocu.comp2500.lab5;

public class Barbarian {
    private String name;
    private int attack;
    private int defence;
    protected final int MAX_HP;
    protected int hp;

    public Barbarian(String name, int hp, int attack, int defence) {
        this.name = name;
        this.attack = attack;
        this.defence = defence;
        this.MAX_HP = hp;
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }

    public int getHp() {
        return hp;
    }

    public void attack(Barbarian other) {
        other.hp = Math.max(0, other.hp - Math.max(1, (int)((attack - other.defence) / 2.0)));
    }

    public boolean isAlive() {
        return (hp > 0) ? true : false;
    }
}
