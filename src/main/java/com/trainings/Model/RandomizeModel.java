package com.trainings.Model;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class RandomizeModel {
    public static final int RAND_START = 0;
    public static final int RAND_END = 100;
    private int currentMin;
    private int currentMax;
    private int winCondition;
    private ArrayList<UsersAttempts> usersAttempts = new ArrayList<>();

    public void generateWinCondition(int min, int max) {
        this.currentMin = min;
        this.currentMax = max;
        this.winCondition = ThreadLocalRandom.current().nextInt((min + 1), max);
        System.out.println(winCondition);
    }

    public int getWinCondition() {
        return winCondition;
    }

    public boolean guessAttempt(int attempt) {
        if (checkRange(attempt)) {
            addAttemptStatistics(attempt);
            return winCheck(attempt);
        } else {
            System.out.println("OOR");
            return false;
        }


    }

    private void addAttemptStatistics(int attempt) {
        UsersAttempts userAttempt = new UsersAttempts();
        userAttempt.setValue(attempt);
        usersAttempts.add(userAttempt);
    }

    private boolean winCheck(int attempt) {
        if (attempt == winCondition) {
            //userAttempt.setAttemptResult(UsersAttempts.RESULT_WIN);
            System.out.println("win");
            return true;
        } else {
            changeBorders(attempt);
            System.out.println("loose");
            return false;
        }
    }

    private void changeBorders(int attempt) {
        if (attempt < winCondition) {
            // usersAttempts.setAttemptResult(UsersAttempts.RESULT_LESS);
            currentMin = attempt;
        } else {
            // usersAttempts.setAttemptResult(UsersAttempts.RESULT_MORE);
            currentMax = attempt;
        }
    }

    private boolean checkRange(int attempt) {
        if (attempt > currentMin && attempt < currentMax) {
            return true;
        } else {
            return false;
        }

    }

    public int getCurrentMin() {
        return currentMin;
    }

    public int getCurrentMax() {
        return currentMax;
    }
}
