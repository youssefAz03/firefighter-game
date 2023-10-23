package view;

import javafx.scene.paint.Color;
import javafx.util.Pair;
import model.Position;

import java.util.List;

public interface Grid<E> {
  void repaint(List<Pair<Position,E>> elements);
  void repaint(E[][] elements);
  int getColumnCount();
  int getRowCount();
}
