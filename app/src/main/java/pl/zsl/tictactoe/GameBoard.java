package pl.zsl.tictactoe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class GameBoard extends AppCompatActivity {
    TextView playerOInfo;
    TextView playerXInfo;
    ImageButton cell11;
    ImageButton cell12;
    ImageButton cell13;
    ImageButton cell21;
    ImageButton cell22;
    ImageButton cell23;
    ImageButton cell31;
    ImageButton cell32;
    ImageButton cell33;
    int playerXPoints = 0;
    int playerOPoints = 0;
    Player playerO = new Player("", 'O', R.drawable.ic_outline_circle_24);
    Player playerX = new Player("", 'X', R.drawable.ic_outline_cross_24);
    GameJudge judge = new GameJudge(playerO, playerX);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_board);
        playerOInfo = findViewById(R.id.playerPointsO);
        playerXInfo = findViewById(R.id.playerPointsX);
        cell11 = findViewById(R.id.cell11);
        cell12 = findViewById(R.id.cell12);
        cell13 = findViewById(R.id.cell13);
        cell21 = findViewById(R.id.cell21);
        cell22 = findViewById(R.id.cell22);
        cell23 = findViewById(R.id.cell23);
        cell31 = findViewById(R.id.cell31);
        cell32 = findViewById(R.id.cell32);
        cell33 = findViewById(R.id.cell33);
        cell11.setOnClickListener(e -> {
            makeMove((ImageButton) e, 0, 0);
        });
        cell12.setOnClickListener(e -> {
            makeMove((ImageButton) e, 0, 1);
        });
        cell13.setOnClickListener(e -> {
            makeMove((ImageButton) e, 0, 2);
        });
        cell31.setOnClickListener(e -> {
            makeMove((ImageButton) e, 2, 0);
        });
        cell32.setOnClickListener(e -> {
            makeMove((ImageButton) e, 2, 1);
        });
        cell33.setOnClickListener(e -> {
            makeMove((ImageButton) e, 2, 2);
        });
        cell21.setOnClickListener(e -> {
            makeMove((ImageButton) e, 1, 0);
        });
        cell22.setOnClickListener(e -> {
            makeMove((ImageButton) e, 1, 1);
        });
        cell23.setOnClickListener(e -> {
            makeMove((ImageButton) e, 1, 2);
        });

    }

    private void makeMove(ImageButton e, int r, int c) {
        Player player = judge.getPlayerInTurn();
        if (judge.makeMove(r, c)) {
            Log.i("GAME", "Player " + player.getSymbol() +" " + " row = " + r + " col = " + c);
            Log.i("GAME", "Game state " + judge.getGameState());
            ImageButton btn = e;
            btn.setImageResource(player.drawable);
            switch (judge.getGameState()) {
                case IS_DRAW:
                    showDialog("Remis");
                    break;
                case PLAYER_O_WINNER:
                    playerOPoints++;
                    playerOInfo.setText("Gracz o: " + playerOPoints);
                    showDialog("Wygrana gracza o");
                    break;
                case PLAYER_X_WINNER:
                    playerXPoints++;
                    playerXInfo.setText("Gracz x: " + playerXPoints);
                    showDialog("Wygrana gracza x");
                    break;
                case GAME_RUNNING:
                    Toast.makeText(getBaseContext(), "Ruch gracza " + judge.getPlayerInTurn().symbol, Toast.LENGTH_LONG).show();
            }
        }

    }

    private void showDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Status gry")
                .setMessage(message)
                .setPositiveButton("Czy chcesz zagrać!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        judge.restartGame();
                        resetGameBoard();
                    }
                })
                .setNegativeButton("Koniec", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
        .show();
    }

    private void resetGameBoard(){
        cell11.setImageResource(R.drawable.ic_outline_empty_24);
        cell12.setImageResource(R.drawable.ic_outline_empty_24);
        cell13.setImageResource(R.drawable.ic_outline_empty_24);
        cell21.setImageResource(R.drawable.ic_outline_empty_24);
        cell22.setImageResource(R.drawable.ic_outline_empty_24);
        cell23.setImageResource(R.drawable.ic_outline_empty_24);
        cell31.setImageResource(R.drawable.ic_outline_empty_24);
        cell32.setImageResource(R.drawable.ic_outline_empty_24);
        cell33.setImageResource(R.drawable.ic_outline_empty_24);
    }
}