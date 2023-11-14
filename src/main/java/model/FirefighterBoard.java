package model;

import util.Position;

import java.util.*;


public class FirefighterBoard implements Board<List<ModelElement>> {

  private Elements<Set<Position>> fire ;
  private Elements<List<Position>> firefighter;
  private final int columnCount;
  private final int rowCount;
  private int step = 0;
  private RandomPositionsGenerator randomPositionsGenerator;

  private Updater Updater;


  public FirefighterBoard(int columnCount, int rowCount, int initialFireCount, int initialFirefighterCount) {
    this.columnCount = columnCount;
    this.rowCount = rowCount;
    this.fire = new Fire(initialFireCount);
    this.firefighter = new Firefighter(initialFirefighterCount);
    this.randomPositionsGenerator = new RandomPositionsGenerator(columnCount,rowCount);
    initializeElements();
  }

  public void initializeElements() {
    for (int index = 0; index < fire.getInitialCount(); index++)
        fire.getPositions().add(randomPositionsGenerator.randomPosition());
    for (int index = 0; index < firefighter.getInitialCount(); index++)
        firefighter.getPositions().add(randomPositionsGenerator.randomPosition());
  }

  @Override
  public List<ModelElement> getState(Position position) {
    List<ModelElement> result = new ArrayList<>();
    for(Position firefighterPosition : firefighter.getPositions())
      if (firefighterPosition.equals(position))
        result.add(ModelElement.FIREFIGHTER);
    if(fire.getPositions().contains(position))
      result.add(ModelElement.FIRE);
    return result;
  }

  @Override
  public int rowCount() {
    return rowCount;
  }

  @Override
  public int columnCount() {
    return columnCount;
  }

  public List<Position> updateToNextGeneration() {
    List<Position> modifiedPositions = updateFirefighters();
    modifiedPositions.addAll(updateFires());
    step++;
    return modifiedPositions;
  }

  private List<Position> updateFires() {
    List<Position> modifiedPositions = new ArrayList<>();
    if (step % 2 == 0) {
      List<Position> newFirePositions = new ArrayList<>();
      for (Position fire : fire.getPositions()) {
        newFirePositions.addAll(neighbors(fire));
      }
      fire.getPositions().addAll(newFirePositions);
      modifiedPositions.addAll(newFirePositions);
    }
    return modifiedPositions;

  }

  @Override
  public int stepNumber() {
    return step;
  }

  private List<Position> updateFirefighters() {
    List<Position> modifiedPosition = new ArrayList<>();
    List<Position> firefighterNewPositions = new ArrayList<>();
    for (Position firefighterPosition : firefighter.getPositions()) {
      Position newFirefighterPosition = neighborClosestToFire(firefighterPosition);
      firefighterNewPositions.add(newFirefighterPosition);
      extinguish(newFirefighterPosition);
      modifiedPosition.add(firefighterPosition);
      modifiedPosition.add(newFirefighterPosition);
      List<Position> neighborFirePositions = neighbors(newFirefighterPosition).stream()
              .filter(fire.getPositions()::contains).toList();
      for(Position firePosition : neighborFirePositions)
        extinguish(firePosition);
      modifiedPosition.addAll(neighborFirePositions);
    }
    firefighter.setPositions(firefighterNewPositions);
    return modifiedPosition;
  }

  @Override
  public void reset() {
    step = 0;
    initializeElements();
  }

  private void extinguish(Position position) {
    fire.getPositions().remove(position);
  }

  private List<Position> neighbors(Position position) {
    Neighbors neighborsOfPosition = new Neighbors(columnCount,rowCount);
    return neighborsOfPosition.neighbors(position);
  }

  private Position neighborClosestToFire(Position position) {
    Set<Position> seen = new HashSet<>();
    HashMap<Position, Position> firstMove = new HashMap<>();
    Queue<Position> toVisit = new LinkedList<>(neighbors(position));
    for (Position initialMove : toVisit)
      firstMove.put(initialMove, initialMove);
    while (!toVisit.isEmpty()) {
      Position current = toVisit.poll();
      if (fire.getPositions().contains(current))
        return firstMove.get(current);
      for (Position adjacent : neighbors(current)) {
        if (seen.contains(adjacent)) continue;
        toVisit.add(adjacent);
        seen.add(adjacent);
        firstMove.put(adjacent, firstMove.get(current));
      }
    }
    return position;
  }

  @Override
  public void setState(List<ModelElement> state, Position position) {
    fire.getPositions().remove(position);
    for (;;) {
      if (!firefighter.getPositions().remove(position)) break;
    }
    for(ModelElement element : state){
      switch (element){
        case FIRE -> fire.getPositions().add(position);
        case FIREFIGHTER -> firefighter.getPositions().add(position);
      }
    }
  }
}