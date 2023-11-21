package model;

import util.Position;

import java.util.ArrayList;
import java.util.List;

public class Firefighter extends AbstractFirefighter implements Elements<List<Position>> {
    public Firefighter(int initialFirefighterCount) {
        super(initialFirefighterCount);
    }
}
