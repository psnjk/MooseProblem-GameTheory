package gametheory.assignment2.students2021;

import java.util.Comparator;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GreedyPlayer implements Player {

    int myLastMove;
    Random r;

    public GreedyPlayer() {
        myLastMove = 0;
    }

    private int greedyChoice(int xA, int xB, int xC) {
        int[] greed = new int[]{xA,xB,xC};
        int max = IntStream.range(0, greed.length).boxed().max(Comparator.comparingInt(o -> greed[o])).get();

        return max+1;
    }

    @Override
    public void reset() {

    }

    @Override
    public int move(int opponentLastMove, int xA, int xB, int xC) {
        return greedyChoice(xA,xB,xC);
    }

    @Override
    public String getEmail() {
        return "GreedyPlaya@jameel.ml";
    }
}
