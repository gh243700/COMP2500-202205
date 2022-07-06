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
        super(HP, SYMBOL, UNIT_TYPE, FOV, AOE, AP, ATTACKABLE_UNIT_TYPE, intVector2D, true, true);

    }

    @Override
    public void move() {

    }

    @Override
    public void think(ArrayList<Unit> units) {

    }

    @Override
    public void onSpawn() {
        SimulationManager simulationManager = SimulationManager.getInstance();
        simulationManager.registerThinkable(this);
        simulationManager.registerMovable(this);
    }
}
