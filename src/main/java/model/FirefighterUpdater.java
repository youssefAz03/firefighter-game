package model;

import util.Position;

import java.util.*;

public class FirefighterUpdater extends AbstractFirefighterUpdater implements Updater{

    public FirefighterUpdater(AbstractFirefighter firefighter, Elements<Set<Position>> fire, int columnCount, int rowCount) {
        super(firefighter, fire, columnCount, rowCount);
    }
}
