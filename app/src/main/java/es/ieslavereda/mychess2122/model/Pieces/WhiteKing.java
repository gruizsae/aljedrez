package es.ieslavereda.mychess2122.model.Pieces;

import es.ieslavereda.mychess2122.model.ChessType;
import es.ieslavereda.mychess2122.view.Board;
import es.ieslavereda.mychess2122.view.Cell;

public class WhiteKing extends King{
    public WhiteKing(Cell cell) {
        super(cell, ChessType.WHITE_KING);
    }

    @Override
    public Piece copy(Board board) {
        return new WhiteKing( board.getCell(cell.getCoordinate()));
    }
}
