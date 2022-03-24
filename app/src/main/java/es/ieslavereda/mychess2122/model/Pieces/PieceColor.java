package es.ieslavereda.mychess2122.model.Pieces;

public enum PieceColor {
    WHITE,
    BLACK;

    public PieceColor next(){
        return PieceColor.values()[(this.ordinal() + 1) % PieceColor.values().length];
    }
}