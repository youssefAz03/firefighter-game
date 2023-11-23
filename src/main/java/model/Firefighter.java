package model;

import util.Position;

import java.util.List;

public class Firefighter extends FireExtinguisher implements Elements<List<Position>> {
    public Firefighter(int initialFirefighterCount) {
        super(initialFirefighterCount);
    }
}
