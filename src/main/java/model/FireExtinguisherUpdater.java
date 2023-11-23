package model;

import util.Position;

import java.util.*;

public abstract class FireExtinguisherUpdater implements Updater{
    private final Board board;

    public FireExtinguisherUpdater(Board board) {
        this.board = board;
    }
    @Override
    public List<Position> update() {
        Neighbors neighbors = new Neighbors(board.columnCount(), board.rowCount());
        List<Position> modifiedPosition = new ArrayList<>();
        List<Position> firefighterNewPositions = new ArrayList<>();

        for (Position firefighterPosition : board.getFirefighter().getPositions()) {
            Position newFirefighterPosition = neighborClosestToFire(firefighterPosition);
            firefighterNewPositions.add(newFirefighterPosition);
            extinguish(newFirefighterPosition);
            modifiedPosition.add(firefighterPosition);
            modifiedPosition.add(newFirefighterPosition);
            List<Position> neighborFirePositions = neighbors.neighbors(newFirefighterPosition).stream()
                    .filter(board.getFire().getPositions()::contains).toList();
            for(Position firePosition : neighborFirePositions)
                extinguish(firePosition);
            modifiedPosition.addAll(neighborFirePositions);
        }
        board.getFirefighter().setPositions(firefighterNewPositions);
        return modifiedPosition;
    }
    public Position neighborClosestToFire(Position position) {
        Set<Position> seen = new HashSet<>();
        Neighbors neighborsOfPosition = new Neighbors(board.columnCount(), board.rowCount());
        HashMap<Position, Position> firstMove = new HashMap<>();
        Queue<Position> toVisit = new LinkedList<>(neighborsOfPosition.neighbors(position));
        for (Position initialMove : toVisit)
            firstMove.put(initialMove, initialMove);
        while (!toVisit.isEmpty()) {
            Position current = toVisit.poll();
            if (board.getFire().getPositions().contains(current))
                return firstMove.get(current);
            for (Position adjacent : neighborsOfPosition.neighbors(current)) {
                if (seen.contains(adjacent)) continue;
                toVisit.add(adjacent);
                seen.add(adjacent);
                firstMove.put(adjacent, firstMove.get(current));
            }
        }
        return position;
    }
    public void extinguish(Position position) {
        board.getFire().getPositions().remove(position);
    }
}
