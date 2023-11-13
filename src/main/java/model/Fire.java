package model;

import util.Position;

import java.util.HashSet;
import java.util.Set;

public class Fire implements Elements<Set<Position>>{

    private final int initialFireCount;
    private Set<Position> firePositions;

    public Fire(int initialFireCount) {
        this.initialFireCount = initialFireCount;
        this.firePositions = new HashSet<>();
    }

    @Override
    public Set<Position> getPositions() {
        return firePositions;
    }



    @Override
    public void setPositions(Set<Position> positions) {
        this.firePositions = positions;
    }

    @Override
    public int getInitialCount() {
        return initialFireCount;
    }
}
