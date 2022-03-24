package es.ieslavereda.mychess2122.model.Pieces;

import es.ieslavereda.mychess2122.model.ChessType;
import es.ieslavereda.mychess2122.view.Board;
import es.ieslavereda.mychess2122.view.Cell;

public class WhiteRook extends Rook {
    public WhiteRook(Cell cell) {
        super(cell, ChessType.WHITE_ROOK);
    }

    @Override
    public Piece copy(Board board) {
        return new WhiteRook(board.getCell(cell.getCoordinate()));
    }
}
