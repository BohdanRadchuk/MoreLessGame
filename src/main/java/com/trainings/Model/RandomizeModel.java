package com.trainings.Model;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class RandomizeModel {
    public static final int RAND_START = 0;
    public static final int RAND_END = 100;
    private int currentMin;
    private int currentMax;
    private int winCondition;
    private ArrayList<UserAttemptStatistic> userAttemptStatistics = new ArrayList<>();

    public void generateRange() {
        generateWinCondition(RAND_START, RAND_END);
    }

    public boolean generateRange(int min, int max) {
        boolean checkResult = checkRange(min, max);
        if (checkResult) {
            generateWinCondition(min, max);
        }
        return checkResult;
    }

    private void generateWinCondition(int min, int max) {
        this.currentMin = min;
        this.currentMax = max;
        //minimal border had to be increased by one to not include minimum value to randomize range
        this.winCondition = ThreadLocalRandom.current().nextInt((min + 1), max);
    }

    public boolean guessAttempt(int attempt) {
        if (checkValueRange(attempt)) {
            addAttemptStatistics(attempt);
            return winCheck(attempt);
        } else {
            return false;
        }
    }

    private void addAttemptStatistics(int attempt) {
        UserAttemptStatistic userAttemptStatistic = new UserAttemptStatistic();
        userAttemptStatistic.setValue(attempt);
        userAttemptStatistics.add(userAttemptStatistic);
    }

    private boolean winCheck(int attempt) {
        if (attempt == winCondition) {
            return true;
        } else {
            changeBorders(attempt);
            return false;
        }
    }

    private void changeBorders(int attempt) {
        if (attempt < winCondition) {
            currentMin = attempt;
        } else {
            currentMax = attempt;
        }
    }

    private boolean checkRange(int min, int max) {
        return (max - min) > 1 ;
    }

    private boolean checkValueRange(int attempt) {
        return attempt > currentMin && attempt < currentMax;
    }

    /**
     * used only for tests
     * @return actual winCondition
    */
    public int getWinCondition() {
        return winCondition;
    }

    public int getCurrentMin() {
        return currentMin;
    }

    public int getCurrentMax() {
        return currentMax;
    }

    public String getUserAttemptStatistics() {
        return userAttemptStatistics.toString();
    }
}
