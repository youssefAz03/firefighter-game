package model;

import util.Position;

import java.util.ArrayList;
import java.util.List;

public class Firefighter extends AbstractFirefighter implements Elements<List<Position>> {

    private final int initialFirefighterCount;
    private List<Position> firefighterPositions;

    public Firefighter(int initialFirefighterCount) {
        super(initialFirefighterCount);
        this.initialFirefighterCount = initialFirefighterCount;
        this.firefighterPositions = new ArrayList<>();
    }
    @Override
    public List<Position> getPositions() {
        return this.firefighterPositions;
    }

    @Override
    public void setPositions(List<Position> positions) {
        this.firefighterPositions  = positions;
    }

    @Override
    public int getInitialCount() {
        return initialFirefighterCount;
    }
}
