package model;

import util.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FirefighterUpdater implements Updater{

    private int step;

    private List<Position> firefighterPositions;
    private Set<Position> firePositions;

    private final int columnCount;
    private final int rowCount;

    public FirefighterUpdater(int step, int columnCount, int rowCount) {
        this.step = step;
        this.columnCount = columnCount;
        this.rowCount = rowCount;
        this.firefighterPositions = new ArrayList<>();
    }

    @Override
    public List<Position> Update() {
        return null;
    }

    public void extinguish(Position position) {
        firePositions.remove(position);
    }
}
