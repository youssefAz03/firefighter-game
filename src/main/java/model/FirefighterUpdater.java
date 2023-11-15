package model;

import util.Position;

import java.util.*;

public class FirefighterUpdater implements Updater{

    private Elements<List<Position>> firefighter;
    private Elements<Set<Position>> fire;
    private final int columnCount;
    private final int rowCount;

    public FirefighterUpdater( Elements<List<Position>> firefighter, Elements<Set<Position>> fire, int columnCount, int rowCount) {
        this.firefighter = firefighter;
        this.fire = fire;
        this.columnCount = columnCount;
        this.rowCount = rowCount;
    }


    @Override
    public List<Position> update() {
        Neighbors neighbors = new Neighbors(columnCount,rowCount);
        List<Position> modifiedPosition = new ArrayList<>();
        List<Position> firefighterNewPositions = new ArrayList<>();

        for (Position firefighterPosition : firefighter.getPositions()) {
            Position newFirefighterPosition = neighborClosestToFire(firefighterPosition);
            firefighterNewPositions.add(newFirefighterPosition);
            extinguish(newFirefighterPosition);
            modifiedPosition.add(firefighterPosition);
            modifiedPosition.add(newFirefighterPosition);
            List<Position> neighborFirePositions = neighbors.neighbors(newFirefighterPosition).stream()
                    .filter(fire.getPositions()::contains).toList();
            for(Position firePosition : neighborFirePositions)
                extinguish(firePosition);
            modifiedPosition.addAll(neighborFirePositions);
        }
        firefighter.setPositions(firefighterNewPositions);
        return modifiedPosition;
    }
    private Position neighborClosestToFire(Position position) {
        Set<Position> seen = new HashSet<>();
        Neighbors neighborsOfPosition = new Neighbors(columnCount,rowCount);
        HashMap<Position, Position> firstMove = new HashMap<>();
        Queue<Position> toVisit = new LinkedList<>(neighborsOfPosition.neighbors(position));
        for (Position initialMove : toVisit)
            firstMove.put(initialMove, initialMove);
        while (!toVisit.isEmpty()) {
            Position current = toVisit.poll();
            if (fire.getPositions().contains(current))
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
    private void extinguish(Position position) {
        fire.getPositions().remove(position);
    }
}
