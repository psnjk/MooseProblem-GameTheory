package gametheory.assignment2;

import java.util.Random;

public class RandomPlayer implements Player {
    Random r;

    public RandomPlayer() {
        reset();
    }

    @Override
    public void reset() {
        r = new Random();
    }

    @Override
    public int move(int opponentLastMove, int xA, int xB, int xC) {
        return (r.nextInt(3)+1);
    }

    @Override
    public String getEmail() {
        return "RandomPlaya@jameel.ml";
    }
}
