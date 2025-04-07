package com.example.olio12;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.olio12.fragments.BossFightFragment;
import com.example.olio12.fragments.ShowMonsterFragment;

public class FightMonstersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight_monsters);

        Button ShowMonsterFragment = findViewById(R.id.ShowMonsterFragmentButton);
        Button BossFightFragment = findViewById(R.id.BossFightFragmentButton);

        BossFightFragment.setEnabled(false);

        if (GameManager.getInstance().getLatestMonster() == null) {
            GameManager.getInstance().generateMonster();
        }

        ShowMonsterFragment.setOnClickListener(Listener);
        BossFightFragment.setOnClickListener(Listener);
        checkBossButton();

    }

    private View.OnClickListener Listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Fragment fragment;

            int id = view.getId();

            if (id == R.id.ShowMonsterFragmentButton) {
                fragment = new ShowMonsterFragment();
            }
            else if (id == R.id.BossFightFragmentButton) {
                fragment = new BossFightFragment();
            }
            else {
                fragment = new ShowMonsterFragment();
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.FightMonstersFrame, fragment).commit();
        }

    };
    public void ReturnFromFightButton(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void checkBossButton() {
        Button bossButton = findViewById(R.id.BossFightFragmentButton);
        if (GameManager.getInstance().getPlayer().getScore() >= 100) {
            bossButton.setEnabled(true);
            BossFightFragment.setEnabled(true);
        } else {
            bossButton.setEnabled(false);
            BossFightFragment.setEnabled(false);
        }
    }

}
