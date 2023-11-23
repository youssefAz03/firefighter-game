package model;

import util.Position;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FireUpdater implements Updater{

    private Board board;


    public FireUpdater(Board board) {
        this.board = board;
    }

    @Override
    public List<Position> update() {
        Neighbors neighborsPosition = new Neighbors(board.columnCount(), board.rowCount());

        List<Position> modifiedPositions = new ArrayList<>();
        if (board.stepNumber() % 2 == 0) {
            List<Position> newFirePositions = new ArrayList<>();
            for (Position fire : board.getFire().getPositions()) {
                newFirePositions.addAll(neighborsPosition.neighbors(fire));
            }
            board.getFire().getPositions().addAll(newFirePositions);
            modifiedPositions.addAll(newFirePositions);
        }
        return modifiedPositions;
    }
}
