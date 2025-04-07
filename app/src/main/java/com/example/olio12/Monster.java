package com.example.olio12;

public abstract class Monster {
    String name;
    private int life;
    private int maxLife;
    protected int image;
    public Monster(int maxLife, String name) {
        this.maxLife = maxLife;
        this.life = maxLife;
        this.name = name;
    }

    public void takeDamage(int amount) {
        life -= amount;
        if (life < 0)
            life = 0;
    }
    public int getLife() {
        return life;
    }
    public String getName() {
        return name;
    }
    public int getMaxLife() {
        return maxLife;
    }
    public int getImage() {
        return image;
    }
}