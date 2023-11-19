package model;

import util.Position;

import java.util.*;


public class FirefighterBoard implements Board {

    private final Elements<Set<Position>> fire;
    private final Elements<List<Position>> firefighter;
    private final int columnCount;
    private final int rowCount;
    private int step = 0;
    private final RandomPositionsGenerator randomPositionsGenerator;


    public FirefighterBoard(int columnCount, int rowCount, int initialFireCount, int initialFirefighterCount) {
        this.columnCount = columnCount;
        this.rowCount = rowCount;
        this.fire = new Fire(initialFireCount);
        this.firefighter = new Firefighter(initialFirefighterCount);
        this.randomPositionsGenerator = new RandomPositionsGenerator(columnCount, rowCount);
        initializeElements();
    }

    public void initializeElements() {
        fire.setPositions(new HashSet<>());
        firefighter.setPositions(new ArrayList<>());
        for (int index = 0; index < fire.getInitialCount(); index++)
            fire.getPositions().add(randomPositionsGenerator.randomPosition());
        for (int index = 0; index < firefighter.getInitialCount(); index++)
            firefighter.getPositions().add(randomPositionsGenerator.randomPosition());
    }

//    @Override
    /*public List<ModelElement> getState(Position position) {
        List<ModelElement> result = new ArrayList<>();
        for (Position firefighterPosition : firefighter.getPositions())
            if (firefighterPosition.equals(position))
                result.add(ModelElement.FIREFIGHTER);
        if (fire.getPositions().contains(position))
            result.add(ModelElement.FIRE);
        return result;
    }*/

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
    public Elements<List<Position>> getFirefighter() {
        return firefighter;
    }

    public List<Position> updateToNextGeneration() {
        Updater updater = new FirefighterUpdater(firefighter, fire, columnCount, rowCount);
        List<Position> modifiedPositions = updater.update();
        updater = new FireUpdater(step, columnCount, rowCount, fire.getPositions());
        modifiedPositions.addAll(updater.update());
        step++;
        return modifiedPositions;
    }

    @Override
    public int stepNumber() {
        return step;
    }

    @Override
    public void reset() {
        step = 0;
        initializeElements();
    }

   /* @Override
    public void setState(List<ModelElement> state, Position position) {
        fire.getPositions().remove(position);
        for (; ; ) {
            if (!firefighter.getPositions().remove(position)) break;
        }
        for (ModelElement element : state) {
            switch (element) {
                case FIRE -> fire.getPositions().add(position);
                case FIREFIGHTER -> firefighter.getPositions().add(position);
            }
        }
    }*/
}