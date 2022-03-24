package es.ieslavereda.mychess2122.model.Pieces;

import es.ieslavereda.mychess2122.model.ChessType;
import es.ieslavereda.mychess2122.view.Board;
import es.ieslavereda.mychess2122.view.Cell;

public class BlackKnight extends Knight {
    public BlackKnight(Cell cell) {
        super(cell, ChessType.BLACK_KNIGHT);
    }
    public BlackKnight copy(Board board){
        return new BlackKnight(board.getCell(cell.getCoordinate()));
    }
}
