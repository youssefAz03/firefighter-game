package model;

import util.Position;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractFirefighter implements Elements<List<Position>> {

    private final int initialFirefighterCount;
    private List<Position> firefighterPositions;

    public AbstractFirefighter(int initialFirefighterCount) {
        this.initialFirefighterCount = initialFirefighterCount;
        this.firefighterPositions = new ArrayList<>();
    }

}
