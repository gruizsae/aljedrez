package es.ieslavereda.mychess2122.model.Pieces;

import es.ieslavereda.mychess2122.model.ChessType;
import es.ieslavereda.mychess2122.model.Coordinate;
import es.ieslavereda.mychess2122.view.Board;
import es.ieslavereda.mychess2122.view.Cell;

public abstract class Pawn extends Piece {
    private static final long serialVersionUID = 1L;
    public Pawn(Cell cell, ChessType chessType) {
        super(cell, chessType);
    }

    // Sobreescribimos el metodo mover para incorporar el cambio a
    // reina si el peon llega al final del tablero
    @Override
    public boolean moveTo(Cell destination) {

        boolean moved = super.moveTo(destination);

        if(moved) {
            Coordinate position = cell.getCoordinate();
            Board board = cell.getBoard();
            // Comprobamos si hemos llegado al final del tablero
            if (position.getNumber() == 1 || position.getNumber()==8) {
                createQueen();
                this.removePiece();

            }
        }
        return moved;
    }

    protected abstract void createQueen();
}
