package model;

import util.Position;

import java.util.ArrayList;
import java.util.List;

public class Neighbors {

    private final int columnCount;
    private final int rowCount;

    public Neighbors(int columnCount, int rowCount) {
        this.columnCount = columnCount;
        this.rowCount = rowCount;
    }

    public List<Position> neighbors(Position position) {
        List<Position> list = new ArrayList<>();
        if (position.row() > 0) list.add(new Position(position.row() - 1, position.column()));
        if (position.column() > 0) list.add(new Position(position.row(), position.column() - 1));
        if (position.row() < rowCount - 1) list.add(new Position(position.row() + 1, position.column()));
        if (position.column() < columnCount - 1) list.add(new Position(position.row(), position.column() + 1));
        return list;
    }
}
