package model;

import util.Position;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FireUpdater implements Updater{

    private int step;
    private Set<Position> firePositions;
    private final int columnCount;
    private final int rowCount;


    public FireUpdater(int step, int columnCount, int rowCount , Set<Position> firePositions) {
        this.step = step;
        this.columnCount = columnCount;
        this.rowCount = rowCount;
        this.firePositions = firePositions;
    }

    @Override
    public List<Position> update() {
        Neighbors neighborsPosition = new Neighbors(columnCount,rowCount);

        List<Position> modifiedPositions = new ArrayList<>();
        if (step % 2 == 0) {
            List<Position> newFirePositions = new ArrayList<>();
            for (Position fire : firePositions) {
                newFirePositions.addAll(neighborsPosition.neighbors(fire));
            }
            firePositions.addAll(newFirePositions);
            modifiedPositions.addAll(newFirePositions);
        }
        return modifiedPositions;
    }
}
