package com.trainings.Model;

public class UsersAttempts {
    public static final String RESULT_WIN = "Congratulations you WIN";
    public static final String RESULT_LESS = "Less than condition";
    public static final String RESULT_MORE = "More than condition";

    private int value;
    private String attemptResult;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getAttemptResult() {
        return attemptResult;
    }

    public void setAttemptResult(String attemptResult) {
        this.attemptResult = attemptResult;
    }
}
