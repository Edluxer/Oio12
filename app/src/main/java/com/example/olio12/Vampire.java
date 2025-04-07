package com.example.olio12;
import java.util.Random;
public class Vampire extends Monster {

    private String[] names = {"Vamp", "Jones", "Bats", "Bloody Boy", "Mr Sucky"};

    public Vampire() {
        super(new Random().nextInt(21) + 40, "Vampire");
        this.name = names[new Random().nextInt(names.length)];
        this.image = R.drawable.bat;
    }
}