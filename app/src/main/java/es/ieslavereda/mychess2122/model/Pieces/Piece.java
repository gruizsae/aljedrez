package es.ieslavereda.mychess2122.model.Pieces;

import java.io.Serializable;
import java.util.Set;

import es.ieslavereda.mychess2122.model.ChessType;
import es.ieslavereda.mychess2122.model.Coordinate;
import es.ieslavereda.mychess2122.view.Board;
import es.ieslavereda.mychess2122.view.Cell;

public abstract class Piece implements Serializable {

    private static final long serialVersionUID = 1L;

    protected ChessType chessType;
    protected Cell cell;
    protected Set<Coordinate> posicionesCandidatas;

    public Piece(Cell cell, ChessType chessType) {
        this.cell = cell;
        this.chessType = chessType;
        placePiece();
    }

    protected void placePiece() {
        cell.setPiece(this);
    }

    public PieceColor getPieceColor() {
        return chessType.getPieceColor();
    }

    public Coordinate getPosition() {
        return cell.getCoordinate();
    }

    public ChessType getChessType() {
        return chessType;
    }

    // Metodo para mover la pieza
    public boolean moveTo(Cell destination) {

        boolean moved;

        // Comprobamos si es posible el moviento.
        if(!getNextMovements().contains(destination.getCoordinate()))
            return false;

        // Si la celda destino tiene ficha la eliminamos de la lista de
        // fichas del tablero
        if (destination.containsPiece()) {
            destination.getPiece().removePiece();
        }

        // movemos la ficha eliminandola de su antigua posicion (si existe) y colocandola en la nueva
        if (cell != null)
            cell.setPiece(null);
        cell = destination;
        cell.setPiece(this);
        moved = true;

        return moved;
    }

    protected void removePiece() {
        cell.getBoard().getWhitePieces().remove(this);
        cell.getBoard().getBlackPieces().remove(this);
        cell = null;
    }

    protected boolean canAddCoordinate(Coordinate c) {
        return cell.getBoard().containsCoordinate(c) && (cell.getBoard().getCell(c).getPiece() == null || cell.getBoard().getCell(c).getPiece().getPieceColor() != this.getPieceColor());
    }

    protected void tryToAddCoordinate(Coordinate c) {
        if (canAddCoordinate(c))
            posicionesCandidatas.add(c);
    }

    // Metodo abstracto que devuelve el conjunto de coordenadas posibles segun
    // los movimientos permitidos de cada pieza
    public abstract Set<Coordinate> getNextMovements();

    public abstract Piece copy(Board board);

    @Override
    public int hashCode() {
        return chessType.hashCode();
    }

}
