package model;

import util.Position;

import java.util.*;

public class CloudUpdater extends FireExtinguisherUpdater implements Updater {
    private final Board board;
    public CloudUpdater(Board board) {
        super(board);
        this.board = board;
    }

    @Override
    public List<Position> update() {
        Neighbors neighbors = new Neighbors(board);
        List<Position> modifiedPosition = new ArrayList<>();
        List<Position> cloudPositions = new ArrayList<>();
        RandomPositionsGenerator randomPositionsGenerator = new RandomPositionsGenerator(board);

        for (Position cloudPosition : board.getCloud().getPositions()) {
            Position newCloudPosition = randomPositionsGenerator.randomPosition();
            cloudPositions.add(newCloudPosition);
            extinguish(newCloudPosition);
            modifiedPosition.add(cloudPosition);
            modifiedPosition.add(newCloudPosition);
            List<Position> neighborFirePositions = neighbors.neighbors(newCloudPosition,1).stream()
                    .filter(board.getFire().getPositions()::contains).toList();
            for(Position firePosition : neighborFirePositions)
                extinguish(firePosition);
            modifiedPosition.addAll(neighborFirePositions);
        }
        board.getCloud().setPositions(cloudPositions);
        return modifiedPosition;
    }
}
