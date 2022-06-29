package academy.pocu.comp2500.assignment3;

public abstract class Unit {
    private char symbol;
    private UnitType unitType;
    private int fov;
    private int aoe;
    private int ap;
    protected int hp;
    private AttackableUnitType attackableUnitType;
    private IntVector2D position;
    private boolean isThinkable;
    private boolean isMovable;

    protected AttackIntent attackIntentOrNull;
    public Unit(char symbol, UnitType unitType, int fov, int aoe, int ap, AttackableUnitType attackableUnitType, IntVector2D position, boolean isThinkable, boolean isMovable) {
        this.symbol = symbol;
        this.unitType = unitType;
        this.fov = fov;
        this.aoe = aoe;
        this.ap = ap;
        this.attackableUnitType = attackableUnitType;
        this.position = position;
        this.isThinkable = isThinkable;
        this.isMovable = isMovable;
    }

    public IntVector2D getPosition() {
        return position;
    }

    public int getHp() {
        return hp;
    }

    public AttackIntent attack() {
        /*attack(): 공격 의도(AttackIntent) 개체를 반환합니다. AttackIntent 안에는 공격 위치, 피해치, 공격자 등 공격에 필요한 정보가 담겨 있어야 합니다.*/
        return attackIntentOrNull;
    };

    public void setAttackIntentOrNull(AttackIntent attackIntentOrNull) {
        this.attackIntentOrNull = attackIntentOrNull;
    }
    public void onAttacked(int damage) {
        hp = Math.max(0 , hp - damage);
    };

    public abstract void onSpawn();

    public char getSymbol() {
        return symbol;
    };

    public boolean isThinkable() {
        return isThinkable;
    }


    public int getAp() {
        return ap;
    }

    public boolean isMovable() {
        return isMovable;
    }

}