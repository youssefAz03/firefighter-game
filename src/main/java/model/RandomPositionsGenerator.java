package model;

import util.Position;

import java.util.Random;

public class RandomPositionsGenerator {
    private final int columnCount;
    private final int rowCount;
    private final Random randomGenerator ;

    public RandomPositionsGenerator(int columnCount, int rowCount) {
        this.columnCount = columnCount;
        this.rowCount = rowCount;
        this.randomGenerator = new Random();
    }

    private Position randomPosition() {
        return new Position(randomGenerator.nextInt(rowCount), randomGenerator.nextInt(columnCount));
    }

}
