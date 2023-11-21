package model;

import util.Position;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractFirefighter implements Elements<List<Position>> {

    private final int initialCount;
    private List<Position> Positions;

    public AbstractFirefighter(int initialCount) {
        this.initialCount = initialCount;
        this.Positions = new ArrayList<>();
    }
    @Override
    public List<Position> getPositions() {
        return this.Positions;
    }

    @Override
    public void setPositions(List<Position> positions) {
        this.Positions = positions;
    }

    @Override
    public int getInitialCount() {
        return initialCount;
    }

}
