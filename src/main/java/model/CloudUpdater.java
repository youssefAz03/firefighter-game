package model;

import util.Position;

import java.util.Set;

public class CloudUpdater extends AbstractFirefighterUpdater implements Updater{
    public CloudUpdater(AbstractFirefighter firefighter, Elements<Set<Position>> fire, int columnCount, int rowCount) {
        super(firefighter, fire, columnCount, rowCount);
    }
}
