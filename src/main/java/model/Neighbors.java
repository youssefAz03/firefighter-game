package model;

import util.Position;

import java.util.ArrayList;
import java.util.List;

public class Neighbors {

    private final Board board;

    public Neighbors(Board board) {
        this.board = board;
    }

    public List<Position> neighbors(Position position,int step) {
        List<Position> list = new ArrayList<>();
        if (position.row() > 0) list.add(new Position(position.row() - step, position.column()));
        if (position.column() > 0) list.add(new Position(position.row(), position.column() - step));
        if (position.row() < board.rowCount() - step) list.add(new Position(position.row() + step, position.column()));
        if (position.column() < board.columnCount() - step) list.add(new Position(position.row(), position.column() + step));
        return list;
    }
}
