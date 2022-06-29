package academy.pocu.comp2500.assignment3;

public class AttackIntent {
    private IntVector2D attackPosition;
    private int damage;
    private Unit attacker;

    public AttackIntent(IntVector2D intVector2D, int damage, Unit attacker) {
        this.attackPosition = intVector2D;
        this.damage = damage;
        this.attacker = attacker;
    }

    public IntVector2D getAttackPosition() {
        return attackPosition;
    }

    public void setAttackPosition(IntVector2D attackPosition) {
        this.attackPosition = attackPosition;
    }

    public int getDamage() {
        return damage;
    }

    public Unit getAttacker() {
        return attacker;
    }

    public void setAttacker(Unit attacker) {
        this.attacker = attacker;
    }
}