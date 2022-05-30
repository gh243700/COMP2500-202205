package academy.pocu.comp2500.lab5;

public class Barbarian {
    private String name;
    protected int attack;
    protected int defence;
    protected final int MAX_HP;
    protected int hp;

    public Barbarian(String name, int hp, int attack, int defence) {
        this.name = name;
        this.attack = attack;
        this.defence = defence;
        this.MAX_HP = hp;
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    public void attack(Barbarian other) {
        if (hp <= 0 || this == other) {
            return;
        }
        other.hp = Math.max(0, other.hp - Math.max(1, (int) ((attack - other.defence) / 2.0)));
    }

    public boolean isAlive() {
        return hp > 0;
    }
}
