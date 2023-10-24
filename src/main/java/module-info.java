module firefighter {
  requires javafx.controls;
  requires javafx.fxml;
  requires javafx.graphics;
  opens firefighter.controller to javafx.fxml;
  exports firefighter.app;
  opens firefighter.app to javafx.fxml;
}