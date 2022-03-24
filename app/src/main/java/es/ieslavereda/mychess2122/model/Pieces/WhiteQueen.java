package es.ieslavereda.mychess2122.model.Pieces;

import es.ieslavereda.mychess2122.model.ChessType;
import es.ieslavereda.mychess2122.view.Board;
import es.ieslavereda.mychess2122.view.Cell;

public class WhiteQueen extends Queen {
    public WhiteQueen(Cell cell) {
        super(cell , ChessType.WHITE_QUEEN);
    }

    @Override
    public Piece copy(Board board) {
        return new WhiteQueen(board.getCell(cell.getCoordinate()));
    }
}
