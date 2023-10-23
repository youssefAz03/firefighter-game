package model;

import java.util.List;

public interface Board<S> {
  S getState(Position position);
  int rowCount();
  int columnCount();
  List<Position> updateToNextGeneration();
  void reset();
}
