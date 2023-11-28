package model;

import util.Position;

import java.util.List;

public class MotorizedFirefighter extends FireExtinguisher implements Elements<List<Position>> {
    public MotorizedFirefighter(int initialMotorizedFirefighterCount) {
        super(initialMotorizedFirefighterCount);
    }
}
