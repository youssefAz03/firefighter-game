package model;

import util.Position;

/**
 * Represents a state manager for a board at specific positions.
 * Implementations of this interface provide methods to retrieve and set the state
 * of a position on the board.
 *
 * @param <S> The type of state represented on the board.
 */

public interface State<S>{
    /**
     * Get the state of the board at a specific position.
     *
     * @param position The position on the board for which to retrieve the state.
     * @return The state at the specified position.
     */
    S getState(Position position);

    /**
     * Set the state of a specific position on the board to the specified state.
     *
     * @param state    The state to set for the given position.
     * @param position The position on the board for which to set the state.
     */
    void setState(S state, Position position);
}
