package model;

import util.Position;

import java.util.List;
import java.util.Set;

/**
 * This interface represents a board for modeling various state-based systems.
 *
 */
public interface Board {

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
     * Set the step number of the board to the specified value.
     *
     * @param step The step number to be set for the board.
     */
    void setStep(int step);

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
    FireExtinguisher getFirefighter();
    /**
     * Retrieve the element containing the positions of clouds on the board.
     *
     * @return The element representing the positions of clouds.
     */
    Elements<List<Position>> getCloud();

    /**
     * Get the element representing the positions of fire on the board.
     *
     * @return The element containing the positions of fire.
     */
    Elements<Set<Position>> getFire();

    FireExtinguisher getMotorizedFirefighter();

    Elements<List<Position>> getRoad();
}

