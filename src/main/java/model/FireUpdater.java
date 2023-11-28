package model;

import util.Position;

import java.util.ArrayList;
import java.util.List;

public class FireUpdater implements Updater{

    private final Board board;


    public FireUpdater(Board board) {
        this.board = board;
    }

    @Override
    public List<Position> update() {
        Neighbors neighborsPosition = new Neighbors(board);

        List<Position> modifiedPositions = new ArrayList<>();
        if (board.stepNumber() % 2 == 0) {
            List<Position> newFirePositions = new ArrayList<>();
            for (Position fire : board.getFire().getPositions()) {
                for(Position neighborsPositions : neighborsPosition.neighbors(fire , 1)) {
                    if (!board.getRoad().getPositions().contains(neighborsPosition)) {
                        newFirePositions.add(neighborsPositions);
                    }
                }
            }
            board.getFire().getPositions().addAll(newFirePositions);
            modifiedPositions.addAll(newFirePositions);
        }
        modifiedPositions.removeAll(board.getMountain().getPositions());
        return modifiedPositions;
    }
}
