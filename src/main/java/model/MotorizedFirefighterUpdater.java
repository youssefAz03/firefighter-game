package model;

import util.Position;

import java.util.*;

public class MotorizedFirefighterUpdater extends FireExtinguisherUpdater implements Updater{
    private final Board board;
    public MotorizedFirefighterUpdater(Board board) {
        super(board);
        this.board = board;
    }

    @Override
    public List<Position> update() {
        Neighbors neighbors = new Neighbors(board);
        List<Position> modifiedPosition = new ArrayList<>();
        List<Position> motorizedFirefighterNewPositions = new ArrayList<>();

        for (Position motorizedFirefighterPosition : board.getMotorizedFirefighter().getPositions()) {
            Position newMotorizedFirefighterPosition = this.neighborClosestToFire(motorizedFirefighterPosition,2);
            motorizedFirefighterNewPositions.add(newMotorizedFirefighterPosition);
            extinguish(newMotorizedFirefighterPosition);
            modifiedPosition.add(motorizedFirefighterPosition);
            modifiedPosition.add(newMotorizedFirefighterPosition);
            List<Position> neighborFirePositions = neighbors.neighbors(newMotorizedFirefighterPosition,2).stream()
                    .filter(board.getFire().getPositions()::contains).toList();
            for(Position firePosition : neighborFirePositions)
                extinguish(firePosition);
            modifiedPosition.addAll(neighborFirePositions);
        }
        this.restraintFireExtinguisher(modifiedPosition);
        board.getMotorizedFirefighter().setPositions(motorizedFirefighterNewPositions);
        return modifiedPosition;
    }
}
