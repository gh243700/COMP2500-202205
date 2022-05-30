package academy.pocu.comp2500.lab5;

public class Knight extends Gladiator {

    private Pet petOrNull;

    public Knight(String name, int hp, int attack, int defense) {
        super(name, hp, attack, defense);
    }

    public void setPet(Pet petOrNull) {
        this.petOrNull = petOrNull;
    }

    public void attackTogether(Barbarian other) {

        if (hp <= 0 || this == other || petOrNull == null) {
            return;
        }

        other.hp = Math.max(0, other.hp - Math.max(1, (int) ((attack + petOrNull.getAttack() - other.defence) / 2.0)));
    }
}
