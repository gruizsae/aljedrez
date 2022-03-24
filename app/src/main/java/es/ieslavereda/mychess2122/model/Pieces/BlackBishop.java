package es.ieslavereda.mychess2122.model.Pieces;

import es.ieslavereda.mychess2122.model.ChessType;
import es.ieslavereda.mychess2122.view.Board;
import es.ieslavereda.mychess2122.view.Cell;

public class BlackBishop extends Bishop{
    public BlackBishop(Cell cell) {
        super(cell, ChessType.BLACK_BISHOP);
    }

    public BlackBishop copy(Board board){
        return new BlackBishop(board.getCell(cell.getCoordinate()));
    }
}
