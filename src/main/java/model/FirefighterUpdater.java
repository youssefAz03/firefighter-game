package model;

import util.Position;

import java.util.ArrayList;
import java.util.List;

public class FirefighterUpdater extends FireExtinguisherUpdater implements Updater{
    private final Board board;
    public FirefighterUpdater(Board board){
        super(board);
        this.board = board;
    }
    @Override
    public List<Position> update() {
        Neighbors neighbors = new Neighbors(board);
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
}
