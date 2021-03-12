package gametheory.assignment2;

public interface Player {

    /**
     * This method is called to reset the agent before the match
     * with another player containing several rounds
     */
    void reset();

    /**
     * This method returns the move of the player based on
     * the last move of the opponent and X values of all fields.
     * Initially, X for all fields is equal to 1 and last opponent
     * move is equal to 0
     *
     * @param opponentLastMove the last move of the opponent
     *                         varies from 0 to 3
     *                         (0 – if this is the first move)
     * @param xA               the argument X for a field A
     * @param xB               the argument X for a field B
     * @param xC               the argument X for a field C
     * @return the move of the player can be 1 for A, 2 for B
     *         and 3 for C fields
     */
    int move(int opponentLastMove, int xA, int xB, int xC);

    /**
     * This method returns your IU email
     *
     * @return your email
     */
    String getEmail();
}