package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;

public final class SimulationManager {
    private static SimulationManager simulationManager;
    private ArrayList<Unit> units = new ArrayList<>();
    private ArrayList<IThinkable> thinkableUnits = new ArrayList<>();
    private ArrayList<IMovable> movableUnits = new ArrayList<>();

    public static SimulationManager getInstance() {
        if (simulationManager != null) {
            return simulationManager;
        }

        simulationManager = new SimulationManager();
        return simulationManager;
    }

    public ArrayList<Unit> getUnits() {
        return units;
    }

    public void spawn(Unit unit) {
        units.add(unit);
        unit.onSpawn();
    }

    public void registerThinkable(IThinkable iThinkable) {
        thinkableUnits.add(iThinkable);
    }

    public void registerMovable(IMovable iMovable) {
        movableUnits.add(iMovable);
    }

    public void registerCollisionEventListener(Unit listener) {

    }

    public void update() {
        for(IThinkable iThinkable : thinkableUnits) {
            iThinkable.think(units);
        }

    }
}