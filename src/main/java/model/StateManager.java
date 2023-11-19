package model;

import util.Position;

import java.util.ArrayList;
import java.util.List;

public class StateManager implements State<List<ModelElement>>{

    private Board<List<ModelElement>> board;

    public StateManager(Board<List<ModelElement>> board) {
        this.board = board;
    }

    @Override
    public List<ModelElement> getState(Position position) {
        List<ModelElement> result = new ArrayList<>();
        for (Position firefighterPosition : board.getFirefighter().getPositions())
            if (firefighterPosition.equals(position))
                result.add(ModelElement.FIREFIGHTER);
        if (board.getFire().getPositions().contains(position))
            result.add(ModelElement.FIRE);
        return result;
    }

    @Override
    public void setState(List<ModelElement> state, Position position) {
        board.getFire().getPositions().remove(position);
        for (; ; ) {
            if (!board.getFirefighter().getPositions().remove(position)) break;
        }
        for (ModelElement element : state) {
            switch (element) {
                case FIRE -> board.getFire().getPositions().add(position);
                case FIREFIGHTER -> board.getFirefighter().getPositions().add(position);
            }
        }
    }
}
