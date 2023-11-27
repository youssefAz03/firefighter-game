package model;

import util.Position;

import java.util.Random;

public class RandomPositionsGenerator {
    private final Board board;
    private final Random randomGenerator ;

    public RandomPositionsGenerator(Board board) {
        this.board = board;
        this.randomGenerator = new Random();
    }

    public Position randomPosition() {
        return new Position(randomGenerator.nextInt(board.rowCount()), randomGenerator.nextInt(board.columnCount()));
    }

}
