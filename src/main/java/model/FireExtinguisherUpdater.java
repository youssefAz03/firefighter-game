package model;

import util.Position;

import java.util.*;

public abstract class FireExtinguisherUpdater implements Updater{
    private final Board board;

    public FireExtinguisherUpdater(Board board) {
        this.board = board;
    }

    public Position neighborClosestToFire(Position position) {
        Set<Position> seen = new HashSet<>();
        Neighbors neighborsOfPosition = new Neighbors(board);
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
