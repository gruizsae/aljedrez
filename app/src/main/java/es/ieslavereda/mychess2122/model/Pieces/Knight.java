package es.ieslavereda.mychess2122.model.Pieces;

import java.util.LinkedHashSet;
import java.util.Set;

import es.ieslavereda.mychess2122.model.ChessType;
import es.ieslavereda.mychess2122.model.Coordinate;
import es.ieslavereda.mychess2122.view.Board;
import es.ieslavereda.mychess2122.view.Cell;

public abstract class Knight extends Piece {

    private static final long serialVersionUID = 1L;

    public Knight(Cell cell, ChessType chessType) {
        super(cell, chessType);
    }

    @Override
    public Set<Coordinate> getNextMovements() {

        posicionesCandidatas = new LinkedHashSet<Coordinate>();

        // Comprobamos que la ficha este en el tablero
        if (cell == null)
            return posicionesCandidatas;

        Coordinate piecePosition = cell.getCoordinate();
        Board board = cell.getBoard();

        // Superior
        tryToAddCoordinate(piecePosition.up().up().left());
        tryToAddCoordinate(piecePosition.up().up().right());

        // Inferior
        tryToAddCoordinate(piecePosition.down().down().left());
        tryToAddCoordinate(piecePosition.down().down().right());

        // Derecha
        tryToAddCoordinate(piecePosition.right().right().up());
        tryToAddCoordinate(piecePosition.right().right().down());

        // Izquierda
        tryToAddCoordinate(piecePosition.left().left().up());
        tryToAddCoordinate(piecePosition.left().left().down());

        return posicionesCandidatas;
    }

}
