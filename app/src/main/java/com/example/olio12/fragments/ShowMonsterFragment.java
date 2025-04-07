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

public class ShowMonsterFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_show_monster, container, false);

        TextView MonsterNameText = view.findViewById(R.id.MonsterNameText);
        TextView MonsterLifeText = view.findViewById(R.id.MonsterLifeText);
        ImageView MonsterImage = view.findViewById(R.id.MonsterImage);
        Button AttackMonsterButton = view.findViewById(R.id.AttackMonsterButton);

        updateMonsterView(MonsterNameText, MonsterLifeText, MonsterImage);


        AttackMonsterButton.setOnClickListener(v -> {
            GameManager.getInstance().getPlayer().attack(GameManager.getInstance().getLatestMonster());

            if (GameManager.getInstance().getLatestMonster().getLife() <= 0) {
                GameManager.getInstance().generateMonster();
            }
            updateMonsterView(MonsterNameText, MonsterLifeText, MonsterImage);
        });

        return view;
    }

    private void updateMonsterView(TextView nameView, TextView lifeView, ImageView imageView) {
        Monster currentMonster = GameManager.getInstance().getLatestMonster();
        if (currentMonster != null) {
            nameView.setText(currentMonster.getName());
            lifeView.setText(currentMonster.getLife() + " / " + currentMonster.getMaxLife());
            imageView.setImageResource(currentMonster.getImage());
        }
    }

}