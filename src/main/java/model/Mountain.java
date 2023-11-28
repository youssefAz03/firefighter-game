package model;

import util.Position;

import java.util.ArrayList;
import java.util.List;

public class Mountain implements Elements<List<Position>>{
    private final int initialMountainCount;
    private List<Position> mountainPositions;

    public Mountain(int initialMountainCount) {
        this.initialMountainCount = initialMountainCount;
        this.mountainPositions = new ArrayList<>();
    }

    @Override
    public List<Position> getPositions() {
        return mountainPositions;
    }

    @Override
    public void setPositions(List<Position> positions) {
        mountainPositions = positions;
    }

    @Override
    public int getInitialCount() {
        return initialMountainCount;
    }
}
