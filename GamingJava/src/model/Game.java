package model;

import java.util.Random;

public class Game {

    private int minValue;
    private int maxValue;
    private int randomNumber;
    private int[] statistics;

    public Game() {
        randomNumber = new Random().nextInt(101);
        statistics = new int[0];
        minValue = Boundaries.MIN_VALUE;
        maxValue = Boundaries.MAX_VALUE;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public void appendToStatistics(int stat) {
        int[] newStat = new int[statistics.length + 1];
        for (int i = 0; i < statistics.length; i++) {
            newStat[i] = statistics[i];
        }
        newStat[statistics.length] = stat;
        this.statistics = newStat;
    }

}
