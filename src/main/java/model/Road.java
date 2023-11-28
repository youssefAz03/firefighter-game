package model;

import util.Position;

import java.util.ArrayList;
import java.util.List;

public class Road implements Elements<List<Position>> {
    private List<Position> roadsPositions;
    private int initialRoadsCount;

    public Road (int initialRoadsCount) {
        this.initialRoadsCount=initialRoadsCount;
        roadsPositions= new ArrayList<>();
    }

    @Override
    public List<Position> getPositions() {
        return roadsPositions;
    }

    @Override
    public void setPositions(List<Position> positions) {
        this.roadsPositions = positions;
    }

    @Override
    public int getInitialCount() {
        return initialRoadsCount;
    }
}
