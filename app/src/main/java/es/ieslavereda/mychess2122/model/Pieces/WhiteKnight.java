package es.ieslavereda.mychess2122.model.Pieces;

import es.ieslavereda.mychess2122.model.ChessType;
import es.ieslavereda.mychess2122.view.Board;
import es.ieslavereda.mychess2122.view.Cell;

public class WhiteKnight extends Knight{
    public WhiteKnight(Cell cell){
        super(cell, ChessType.WHITE_KNIGHT);
    }

    @Override
    public Piece copy(Board board) {
        return new WhiteKnight( board.getCell(cell.getCoordinate()));
    }
}
