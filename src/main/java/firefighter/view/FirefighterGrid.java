package firefighter.view;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.util.Pair;
import firefighter.model.Position;

import java.util.List;

public class FirefighterGrid extends Canvas implements Grid<ViewElement>{

    private void paintElementAtPosition(ViewElement element, Position position) {
        paintSquare(position.row(), position.column(), element.color);
    }

    private int squareWidth;
    private int squareHeight;
    private int columnCount;
    private int rowCount;

    @Override
    public void repaint(List<Pair<Position, ViewElement>> positionedElements) {
        for(Pair<Position, ViewElement> pair : positionedElements){
            paintElementAtPosition(pair.getValue(), pair.getKey());
        }
        paintLines();
    }

    @Override
    public void repaint(ViewElement[][] elements) {
        for(int column = 0; column < columnCount; column++)
            for(int row = 0; row < rowCount; row++){
                paintElementAtPosition(elements[row][column], new Position(row, column));
            }
        paintLines();
    }

    public int getColumnCount() {
        return columnCount;
    }

    public int getRowCount() {
        return rowCount;
    }

    public FirefighterGrid(){
    }

    public void initialize(int squareWidth,
                           int squareHeight,
                           int columnCount,
                           int rowCount) {
        this.squareWidth = squareWidth;
        this.squareHeight = squareHeight;
        this.columnCount = columnCount;
        this.rowCount = rowCount;
    }

    private void paintLines(){
        for(int column=0; column<columnCount; column++)
            getGraphicsContext2D().strokeLine(0, column*squareHeight, getWidth(), column*squareWidth);
        for(int row=0; row<rowCount;row++)
            getGraphicsContext2D().strokeLine(row*squareHeight, 0,row*squareHeight, getHeight());
    }

    private void paintSquare(int row, int column, Color color){
        getGraphicsContext2D().setFill(color);
        getGraphicsContext2D().fillRect(row*squareHeight,column*squareWidth,squareHeight,squareWidth);
    }



}