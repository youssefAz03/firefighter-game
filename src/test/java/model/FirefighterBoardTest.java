package model;

import org.junit.jupiter.api.Test;
import util.Position;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class FirefighterBoardTest {
  @Test
  void testColumnCount(){
    Board board = new FirefightingBoard(20, 10, 1, 3,3,3,3,3);
    assertThat(board.columnCount()).isEqualTo(20);
  }
  @Test
  void testRowCount(){
    Board board = new FirefightingBoard(20, 10, 1, 3,3,3,3,3);
    assertThat(board.rowCount()).isEqualTo(10);
  }
  @Test
  void testStepNumber(){
    Board board = new FirefightingBoard(20, 10, 1, 3,3,3,3,3);
    Updater updater = new BoardUpdater(board);
    for(int index = 0; index < 10; index++){
      assertThat(board.stepNumber()).isEqualTo(index);
      updater.update();
    }
    assertThat(board.stepNumber()).isEqualTo(10);
  }
  @Test
  void testGetState_afterSet(){
    Board board = new FirefightingBoard(20, 10, 1, 3,3,3,3,3);
    State<List<ModelElement>> state = new StateManager(board);
    Position position = new Position(1,2);
    assertThat(state.getState(position)).isEmpty();
    state.setState(List.of(ModelElement.FIRE), position);
    assertThat(state.getState(position)).containsExactly(ModelElement.FIRE);
  }

}
