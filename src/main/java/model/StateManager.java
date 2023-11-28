package model;

import util.Position;

import java.util.ArrayList;
import java.util.List;

public class StateManager implements State<List<ModelElement>>{

    private final Board board;

    public StateManager(Board board) {
        this.board = board;
    }

    @Override
    public List<ModelElement> getState(Position position) {
        List<ModelElement> result = new ArrayList<>();
        for (Position firefighterPosition : board.getFirefighter().getPositions())
            if (firefighterPosition.equals(position))
                result.add(ModelElement.FIREFIGHTER);
        for (Position cloudPosition : board.getCloud().getPositions())
            if (cloudPosition.equals(position))
                result.add(ModelElement.CLOUD);
        for (Position motorizedFirefighterPosition : board.getMotorizedFirefighter().getPositions())
            if (motorizedFirefighterPosition.equals(position))
                result.add(ModelElement.MOTORIZEDFIREFIGHTER);
        if (board.getFire().getPositions().contains(position))
            result.add(ModelElement.FIRE);
        return result;
    }

    @Override
    public void setState(List<ModelElement> state, Position position) {
        board.getFire().getPositions().remove(position);
        for (; ; ) {
            if (!board.getFirefighter().getPositions().remove(position)) break;
            if (!board.getCloud().getPositions().remove(position)) break;
            if (!board.getMotorizedFirefighter().getPositions().remove(position)) break;
        }
        for (ModelElement element : state) {
            switch (element) {
                case FIRE -> board.getFire().getPositions().add(position);
                case FIREFIGHTER -> board.getFirefighter().getPositions().add(position);
                case CLOUD -> board.getCloud().getPositions().add(position);
                case MOTORIZEDFIREFIGHTER -> board.getMotorizedFirefighter().getPositions().add(position);

            }
        }
    }
}
