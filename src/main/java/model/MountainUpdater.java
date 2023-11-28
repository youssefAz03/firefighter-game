package model;

import util.Position;

import java.util.List;

public class MountainUpdater implements Updater{
    private final Board board;

    public MountainUpdater(Board board) {
        this.board = board;
    }

    @Override
    public List<Position> update() {
        return board.getMountain().getPositions();
    }
}
