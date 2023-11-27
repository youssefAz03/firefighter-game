package model;

import util.Position;

import java.util.*;


public class FirefighterBoard implements Board {

    private final Elements<Set<Position>> fire;
    private final FireExtinguisher firefighter;
    private final Elements<List<Position>> cloud;
    private final int columnCount;
    private final int rowCount;
    private int step = 0;
    private final RandomPositionsGenerator randomPositionsGenerator;


    public FirefighterBoard(int columnCount, int rowCount, int initialFireCount, int initialFirefighterCount) {
        this.columnCount = columnCount;
        this.rowCount = rowCount;
        this.fire = new Fire(initialFireCount);
        this.firefighter = new Firefighter(initialFirefighterCount);
        this.cloud = new Cloud(initialFirefighterCount);
        this.randomPositionsGenerator = new RandomPositionsGenerator(this);
        initializeElements();
    }

    public void initializeElements() {
        fire.setPositions(new HashSet<>());
        firefighter.setPositions(new ArrayList<>());
        cloud.setPositions(new ArrayList<>());
        for (int index = 0; index < fire.getInitialCount(); index++)
            fire.getPositions().add(randomPositionsGenerator.randomPosition());
        for (int index = 0; index < firefighter.getInitialCount(); index++)
            firefighter.getPositions().add(randomPositionsGenerator.randomPosition());
        for (int index = 0; index < cloud.getInitialCount(); index++)
            cloud.getPositions().add(randomPositionsGenerator.randomPosition());
    }

    @Override
    public int rowCount() {
        return rowCount;
    }

    @Override
    public int columnCount() {
        return columnCount;
    }

    @Override
    public Elements<Set<Position>> getFire() {
        return fire;
    }

    @Override
    public FireExtinguisher getFirefighter() {
        return firefighter;
    }

    @Override
    public Elements<List<Position>> getCloud() {
        return cloud;
    }

    @Override
    public int stepNumber() {
        return step;
    }
    @Override
    public void setStep(int step) {
        this.step = step;
    }

    @Override
    public void reset() {
        step = 0;
        initializeElements();
    }

}