package es.ieslavereda.mychess2122.model;

import es.ieslavereda.mychess2122.model.Pieces.Piece;

public interface IDeletedPieceManager {
    void add(Piece piece);
    void remove(Piece piece);
    int count(ChessType chessType);
}