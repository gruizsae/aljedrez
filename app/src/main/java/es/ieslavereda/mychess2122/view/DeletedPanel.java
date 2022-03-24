package es.ieslavereda.mychess2122.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridLayout;

import es.ieslavereda.mychess2122.model.Pieces.Piece;

public class DeletedPanel extends GridLayout {

    public DeletedPanel(Context context) {
        super(context);
    }

    public DeletedPanel(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DeletedPanel(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public DeletedPanel(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void add(Piece piece){

    }
}
