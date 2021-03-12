package gametheory.assignment2.students2021;

import java.util.ArrayList;

public class JameelMukhutdinovTest {

    public static double[] play(Player A, Player B, int rounds) {
        double[] out = new double[2];
        int xA = 1, xB = 1, xC = 1;
        int AMove = 0, BMove = 0, temp1, temp2;

        for (int i = 0; i < rounds; i++) {

            temp1 = A.move(BMove, xA, xB, xC);
            temp2 = B.move(AMove, xA, xB, xC);
            AMove = temp1;
            BMove = temp2;
            if (AMove == 1 && BMove == 1) {
                xA--;
                xB++;
                xC++;
            }
            if (AMove == 2 && BMove == 2) {
                xA++;
                xB--;
                xC++;
            }
            if (AMove == 3 && BMove == 3) {
                xA++;
                xB++;
                xC--;
            }
            if (AMove == 1 && BMove == 2) {
                out[0] += calculate(xA);
                out[1] += calculate(xB);

                xA--;
                xB--;
                xC++;
            }
            if (AMove == 1 && BMove == 3) {
                out[0] += calculate(xA);
                out[1] += calculate(xC);

                xA--;
                xB++;
                xC--;
            }
            if (AMove == 2 && BMove == 1) {
                out[0] += calculate(xB);
                out[1] += calculate(xA);

                xA--;
                xB--;
                xC++;
            }
            if (AMove == 2 && BMove == 3) {
                out[0] += calculate(xB);
                out[1] += calculate(xC);

                xA++;
                xB--;
                xC--;
            }
            if (AMove == 3 && BMove == 1) {
                out[0] += calculate(xC);
                out[1] += calculate(xA);

                xA--;
                xB++;
                xC--;
            }
            if (AMove == 3 && BMove == 2) {
                out[0] += calculate(xC);
                out[1] += calculate(xB);

                xA++;
                xB--;
                xC--;
            }
            if (xA == -1) {
                xA = 0;
            }
            if (xB == -1) {
                xB = 0;
            }
            if (xC == -1) {
                xC = 0;
            }
        }

        A.reset();
        B.reset();
        return out;
    }

    public static double calculate(int x) {
        double out = (10 * Math.exp(x)) / (1 + Math.exp(x));
        return out;
    }

    public static double getSum(ArrayList<Double> list) {
        double sum = 0;
        for (Double d : list)
            sum += d;
        return sum;
    }

    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<Player>();
        int rounds = 100;
        int strategies1 = 0;
        int strategies2 = 30;
        int strategies3 = 30;
        int strategies4 = 30;
        double[] a;
        for (int i = 0; i < strategies1; i++) {
            players.add(new JameelMukhutdinovCode());
        }
        for (int i = 0; i < strategies2; i++) {
            players.add(new GreedyPlayer());
        }
        for (int i = 0; i < strategies3; i++) {
            players.add(new RandomPlayer());
        }
        for (int i = 0; i < strategies4; i++) {
            players.add(new RandomGreedyPlayer());
        }

        ArrayList<Double> playerStats = new ArrayList<Double>();
        ArrayList<Double> greedyStats = new ArrayList<Double>();
        ArrayList<Double> randomStats = new ArrayList<Double>();
        ArrayList<Double> randomGreedyStats = new ArrayList<Double>();

        System.out.println(players.size());

        for (int p = 0; p < players.size(); p++) {
            for (int o = 0; o < (players.size()); o++) {
                if (p != o) {
                    a = play(players.get(p), players.get(o), rounds);
                    switch (players.get(p).getEmail()) {
                        case ("d.muhutdinov@innopolis.university"):
                            playerStats.add(a[0]);
                            break;
                        case ("GreedyPlaya@jameel.ml"):
                            greedyStats.add(a[0]);
                            break;
                        case ("RandomPlaya@jameel.ml"):
                            randomStats.add(a[0]);
                            break;
                        case ("RandomGreedyPlaya@jameel.ml"):
                            randomGreedyStats.add(a[0]);
                            break;
                        default:
                            System.out.println("WTF");
                    }
                    switch (players.get(o).getEmail()) {
                        case ("d.muhutdinov@innopolis.university"):
                            playerStats.add(a[1]);
                            break;
                        case ("GreedyPlaya@jameel.ml"):
                            greedyStats.add(a[1]);
                            break;
                        case ("RandomPlaya@jameel.ml"):
                            randomStats.add(a[1]);
                            break;
                        case ("RandomGreedyPlaya@jameel.ml"):
                            randomGreedyStats.add(a[1]);
                            break;
                        default:
                            System.out.println("WTF");
                    }
                }
            }
        }

        //System.out.println("Player strategy sum = " + getSum(playerStats));
        //System.out.println("Player strategy avg = " + getSum(playerStats)/playerStats.size() + " for " + playerStats.size());
        System.out.println("Greedy strategy sum = " + getSum(greedyStats));
        System.out.println("Greedy strategy avg = " + getSum(greedyStats) / greedyStats.size() + " for " + greedyStats.size());
        System.out.println("Random strategy sum = " + getSum(randomStats));
        System.out.println("Random strategy avg = " + getSum(randomStats) / randomStats.size() + " for " + randomStats.size());
        System.out.println("RandomGreedy strategy sum = " + getSum(randomGreedyStats));
        System.out.println("RandomGreedy strategy avg = " + getSum(randomGreedyStats) / randomGreedyStats.size() + " for " + randomGreedyStats.size());

    }
}
