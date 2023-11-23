package model;

import util.Position;
import java.util.List;

public class Cloud extends AbstractFirefighter implements  Elements<List<Position>> {
    public Cloud(int initialCloudCount) {
        super(initialCloudCount);
    }

}
