package academy.pocu.comp2500.assignment3.app;

import academy.pocu.comp2500.assignment3.IntVector2D;
import academy.pocu.comp2500.assignment3.Marine;
import academy.pocu.comp2500.assignment3.SimulationManager;
import academy.pocu.comp2500.assignment3.Unit;

import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {
	    // write your code here
        SimulationManager simulationManager = SimulationManager.getInstance();

        Unit u0 = new Marine(new IntVector2D(5, 5));
        Unit u1 = new Marine(new IntVector2D(5, 5));
        Unit u2 = new Marine(new IntVector2D(5, 4));
        Unit u3 = new Marine(new IntVector2D(4, 5));
        Unit u4 = new Marine(new IntVector2D(6, 5));
        Unit u5 = new Marine(new IntVector2D(5, 6));

        ArrayList<Unit> units = new ArrayList<>();

        units.add(u0);
        units.add(u1);
        units.add(u2);
        units.add(u3);
        units.add(u4);
        units.add(u5);

        for (Unit unit : units) {
            simulationManager.spawn(unit);
        }


        simulationManager.update();

    }
}
