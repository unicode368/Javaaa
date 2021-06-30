package model;

import java.util.Random;

public class Game {

    private int minValue;
    private int maxValue;
    private int randomNumber;
    private int[] statistics;

    public Game() {
        randomNumber = 1 + new Random().nextInt(100);
        statistics = new int[0];
        minValue = Boundaries.MIN_VALUE;
        maxValue = Boundaries.MAX_VALUE;
    }

    public String checkNumber(int number) {
        if (number == randomNumber) {
            return "equal";
        } else if (number < randomNumber) {
            setMinValue(number);
            appendToStatistics(number);
            return "more";
        } else {
            setMaxValue(number);
            appendToStatistics(number);
            return "less";
        }
    }

    public int getMaxValue() {
        return maxValue;
    }

    private void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public int getMinValue() {
        return minValue;
    }

    private void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public int[] getStatistics() {
        return statistics;
    }

    private void appendToStatistics(int stat) {
        int[] newStat = new int[statistics.length + 1];
        for (int i = 0; i < statistics.length; i++) {
            newStat[i] = statistics[i];
        }
        newStat[statistics.length] = stat;
        this.statistics = newStat;
    }


}
