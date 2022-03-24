package es.ieslavereda.mychess2122;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.logging.Logger;

import es.ieslavereda.mychess2122.view.Board;
import es.ieslavereda.mychess2122.view.Cell;

public class App extends AppCompatActivity implements View.OnClickListener {
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Board board = findViewById(R.id.board);
        board.setOnclickListener(this);

       // Game game = new Game(getApplicacionContext(), board);
       // board.setOnclickListener(game);

    }

    @Override
    public void onClick(View view) {
        Cell cell = (Cell)view;
        Toast.makeText(this, "Click en " + cell.getCoordinate().toString(), Toast.LENGTH_SHORT).show();
    }
}