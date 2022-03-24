package es.ieslavereda.mychess2122.model.Pieces;

import java.util.LinkedHashSet;
import java.util.Set;

import es.ieslavereda.mychess2122.model.ChessType;
import es.ieslavereda.mychess2122.model.Coordinate;
import es.ieslavereda.mychess2122.view.Board;
import es.ieslavereda.mychess2122.view.Cell;

public abstract class Bishop extends Piece {

    private static final long serialVersionUID = 1L;

    public Bishop(Cell cell, ChessType chessType) {
        super(cell,chessType);
    }

    @Override
    public Set<Coordinate> getNextMovements() {

        posicionesCandidatas = diagonalMovements(this);

        return posicionesCandidatas;
    }

    public static Set<Coordinate> diagonalMovements(Piece piece) {

        Set<Coordinate> posicionesCandidatas = new LinkedHashSet<>();
        Coordinate c;
        Board board = piece.cell.getBoard();
        Coordinate position = piece.getPosition();


        // Comprobamos que la ficha este en el tablero
        if (piece.cell == null)
            return posicionesCandidatas;

        // Diagonal superior izq
        c = position;
        do {
            c = c.diagonalUpLeft();
            if(piece.canAddCoordinate(c)) posicionesCandidatas.add(c);
        } while (board.containsCoordinate(c) && board.getCell(c).getPiece() == null);

        // Diagonal superior der
        c = position;
        do {
            c = c.diagonalUpRight();
            if(piece.canAddCoordinate(c)) posicionesCandidatas.add(c);
        } while (board.containsCoordinate(c) && board.getCell(c).getPiece() == null);

        // Diagonal inferior izq
        c = position;
        do {
            c = c.diagonalDownLeft();
            if(piece.canAddCoordinate(c)) posicionesCandidatas.add(c);
        } while (board.containsCoordinate(c) && board.getCell(c).getPiece() == null);

        // Diagonal inferior der
        c = position;
        do {
            c = c.diagonalDownRight();
            if(piece.canAddCoordinate(c)) posicionesCandidatas.add(c);
        } while (board.containsCoordinate(c) && board.getCell(c).getPiece() == null);

        return posicionesCandidatas;
    }

}