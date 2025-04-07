package com.example.olio12;

import java.util.Random;

public class GameManager {
    private static GameManager instance;
    private Player player;
    private Monster latestMonster;

    private GameManager() {
        player = new Player();
    }

    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public Player getPlayer() {
        return player;
    }

    public Monster generateMonster() {
        Random random = new Random();
        if (random.nextBoolean()) {
            latestMonster = new Skeleton();
        } else {
            latestMonster = new Vampire();
        }
        return latestMonster;
    }

    public Monster getLatestMonster() {
        return latestMonster;
    }
    public void setLatestMonster(Monster monster) {
        this.latestMonster = monster;
    }
}
