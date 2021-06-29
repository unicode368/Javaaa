package model;

import java.util.Random;

public class Game {

    private int randomNumber;
    private int[] statistics;

    public Game() {
        randomNumber = new Random().nextInt(101);
        statistics = new int[0];
    }



}
