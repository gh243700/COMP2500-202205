package academy.pocu.comp2500.lab5;

import java.util.ArrayList;

public class Gladiator extends Barbarian {

    private final int MAX_MOVES = 4;
    private ArrayList<Move> moves;

    public Gladiator(String name, int hp, int attack, int defense) {
        super(name, hp, attack, defense);
        moves = new ArrayList<>(MAX_MOVES);
    }

    public boolean addMove(Move move) {
        if (moves.size() >= MAX_MOVES || hasMoveAt(move.getName()) != -1) {
            return false;
        }

        return moves.add(move);
    }

    public boolean removeMove(String name) {
        int index = hasMoveAt(name);

        if (index == -1) {
            return false;
        }

        moves.remove(index);
        return true;
    }

    public void attack(String moveName, Barbarian other) {
        if (hp <= 0 || this == other) {
            return;
        }


        int moveIndex = hasMoveAt(moveName);

        if (moveIndex == -1 || !moves.get(moveIndex).canUseMove()) {
            return;
        }

        other.hp = Math.max(0, other.hp - Math.max(1, (int) ((attack / (double) other.defence * moves.get(moveIndex).getPower()) / 2.0)));
    }

    public void rest() {
        for (Move move : moves) {
            move.recoverMaximumPowerByOne();
        }
        hp = Math.min(MAX_HP, hp + 10);
    }

    private int hasMoveAt(String name) {
        for (int i = 0; i < moves.size(); i++) {
            if (moves.get(i).getName().equals(name)) {
                return i;
            }
        }

        return -1;
    }
}
