package es.ieslavereda.mychess2122.view;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static es.ieslavereda.mychess2122.model.Pieces.PieceColor.BLACK;
import static es.ieslavereda.mychess2122.model.Pieces.PieceColor.WHITE;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import es.ieslavereda.mychess2122.R;
import es.ieslavereda.mychess2122.model.ChessType;
import es.ieslavereda.mychess2122.model.Coordinate;
import es.ieslavereda.mychess2122.model.IDeletedPieceManager;
import es.ieslavereda.mychess2122.model.MyDeletedPieceManager;
import es.ieslavereda.mychess2122.model.Pieces.BlackBishop;
import es.ieslavereda.mychess2122.model.Pieces.BlackKing;
import es.ieslavereda.mychess2122.model.Pieces.BlackKnight;
import es.ieslavereda.mychess2122.model.Pieces.BlackPawn;
import es.ieslavereda.mychess2122.model.Pieces.BlackQueen;
import es.ieslavereda.mychess2122.model.Pieces.BlackRook;
import es.ieslavereda.mychess2122.model.Pieces.Piece;
import es.ieslavereda.mychess2122.model.Pieces.PieceColor;
import es.ieslavereda.mychess2122.model.Pieces.WhiteBishop;
import es.ieslavereda.mychess2122.model.Pieces.WhiteKing;
import es.ieslavereda.mychess2122.model.Pieces.WhiteKnight;
import es.ieslavereda.mychess2122.model.Pieces.WhitePawn;
import es.ieslavereda.mychess2122.model.Pieces.WhiteQueen;
import es.ieslavereda.mychess2122.model.Pieces.WhiteRook;

public class Board extends TableLayout {

    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private final Map<Coordinate, Cell> cells;
    private Piece blackKing;
    private Piece whiteKing;
    private IDeletedPieceManager deletedPieceManager;

    public Board(Context context, AttributeSet attrs) {
        super(context, attrs);
        cells = new HashMap<>();
        DeletedPanel whitePanel = findViewById(R.id.whitePanel);
        DeletedPanel blackPanel = findViewById(R.id.blackPanel);
        deletedPieceManager = new MyDeletedPieceManager(whitePanel,blackPanel);

        initializeCells();
        LOGGER.finest("Board created.");
        placePieces();
    }
    public Board(Context context) {
        super(context);

        cells = new HashMap<>();

        DeletedPanel whitePanel = findViewById(R.id.whitePanel);
        DeletedPanel blackPanel = findViewById(R.id.blackPanel);
        deletedPieceManager = new MyDeletedPieceManager(whitePanel,blackPanel);

        initializeCells();
        LOGGER.finest("Board created.");
        placePieces();
    }

    private void initializeCells() {
        Coordinate coordinate;
        Cell cell;
        TableRow tableRow;

        tableRow = new TableRow(getContext());
        tableRow.addView(getNewLabel(""));
        for(int i='A';i<='H';i++)
            tableRow.addView(getNewLabel(String.valueOf((char)i)));
        tableRow.addView(getNewLabel(""));
        addView(tableRow);

        for (int row = 0; row < 8; row++) {
            tableRow = new TableRow(getContext());
            tableRow.addView(getNewLabel(String.valueOf(row)));
            for (int col = 0; col < 8; col++) {
                coordinate = new Coordinate((char) ('A' + col), 1 + row);
                cell = new Cell(getContext(),null,this, coordinate);

                cells.put(coordinate, cell);
                tableRow.addView(cell);
            }
            tableRow.addView(getNewLabel(String.valueOf(row)));

            addView(tableRow);
        }

        tableRow = new TableRow(getContext());
        tableRow.addView(getNewLabel(""));
        for(int i='A';i<='H';i++)
            tableRow.addView(getNewLabel(String.valueOf((char)i)));
        tableRow.addView(getNewLabel(""));
        addView(tableRow);
    }

    public TextView getNewLabel(String characters) {

        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        //int padding = (int) (displayMetrics.density * 16);
        int padding = (int)(getResources().getDimension(R.dimen.board_padding) * 2);
        int width = displayMetrics.widthPixels - padding;

        TextView textView = new TextView(getContext());
        textView.setText(characters);
        textView.setBackgroundColor(getResources().getColor(R.color.label_border_color,getContext().getTheme()));
        textView.setTextColor(getResources().getColor(R.color.white,getContext().getTheme()));
        textView.setGravity(Gravity.CENTER);
        textView.setWidth(width / 10);
        textView.setHeight(width / 10);
        return textView;
    }

    public void placePieces() {

        // Place Kings
        blackKing = new BlackKing(getCell( new Coordinate('E', 1)));

        whiteKing = new WhiteKing(getCell( new Coordinate('E', 8)));


        // Place Queens
        new BlackQueen(getCell( new Coordinate('D', 1)));
        new WhiteQueen(getCell( new Coordinate('D', 8)));

        // Place Bishops
        new BlackBishop(getCell( new Coordinate('C', 1)));
        new BlackBishop(getCell( new Coordinate('F', 1)));
        new WhiteBishop(getCell( new Coordinate('C', 8)));
        new WhiteBishop(getCell( new Coordinate('F', 8)));

        // Place Knights
        new BlackKnight(getCell( new Coordinate('B', 1)));
        new BlackKnight(getCell( new Coordinate('G', 1)));
        new WhiteKnight(getCell( new Coordinate('B', 8)));
        new WhiteKnight(getCell( new Coordinate('G', 8)));

        // Place Rooks
        new BlackRook(getCell( new Coordinate('A', 1)));
        new BlackRook(getCell( new Coordinate('H', 1)));
        new WhiteRook(getCell( new Coordinate('A', 8)));
        new WhiteRook(getCell( new Coordinate('H', 8)));

        // Place Pawns
        for (int col = 0; col < 8; col++) {
            new BlackPawn(getCell( new Coordinate((char) ('A' + col), 2)));
            new WhitePawn(getCell( new Coordinate((char) ('A' + col), 7)));
        }
        LOGGER.finest("Placed pieces.");
    }

