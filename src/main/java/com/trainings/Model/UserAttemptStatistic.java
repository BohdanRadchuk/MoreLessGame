package com.trainings.Model;

public class UserAttemptStatistic {
    private int value;

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "{" + value + "}";
    }
}
