package gametheory.assignment2.students2021;

import java.util.Random;

public class JameelMukhutdinovCode implements Player {
    int state;
    int myCell;
    int bufferCell;
    int myLastMove;
    int temp;
    Random r;

    public JameelMukhutdinovCode() {
        reset();
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

        return r.nextInt(3)+1;
    }

    @Override
    public void reset() {
        state = 0;
        this.myCell = 0;
        this.bufferCell = 0;
        this.myLastMove = 0;
        r = new Random();
        temp = 0;
    }

    /**
     * state:
     * 0 - Starting state, cooperation is supposed
     * 1 - Cooperation, waiting and eating cycle
     * 2 - Cooperation is violated, greedy algorithm
     *
     * @param opponentLastMove the last move of the opponent
     *                         varies from 0 to 3
     *                         (0 – if this is the first move)
     * @param xA               the argument X for a field A
     * @param xB               the argument X for a field B
     * @param xC               the argument X for a field C
     * @return
     */
    @Override
    public int move(int opponentLastMove, int xA, int xB, int xC) {
        if ((myLastMove != opponentLastMove) && state == 0) {
            state = 1;
            myCell = myLastMove;
            if ((myLastMove == 1 && opponentLastMove == 2) || (myLastMove == 2 && opponentLastMove == 1)) {
                bufferCell = 3;
            }
            if ((myLastMove == 3 && opponentLastMove == 2) || (myLastMove == 2 && opponentLastMove == 3)) {
                bufferCell = 1;
            }
            if ((myLastMove == 1 && opponentLastMove == 3) || (myLastMove == 3 && opponentLastMove == 1)) {
                bufferCell = 2;
            }
        }
        switch (state) {
            case (0): {
                myLastMove = r.nextInt(3) + 1;
                return myLastMove;
            }

            case (1): {
                if (opponentLastMove == myCell) {
                    state = 2;
                }
                switch (myCell) {
                    case (1):
                        temp = xA;
                        break;
                    case (2):
                        temp = xB;
                        break;
                    case (3):
                        temp = xC;
                        break;
                }
                if (temp < 6) {
                    myLastMove = bufferCell;
                } else {
                    myLastMove = myCell;
                }
                return myLastMove;
            }

            case (2): {
                return greedyChoice(xA,xB,xC);
            }
        }
        return 0;
    }

    @Override
    public String getEmail() {
        return "d.muhutdinov@innopolis.university";
    }
}