    public Board copy() {

        Board copyBoard = new Board(getContext());

        // Get a copy of all pieces and place on the new board
        List<Piece> allPieces = cells.values().stream()
                .filter(Cell::containsPiece)
                .map(Cell::getPiece)
                .map(p -> p.copy(copyBoard))
                .collect(Collectors.toList());

        return copyBoard;
    }

    public IDeletedPieceManager getDeletedPieceManager() {
        return deletedPieceManager;
    }

    public Cell getCell(Coordinate c) {
        return cells.get(c);
    }

    public boolean containsCoordinate(Coordinate c) {
        return cells.containsKey(c);
    }

    public int count(ChessType chessType) {
        return (int) cells.values().stream()
                .filter(Cell::containsPiece)
                .map(Cell::getPiece)
                .filter(piece -> piece.getChessType() == chessType).count();
    }

    public List<Piece> getWhitePieces() {
        return cells.values().stream()
                .filter(Cell::containsPiece)
                .map(Cell::getPiece)
                .filter(piece -> piece.getPieceColor().equals(WHITE))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<Piece> getBlackPieces() {
        return cells.values().stream()
                .filter(cell -> cell.containsPiece())
                .map(cell -> cell.getPiece())
                .filter(piece -> piece.getPieceColor().equals(BLACK))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public boolean check(PieceColor color) {
        return (color==WHITE)?whiteCheck() : blackCheck();
    }
    public boolean check() {
        return whiteCheck() || blackCheck();
    }

    public boolean blackCheck() {
        boolean check;
        Set<Coordinate> nextBlackMovements = new HashSet<>();

        for (Piece piece : getBlackPieces())
            nextBlackMovements.addAll(piece.getNextMovements());

        check = nextBlackMovements.contains(whiteKing.getPosition());

        if(check) LOGGER.info("Check!!");

        return check;
    }
    public void highlight(Set<Coordinate> coordinates){
        for(Coordinate c : coordinates)
            cells.get(c).highlight();
    }
    public void removeHighlight(){
        for(Coordinate c : cells.keySet())
            cells.get(c).removeHighlight();
    }

    public boolean whiteCheck() {
        boolean check;
        Set<Coordinate> nextWhiteMovements = new HashSet<>();

        for (Piece piece : getWhitePieces())
            nextWhiteMovements.addAll(piece.getNextMovements());

        check = nextWhiteMovements.contains(blackKing.getPosition());

        if(check) LOGGER.info("Check!!");

        return nextWhiteMovements.contains(blackKing.getPosition());
    }

    public boolean checkmate(PieceColor color) {

        if(!check(color.next()))
            return false;

        Board copyBoard = this.copy();
        List<Piece> pieceList;
        boolean checkmate = true;

        pieceList = (color == WHITE) ? copyBoard.getWhitePieces() : copyBoard.getBlackPieces();

        Iterator<Piece> pieceIterator = pieceList.listIterator();
        Piece piece;

        Cell cellDestination=null;
        Cell cellOrigin;
        while (checkmate && pieceIterator.hasNext()) {
            piece = pieceIterator.next();
            Iterator<Coordinate> nextMovementsIterator = new ArrayList<>(piece.getNextMovements()).listIterator();
            cellOrigin = copyBoard.getCell(piece.getPosition());
            while (checkmate && nextMovementsIterator.hasNext()) {

                cellDestination = copyBoard.getCell(nextMovementsIterator.next());

                // killing movement
                if (cellDestination.containsPiece()) {
                    Piece aux = cellDestination.getPiece();
                    piece.moveTo(cellDestination);
                    checkmate = (color == WHITE) ? copyBoard.blackCheck() : copyBoard.whiteCheck();

                    // Rollback movement
                    piece.moveTo(cellOrigin);
                    aux.moveTo(cellDestination);

                    if (aux.getPieceColor() == WHITE)
                        copyBoard.getWhitePieces().add(aux);
                    else
                        copyBoard.getBlackPieces().add(aux);
                } else {
                    piece.moveTo(cellDestination);
                    checkmate = (color == WHITE) ? copyBoard.blackCheck() : copyBoard.whiteCheck();

                    // Rollback movement
                    piece.moveTo(cellOrigin);
                    cellDestination.setPiece(null);
                }
            }
            if(!checkmate)
                LOGGER.info("Piece " + piece + " prevent checkmate moving from " + cellOrigin.getCoordinate() + " to " + cellDestination.getCoordinate()+".");
        }

        return checkmate;
    }
    public void setOnclickListener(View.OnClickListener listener){
        for(Cell cell : cells.values())
            cell.setOnClickListener(listener);
    }
}