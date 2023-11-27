package model;

import util.Position;

import java.util.ArrayList;
import java.util.List;

public class Cloud implements  Elements<List<Position>> {
    private List<Position> cloudPositions;
    private final int initialCloudCount;
    public Cloud(int initialCloudCount) {
        this.initialCloudCount = initialCloudCount;
        cloudPositions = new ArrayList<>();
    }

    @Override
    public List<Position> getPositions() {
        return this.cloudPositions;
    }

    @Override
    public void setPositions(List<Position> positions) {
        this.cloudPositions = positions;
    }

    @Override
    public int getInitialCount() {
        return initialCloudCount;
    }
}
