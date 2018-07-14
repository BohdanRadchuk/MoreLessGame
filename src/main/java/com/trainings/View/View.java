package com.trainings.View;

public class View {
    public static final String GREETINGS_MESSAGE = "Choose a number in (%d , %d) range";
    public static final String INPUT_NUMBER_MESSAGE = "You have entered not a number. Please try again.";
    public static final String CONGRATS_STATISTIC = "Congratulations you won!! Your tries : ";
    public static final String ENTER_RANGE = "Enter range where random value would be generated. Tip:" +
            " your values is not included to the generation range and max-min > 1";

    public void printMessage (String message) {
        System.out.println(message);
    }
}
