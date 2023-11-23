package model;

import util.Position;
import java.util.List;

public class Cloud extends FireExtinguisher implements  Elements<List<Position>> {
    public Cloud(int initialCloudCount) {
        super(initialCloudCount);
    }

}
