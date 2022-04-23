package pl.zsl.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button computerBtn;
    private Button playerBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        computerBtn = findViewById(R.id.computerBtn);
        playerBtn = findViewById(R.id.playerBtn);
        computerBtn.setOnClickListener(e -> {
            Intent intent = new Intent(getBaseContext(), GameBoard.class);
            startActivity(intent);
        });
        playerBtn.setOnClickListener(e -> {
            Intent intent = new Intent(getBaseContext(), GameBoard.class);
            startActivity(intent);
        });
    }
}