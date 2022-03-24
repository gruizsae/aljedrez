package es.ieslavereda.mychess2122.model;

import es.ieslavereda.mychess2122.R;
import es.ieslavereda.mychess2122.model.Pieces.PieceColor;

public enum ChessType {

    WHITE_KING(R.mipmap.ic_w_king_foreground, PieceColor.WHITE),
    WHITE_QUEEN(R.mipmap.ic_w_queen_foreground, PieceColor.WHITE),
    WHITE_ROOK(R.mipmap.ic_w_rook_foreground, PieceColor.WHITE),
    WHITE_BISHOP(R.mipmap.ic_w_bishop_foreground, PieceColor.WHITE),
    WHITE_KNIGHT(R.mipmap.ic_w_knight_foreground, PieceColor.WHITE),
    WHITE_PAWN(R.mipmap.ic_w_pawn_foreground, PieceColor.WHITE),
    BLACK_KING(R.mipmap.ic_b_king_foreground, PieceColor.BLACK),
    BLACK_QUEEN(R.mipmap.ic_b_queen_foreground, PieceColor.BLACK),
    BLACK_ROOK(R.mipmap.ic_b_rook_foreground, PieceColor.BLACK),
    BLACK_BISHOP(R.mipmap.ic_b_bishop_foreground, PieceColor.BLACK),
    BLACK_KNIGHT(R.mipmap.ic_b_knight_foreground, PieceColor.BLACK),
    BLACK_PAWN(R.mipmap.ic_b_pawn_foreground, PieceColor.BLACK);

    private final Integer shape;
    private final PieceColor color;

    ChessType(Integer shape, PieceColor color) {
        this.shape = shape;
        this.color = color;
    }

    public Integer getShape() {
        return shape;
    }
    public PieceColor getPieceColor(){return color;}

}
