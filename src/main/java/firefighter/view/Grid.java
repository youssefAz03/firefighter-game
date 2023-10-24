package firefighter.view;

import javafx.util.Pair;
import firefighter.util.Position;

import java.util.List;

/**
 * This interface represents a generic grid structure for displaying two-dimensional data.
 *
 * @param <E> The type of elements stored in the grid.
 */
public interface Grid<E> {

  /**
   * Repaint the grid with a list of elements, each associated with their respective positions.
   *
   * @param elements A list of pairs, each containing a position and the element to be displayed at that position.
   */
  void repaint(List<Pair<Position, E>> elements);

  /**
   * Repaint the grid with a two-dimensional array of elements. The array's dimensions should match
   * the row and column count of the grid.
   *
   * @param elements A two-dimensional array of elements to be displayed on the grid.
   */
  void repaint(E[][] elements);

  /**
   * Get the number of columns in the grid.
   *
   * @return The number of columns in the grid.
   */
  int getColumnCount();

  /**
   * Get the number of rows in the grid.
   *
   * @return The number of rows in the grid.
   */
  int getRowCount();
}

