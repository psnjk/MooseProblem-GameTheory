package gametheory.assignment2.students2021;

import java.util.Random;

public class GreedyPlayer implements Player {

    int myLastMove;
    Random r;

    public GreedyPlayer() {
        myLastMove = 0;
        r = new Random();
    }

    private int greedyChoice(int xA, int xB, int xC) {
        if ((xA >= xB) && (xA >= xC)) {
            if (xA == xB) {
                if (r.nextBoolean()) {
                    myLastMove = 1;
                } else {
                    myLastMove = 2;
                }
                return myLastMove;
            }
            if (xA == xC) {
                if (r.nextBoolean()) {
                    myLastMove = 1;
                } else {
                    myLastMove = 3;
                }
                return myLastMove;
            }
            myLastMove = 1;
            return myLastMove;
        }
        if ((xB >= xA) && (xB >= xC)) {
            if (xB == xA) {
                if (r.nextBoolean()) {
                    myLastMove = 2;
                } else {
                    myLastMove = 1;
                }
                return myLastMove;
            }
            if (xB == xC) {
                if (r.nextBoolean()) {
                    myLastMove = 2;
                } else {
                    myLastMove = 3;
                }
                return myLastMove;
            }
            myLastMove = 2;
            return myLastMove;
        }
        if ((xC >= xA) && (xC >= xB)) {
            if (xC == xA) {
                if (r.nextBoolean()) {
                    myLastMove = 1;
                } else {
                    myLastMove = 3;
                }
                return myLastMove;
            }
            if (xC == xB) {
                if (r.nextBoolean()) {
                    myLastMove = 3;
                } else {
                    myLastMove = 2;
                }
                return myLastMove;
            }
            myLastMove = 3;
            return myLastMove;
        }

        return r.nextInt(3) + 1;
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
