package com.example.olio12.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.olio12.GameManager;
import com.example.olio12.Monster;
import com.example.olio12.R;


public class BossFightFragment extends Fragment {

    private static boolean enabled = false;
    public static void setEnabled(boolean b) {
        enabled = b;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_boss_fight, container, false);

        TextView BossText = view.findViewById(R.id.BossText);
        ImageView BossImage = view.findViewById(R.id.BossImage);
        Button AttackBossButton = view.findViewById(R.id.AttackBossButton);

        Monster bossMonster = new Monster(200, "Robotti") {
            private boolean halfHealthTriggered = false;

            @Override
            public void takeDamage(int amount) {
                int currentLife = getLife();
                if (!halfHealthTriggered && currentLife <= getMaxLife() / 2) {
                    super.takeDamage(-getMaxLife() / 2);
                    halfHealthTriggered = true;
                } else {
                    int newLife = Math.max(0, currentLife - amount);
                    setLife(newLife);
                }
            }
            private void setLife(int value) {
                try {
                    java.lang.reflect.Field lifeField = Monster.class.getDeclaredField("life");
                    lifeField.setAccessible(true);
                    lifeField.set(this, value);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        GameManager.getInstance().setLatestMonster(bossMonster);
        updateBossView(BossText, BossImage);

        AttackBossButton.setOnClickListener(v -> {
            GameManager.getInstance().getPlayer().attack(GameManager.getInstance().getLatestMonster());
            updateBossView(BossText, BossImage);
        });
        return view;
    }
    private void updateBossView(TextView nameView, ImageView imageView) {
        Monster currentMonster = GameManager.getInstance().getLatestMonster();
        if (currentMonster != null) {
            nameView.setText(currentMonster.getName() + ": " + currentMonster.getLife() + " / " + currentMonster.getMaxLife());
            imageView.setImageResource(R.drawable.robotti);
        }
    }
}