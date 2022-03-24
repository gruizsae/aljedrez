package es.ieslavereda.mychess2122.model.Pieces;

import java.util.LinkedHashSet;
import java.util.Set;

import es.ieslavereda.mychess2122.model.ChessType;
import es.ieslavereda.mychess2122.model.Coordinate;
import es.ieslavereda.mychess2122.view.Board;
import es.ieslavereda.mychess2122.view.Cell;

public class BlackPawn extends Pawn {
    public BlackPawn(Cell cell) {
        super(cell, ChessType.BLACK_PAWN);
    }

    @Override
    protected void createQueen() {
        // Creamos la reina en la misma posicion
        cell.getBoard().getBlackPieces().add(new BlackQueen(cell));
    }


    public Set<Coordinate> getNextMovements() {

        posicionesCandidatas = new LinkedHashSet<>();
        Coordinate c;
        Coordinate position = cell.getCoordinate();
        Board board = cell.getBoard();

        // posicion delante
        c = position.down();

        if (board.containsCoordinate(c) && board.getCell(c).getPiece() == null)
            posicionesCandidatas.add(c);

        // avanza matando
        c = position.diagonalDownLeft();
        if (board.containsCoordinate(c)
                && (board.getCell(c).getPiece() != null && board.getCell(c).getPiece().getPieceColor() != getPieceColor()))
            posicionesCandidatas.add(c);
        c = position.diagonalDownRight();
        if (board.containsCoordinate(c)
                && (board.getCell(c).getPiece() != null && board.getCell(c).getPiece().getPieceColor() != getPieceColor()))
            posicionesCandidatas.add(c);

        // Si esta en la posicion inicial se le permite avanzar 2 posiciones
        if (position.getNumber() == 2) {
            c = position.down();
            if (board.containsCoordinate(c) && board.getCell(c).getPiece() == null) {
                c = c.down();
                if (board.containsCoordinate(c) && board.getCell(c).getPiece() == null) {
                    posicionesCandidatas.add(c);
                }
            }
        }
        return posicionesCandidatas;
    }

    @Override
    public Piece copy(Board board) {
        return new BlackPawn(board.getCell(cell.getCoordinate()));
    }
}
