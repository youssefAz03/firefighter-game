package model;

import util.Position;

import java.util.List;
import java.util.Set;

/**
 * This interface represents a generic board for modeling various state-based systems.
 *
 * @param <S> The type of state represented on the board.
 */
public interface Board<S> {

    /**
     * Get the number of rows in the board.
     *
     * @return The number of rows in the board.
     */
    int rowCount();

    /**
     * Get the number of columns in the board.
     *
     * @return The number of columns in the board.
     */
    int columnCount();

    /**
     * Update the board to its next generation or state. This method may modify the
     * internal state of the board and return a list of positions that have changed
     * during the update.
     *
     * @return A list of positions that have changed during the update.
     */
    List<Position> updateToNextGeneration();

    /**
     * Reset the board to its initial state.
     */
    void reset();

    /**
     * Get the current step number or generation of the board.
     *
     * @return The current step number or generation.
     */
    int stepNumber();

    /**
     * Get the element representing the positions of firefighters on the board.
     *
     * @return The element containing the positions of firefighters.
     */
    Elements<List<Position>> getFirefighter();

    /**
     * Get the element representing the positions of fire on the board.
     *
     * @return The element containing the positions of fire.
     */
    Elements<Set<Position>> getFire();

}

