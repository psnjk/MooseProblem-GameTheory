package gametheory.assignment2.students2021;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomGreedyPlayer implements Player{
    int randArgMax(int... xs) {
        if (xs.length <= 0) return -1;

        int maxVal = Arrays.stream(xs).max().orElse(-1);
        int[] filtered = IntStream.range(0, xs.length).filter(o -> xs[o] == maxVal).toArray();
        Random rand = new Random();
        return filtered[rand.nextInt(filtered.length)];
    }

    @Override
    public void reset() {

    }

    @Override
    public int move(int opponentLastMove, int xA, int xB, int xC) {
        int out = randArgMax(xA,xB,xC);
        return out+1;
    }

    @Override
    public String getEmail() {
        return "RandomGreedyPlaya@jameel.ml";
    }
}
