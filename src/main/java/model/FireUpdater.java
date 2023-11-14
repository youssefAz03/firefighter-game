package model;

import javafx.geometry.Pos;
import util.Position;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FireUpdater implements Updater{

    private int step;

    private Set<Position> firePositions;

    public FireUpdater(int step) {
        this.step = step;
        this.firePositions =new HashSet<>();
    }

    @Override
    public List<Position> Update() {
        return null;
    }
}
