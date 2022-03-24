package es.ieslavereda.mychess2122.model.Pieces;

import java.util.LinkedHashSet;
import java.util.Set;

import es.ieslavereda.mychess2122.model.ChessType;
import es.ieslavereda.mychess2122.model.Coordinate;
import es.ieslavereda.mychess2122.view.Board;
import es.ieslavereda.mychess2122.view.Cell;

public abstract class Rook extends Piece {

    private static final long serialVersionUID = 1L;

    public Rook(Cell cell, ChessType chessType) {
        super(cell, chessType);
    }

    @Override
    public Set<Coordinate> getNextMovements() {

        posicionesCandidatas = crossMovements(this);

        return posicionesCandidatas;
    }

    public static Set<Coordinate> crossMovements(Piece piece) {

        Set<Coordinate> posicionesCandidatas = new LinkedHashSet<>();
        Coordinate c;
        Board board = piece.cell.getBoard();
        Coordinate position = piece.getPosition();

        // Superior
        c = position;
        do {
            c = c.up();
            if(piece.canAddCoordinate(c)) posicionesCandidatas.add(c);
        } while (board.containsCoordinate(c) && board.getCell(c).getPiece() == null);

        // Inferior
        c = position;
        do {
            c = c.down();
            if(piece.canAddCoordinate(c)) posicionesCandidatas.add(c);
        } while (board.containsCoordinate(c) && board.getCell(c).getPiece() == null);

        // Izquierda
        c = position;
        do {
            c = c.left();
            if(piece.canAddCoordinate(c)) posicionesCandidatas.add(c);
        } while (board.containsCoordinate(c) && board.getCell(c).getPiece() == null);

        // Derecha
        c = position;
        do {
            c = c.right();
            if(piece.canAddCoordinate(c)) posicionesCandidatas.add(c);
        } while (board.containsCoordinate(c) && board.getCell(c).getPiece() == null);

        return posicionesCandidatas;
    }

}
