package es.ieslavereda.mychess2122.model.Pieces;

import es.ieslavereda.mychess2122.model.ChessType;
import es.ieslavereda.mychess2122.view.Board;
import es.ieslavereda.mychess2122.view.Cell;

public class WhiteBishop extends Bishop {
    public WhiteBishop(Cell cell) {
        super(cell, ChessType.WHITE_BISHOP);
        placePiece();
    }

    @Override
    public Piece copy(Board board) {
        return new WhiteBishop(board.getCell(cell.getCoordinate()));
    }
}
