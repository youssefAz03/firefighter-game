package model;

import util.Position;

import java.util.*;


public class FirefightingBoard implements Board {

    private final Elements<Set<Position>> fire;
    private final FireExtinguisher firefighter;
    private final Elements<List<Position>> cloud;
    private final Elements<List<Position>> road;
    private final FireExtinguisher motorizedFirefighter;
    private final Elements<List<Position>> mountain;
    private final int columnCount;
    private final int rowCount;
    private int step = 0;
    private final RandomPositionsGenerator randomPositionsGenerator;


    public FirefightingBoard(int columnCount, int rowCount, int initialFireCount, int initialFirefighterCount, int initialCloudCount , int initialRoadscount, int initialMotorizedFirefighterCount, int initialMountainCount) {
        this.columnCount = columnCount;
        this.rowCount = rowCount;
        this.road = new Road(initialRoadscount);
        this.fire = new Fire(initialFireCount);
        this.firefighter = new Firefighter(initialFirefighterCount);
        this.cloud = new Cloud(initialCloudCount);
        this.motorizedFirefighter = new MotorizedFirefighter(initialMotorizedFirefighterCount);
        this.mountain = new Mountain(initialMountainCount);
        this.randomPositionsGenerator = new RandomPositionsGenerator(this);
        initializeElements();
    }

    public void initializeElements() {
        fire.setPositions(new HashSet<>());
        firefighter.setPositions(new ArrayList<>());
        cloud.setPositions(new ArrayList<>());
        road.setPositions(new ArrayList<>());
        motorizedFirefighter.setPositions(new ArrayList<>());
        mountain.setPositions(new ArrayList<>());
        for (int index = 0; index < fire.getInitialCount(); index++)
            fire.getPositions().add(randomPositionsGenerator.randomPosition());
        for (int index = 0; index < firefighter.getInitialCount(); index++)
            firefighter.getPositions().add(randomPositionsGenerator.randomPosition());
        for (int index = 0; index < motorizedFirefighter.getInitialCount(); index++)
            motorizedFirefighter.getPositions().add(randomPositionsGenerator.randomPosition());
        for (int index = 0; index < mountain.getInitialCount(); index++)
            mountain.getPositions().add(randomPositionsGenerator.randomPosition());
        for (int index = 0; index < cloud.getInitialCount(); index++)
            cloud.getPositions().add(randomPositionsGenerator.randomPosition());
        for(int index = 0;index<road.getInitialCount();index++)
            road.getPositions().add(randomPositionsGenerator.randomPosition());
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
    public FireExtinguisher getMotorizedFirefighter() {
        return motorizedFirefighter;
    }


    @Override
    public FireExtinguisher getFirefighter() {
        return firefighter;
    }

    @Override
    public Elements<List<Position>> getCloud() {
        return cloud;
    }

    public Elements<List<Position>> getRoad() {
        return road;
    }

    @Override
    public Elements<List<Position>> getMountain() {
        return mountain;
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