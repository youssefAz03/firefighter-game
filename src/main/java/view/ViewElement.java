package view;

import javafx.scene.paint.Color;
import model.Road;

public enum ViewElement {
  FIREFIGHTER(Color.BLUE), FIRE(Color.RED), EMPTY(Color.WHITE), CLOUD(Color.GRAY),MOTORIZEDFIREFIGHTER(Color.AQUA), ROAD(Color.BLACK);
  final Color color;
  ViewElement(Color color) {
    this.color = color;
  }
}
