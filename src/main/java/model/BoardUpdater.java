package model;

import util.Position;

import java.util.List;
import java.util.Set;

public  class BoardUpdater implements Updater {
    private final Board board;

    public BoardUpdater(Board board) {
        this.board = board;
    }

    @Override
    public List<Position> update() {
        Updater updater = new FirefighterUpdater(board.getFirefighter(), board.getFire(), board.columnCount(), board.rowCount());
        List<Position> modifiedPositions = updater.update();
        updater = new FireUpdater(board.stepNumber(), board.columnCount(), board.rowCount(), board.getFire().getPositions());
        modifiedPositions.addAll(updater.update());
        board.setStep(board.stepNumber()+1);
        return modifiedPositions;    }
}
