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
                newFirePositions.addAll(neighborsPosition.neighbors(fire,1));
            }
            board.getFire().getPositions().addAll(newFirePositions);
            modifiedPositions.addAll(newFirePositions);
        }
        return modifiedPositions;
    }
}
