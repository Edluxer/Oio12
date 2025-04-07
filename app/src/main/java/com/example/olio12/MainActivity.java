package com.example.olio12;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView playerScoreText;
    private GameManager gameManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gameManager = GameManager.getInstance();
        playerScoreText = findViewById(R.id.PlayerScoreText);


    }
    public void FightMonsterActivityChange(View view) {
        Intent intent = new Intent(this, FightMonstersActivity.class);
        startActivity(intent);
    }
    @Override
    protected void onResume() {
        super.onResume();
        playerScoreText.setText("Pisteet: " + gameManager.getPlayer().getScore());
    }

}
