package model;

import util.Position;

import java.util.List;

public  class BoardUpdater implements Updater {
    private final Board board;

    public BoardUpdater(Board board) {
        this.board = board;
    }

    @Override
    public List<Position> update() {
        Updater updater = new FirefighterUpdater(board);
        List<Position> modifiedPositions = updater.update();
        updater = new CloudUpdater(board);
        modifiedPositions.addAll(updater.update());
        updater = new FireUpdater(board);
        modifiedPositions.addAll(updater.update());
        board.setStep(board.stepNumber()+1);
        return modifiedPositions;    }
}
