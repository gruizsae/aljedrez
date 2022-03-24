package es.ieslavereda.mychess2122.model.Pieces;

import java.util.LinkedHashSet;
import java.util.Set;

import es.ieslavereda.mychess2122.model.ChessType;
import es.ieslavereda.mychess2122.model.Coordinate;
import es.ieslavereda.mychess2122.view.Cell;

public abstract class Queen extends Piece {

    private static final long serialVersionUID = 1L;

    public Queen(Cell cell, ChessType chessType) {
        super(cell, chessType);
    }

    @Override
    public Set<Coordinate> getNextMovements() {

        posicionesCandidatas = new LinkedHashSet<Coordinate>();

        // Comprobamos que la ficha este en el tablero
        if (cell == null)
            return posicionesCandidatas;

        posicionesCandidatas.addAll(Bishop.diagonalMovements(this));
        posicionesCandidatas.addAll(Rook.crossMovements(this));

        return posicionesCandidatas;
    }

}
