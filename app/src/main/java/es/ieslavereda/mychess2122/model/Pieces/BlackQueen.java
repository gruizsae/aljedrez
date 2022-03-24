package es.ieslavereda.mychess2122.model.Pieces;

import es.ieslavereda.mychess2122.model.ChessType;
import es.ieslavereda.mychess2122.view.Board;
import es.ieslavereda.mychess2122.view.Cell;

public class BlackQueen extends Queen {
    public BlackQueen(Cell cell) {
        super(cell, ChessType.BLACK_QUEEN);
    }

    @Override
    public Piece copy(Board board) {
        return new BlackQueen(board.getCell(cell.getCoordinate()));
    }
}
