package es.ieslavereda.mychess2122.model;

import android.content.Context;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.List;

import es.ieslavereda.mychess2122.model.Pieces.Piece;
import es.ieslavereda.mychess2122.model.Pieces.PieceColor;
import es.ieslavereda.mychess2122.view.DeletedPanel;

public class MyDeletedPieceManager implements IDeletedPieceManager {

    private List<Piece> pieceList;
    private DeletedPanel whitePanel;
    private DeletedPanel blackPanel;

    public MyDeletedPieceManager(DeletedPanel whitePanel, DeletedPanel blackPanel) {
        pieceList = new ArrayList<>();
        this.whitePanel = whitePanel;
        this.blackPanel = blackPanel;
    }

    @Override
    public void add(Piece piece) {
        if (piece.getPieceColor() == PieceColor.WHITE)
            whitePanel.add(piece);
        else
            blackPanel.add(piece);
    }

    @Override
    public void remove(Piece piece) {

    }

    @Override
    public int count(ChessType chessType) {
        return 0;
    }
}
