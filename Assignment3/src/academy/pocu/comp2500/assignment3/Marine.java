package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;

public class Marine extends Unit implements IMovable, IThinkable{
    private static final char SYMBOL = 'M';
    private static final UnitType UNIT_TYPE = UnitType.GROUND;
    private static final int FOV = 2;
    private static final int AOE = 0;
    private static final int AP = 6;
    private static final int HP = 35;
    private static final AttackableUnitType ATTACKABLE_UNIT_TYPE = AttackableUnitType.GROUND_AND_MIDAIR;

    public Marine(IntVector2D intVector2D) {
        super(SYMBOL, UNIT_TYPE, FOV, AOE, AP, ATTACKABLE_UNIT_TYPE, intVector2D, true, true);
    }

    @Override
    public void move() {

    }

    @Override
    public void think(ArrayList<Unit> units) {
        IntVector2D thisPosition = getPosition();
        ArrayList<Unit> unitsInRange = new ArrayList<>();

        boolean pos0 = false;
        boolean pos1 = false;
        boolean pos2 = false;
        boolean pos3 = false;
        boolean pos4 = false;

        int manhattanDistanceMin = Integer.MAX_VALUE;
        int manhattanDistanceMinX = 0;
        int manhattanDistanceMinY = 0;


        setAttackIntentOrNull(null);


        for (Unit unit : units) {
            IntVector2D otherPosition = unit.getPosition();
            if (this == unit) {
                continue;
            }

            if (thisPosition.getX() == otherPosition.getX() && thisPosition.getY() == otherPosition.getY()) {
                pos0 = true;
                unitsInRange.add(unit);
            } else if (thisPosition.getX() == otherPosition.getX() && thisPosition.getY() - 1 == otherPosition.getY()) {
                pos1 = true;
                unitsInRange.add(unit);
            } else if (thisPosition.getX() + 1 == otherPosition.getX() && thisPosition.getY() == otherPosition.getY()) {
                pos2 = true;
                unitsInRange.add(unit);
            } else if (thisPosition.getX() == otherPosition.getX() && thisPosition.getY() + 1 == otherPosition.getY()) {
                pos3 = true;
                unitsInRange.add(unit);
            } else if (thisPosition.getX() - 1 == otherPosition.getX() && thisPosition.getY() == otherPosition.getY()) {
                pos4 = true;
                unitsInRange.add(unit);
            }


            if (thisPosition.getX() - 2 <= otherPosition.getX() && otherPosition.getX() <= thisPosition.getX() + 2
            && thisPosition.getY() - 2 <= otherPosition.getY() && otherPosition.getY() <= thisPosition.getY() + 2
            ) {
                int manhattanDistance = Math.abs(thisPosition.getX() + otherPosition.getX()) + Math.abs(thisPosition.getY() + otherPosition.getY());
                if (manhattanDistance < manhattanDistanceMin) {
                    manhattanDistanceMin = manhattanDistance;
                    manhattanDistanceMinX = otherPosition.getX();
                    manhattanDistanceMinY = otherPosition.getY();
                }
            }
        }

        for(int i = 0; i < unitsInRange.size(); i++) {
            for(int j = 0; j < unitsInRange.size() - i - 1; j++) {
                Unit u0 = units.get(i);
                Unit u1 = units.get(j + 1);
                if (u0.getHp() > u1.getHp()) {
                    unitsInRange.remove(i);
                    unitsInRange.add(i ,u1);
                    unitsInRange.remove(j);
                    unitsInRange.add(j, u0);
                }
            }
        }

        if (unitsInRange.get(0).getHp() != unitsInRange.get(unitsInRange.size() - 1).getHp()) {
            Unit target = units.get(0);
            setAttackIntentOrNull(new AttackIntent(target.getPosition(), getAp(), this));
            return;
        }

        if (pos0) {
            setAttackIntentOrNull(new AttackIntent(getPosition(), getAp(), this));
        } else if (pos1) {
            setAttackIntentOrNull(new AttackIntent(new IntVector2D(thisPosition.getX(), thisPosition.getY() - 1), getAp(), this));
        } else if (pos2) {
            setAttackIntentOrNull(new AttackIntent(new IntVector2D(thisPosition.getX() + 1, thisPosition.getY()), getAp(), this));
        } else if (pos3) {
            setAttackIntentOrNull(new AttackIntent(new IntVector2D(thisPosition.getX(), thisPosition.getY() + 1), getAp(), this));
        } else if (pos4) {
            setAttackIntentOrNull(new AttackIntent(new IntVector2D(thisPosition.getX() - 1, thisPosition.getY()), getAp(), this));
        }













    }

    @Override
    public void onSpawn() {
        hp = HP;
    }
}
