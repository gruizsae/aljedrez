package es.ieslavereda.mychess2122.model.Pieces;

import es.ieslavereda.mychess2122.model.ChessType;
import es.ieslavereda.mychess2122.view.Board;
import es.ieslavereda.mychess2122.view.Cell;

public class BlackRook extends Rook {
    public BlackRook(Cell cell) {
        super(cell, ChessType.BLACK_ROOK);
    }

    @Override
    public Piece copy(Board board) {
        return new BlackRook(board.getCell(cell.getCoordinate()));
    }
}
