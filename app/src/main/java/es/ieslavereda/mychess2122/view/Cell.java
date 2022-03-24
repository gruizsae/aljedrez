package es.ieslavereda.mychess2122.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import es.ieslavereda.mychess2122.R;
import es.ieslavereda.mychess2122.model.Coordinate;
import es.ieslavereda.mychess2122.model.Pieces.Piece;

public class Cell extends androidx.appcompat.widget.AppCompatImageView {


    private Piece piece;
    private Board board;
    private Coordinate coordinate;
    private CellColor originalColor;
    private CellColor color;

    public Cell(@NonNull Context context) {
        super(context);
    }

    public Cell(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Cell(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Cell(@NonNull Context context, @Nullable AttributeSet attrs, Board board, Coordinate coordinate) {
        super(context, attrs);

        this.board = board;
        this.coordinate = coordinate;
        this.piece = null;

        if (((coordinate.getNumber() - 1) + (coordinate.getLetter() - 'A') + 1) % 2 == 0) {
            this.originalColor = CellColor.BLACK_CELL;
        } else {
            this.originalColor = CellColor.WHITE_CELL;
        }

        this.color = originalColor;

        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        //int padding = (int) (displayMetrics.density * 16);
        int padding = (int)(getResources().getDimension(R.dimen.board_padding) * 2);
        int width = displayMetrics.widthPixels - padding;

        int size = (width) / 10;

        setMinimumWidth(size);
        setMinimumHeight(size);
        setMaxWidth(size);
        setMaxHeight(size);

        setBackgroundColor(getResources().getColor(color.getAttribute(),getContext().getTheme()));
    }

    public Board getBoard() {
        return board;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
        // Establecer la imagen en la celda (ImageButton)
        if(piece!=null){
            setImageResource(piece.getChessType().getShape());
            int padding = (int)getResources().getDimension(R.dimen.pieces_padding);
            setPadding(padding,padding,padding,padding);
            setScaleType(ScaleType.FIT_CENTER);
            setAdjustViewBounds(true);
        }else {
            setImageResource(0);
        }

    }

    public boolean containsPiece() {
        return piece != null;
    }

    public void highlight() {
        if (originalColor == CellColor.WHITE_CELL)
            this.color = (piece != null) ? CellColor.HIGHLIGHT_KILL_WHITE : CellColor.HIGHLIGHT_WHITE;
        else
            this.color = (piece != null) ? CellColor.HIGHLIGHT_KILL_BLACK : CellColor.HIGHLIGHT_BLACK;

        setBackgroundColor(getResources().getColor(color.getAttribute(),getContext().getTheme()));
    }

    public void removeHighlight() {
        this.color = originalColor;
        setBackgroundColor(getResources().getColor(color.getAttribute(),getContext().getTheme()));
    }

    public enum CellColor {
        WHITE_CELL(R.color.cell_white_color),
        BLACK_CELL(R.color.cell_black_color),
        HIGHLIGHT_KILL_WHITE(R.color.cell_kill_destination_color_white),
        HIGHLIGHT_KILL_BLACK(R.color.cell_kill_destination_color_black),
        HIGHLIGHT_WHITE(R.color.cell_destination_color_white),
        HIGHLIGHT_BLACK(R.color.cell_destination_color_black);
        private final Integer color;

        CellColor(Integer color) {
            this.color = color;
        }

        public Integer getAttribute() {
            return color;
        }
    }
}
