package com.example.olio12;
import java.util.Random;

public class Skeleton extends Monster {
    private String[] names = {"Sans", "Papaiarus", "Bone", "Jack", "Boner"};

    public Skeleton() {
        super(new Random().nextInt(21) + 30, "Skeleton");
        this.name = names[new Random().nextInt(names.length)];
        this.image = R.drawable.skull;
    }

}