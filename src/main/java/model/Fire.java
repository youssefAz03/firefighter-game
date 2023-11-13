package model;

import util.Position;

import java.util.ArrayList;
import java.util.List;

public class Fire implements Elements<List<Position>>{

    private final int initialFireCount;
    private List<Position> firefighterPositions;

    public Fire(int initialFireCount) {
        this.initialFireCount = initialFireCount;
        this.firefighterPositions = new ArrayList<>();
    }

    @Override
    public List<Position> getPositions() {
        return firefighterPositions;
    }

    @Override
    public void setPositions(List<Position> positions) {
        this.firefighterPositions = positions;
    }

    @Override
    public int getInitialCount() {
        return initialFireCount;
    }
}
