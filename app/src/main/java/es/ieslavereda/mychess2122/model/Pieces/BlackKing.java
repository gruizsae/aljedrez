package es.ieslavereda.mychess2122.model.Pieces;

import es.ieslavereda.mychess2122.model.ChessType;
import es.ieslavereda.mychess2122.view.Board;
import es.ieslavereda.mychess2122.view.Cell;

public class BlackKing extends King {
    public BlackKing(Cell cell) {
        super(cell, ChessType.BLACK_KING);
    }

    @Override
    public Piece copy(Board board) {
        return new BlackKing(board.getCell(cell.getCoordinate()));
    }
}