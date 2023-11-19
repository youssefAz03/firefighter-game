package model;

import util.Position;

import java.util.Set;

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
