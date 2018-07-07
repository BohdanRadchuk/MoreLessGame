package com.trainings.Model;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class RandomizeModel {
    public static final int RAND_START = 0;
    public static final int RAND_END = 100;
    private int min;
    private int max;
    private int winCondition;
    private ArrayList<UsersAttempts> usersAttempts;

    public void generateWinCondition(int min, int max) {
        winCondition = ThreadLocalRandom.current().nextInt((min+1), max);
    }

    public int getWinCondition() {
        return winCondition;
    }

    public void setWinCondition(int winCondition) {
        this.winCondition = winCondition;
    }
}
