package es.ieslavereda.mychess2122.model.Pieces;

import java.util.LinkedHashSet;
import java.util.Set;

import es.ieslavereda.mychess2122.model.ChessType;
import es.ieslavereda.mychess2122.model.Coordinate;
import es.ieslavereda.mychess2122.view.Cell;

public abstract class King extends Piece {

    private static final long serialVersionUID = 1L;

    public King(Cell cell, ChessType chessType) { super(cell, chessType); }

    @Override
    public Set<Coordinate> getNextMovements() {

        posicionesCandidatas = new LinkedHashSet<Coordinate>();
        Coordinate position = cell.getCoordinate();

        // cruz
        tryToAddCoordinate(position.up());
        tryToAddCoordinate(position.down());
        tryToAddCoordinate(position.left());
        tryToAddCoordinate(position.right());

        // diagonal
        tryToAddCoordinate(position.diagonalUpLeft());
        tryToAddCoordinate(position.diagonalUpRight());
        tryToAddCoordinate(position.diagonalDownLeft());
        tryToAddCoordinate(position.diagonalDownRight());

        return posicionesCandidatas;
    }

}
