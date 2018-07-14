package com.trainings.Controller;

import com.trainings.Model.RandomizeModel;
import com.trainings.View.View;

import java.util.Scanner;

public class Controller {
    private RandomizeModel randomizeModel;
    private View view;


    private Scanner scanner = new Scanner(System.in);

    public Controller(RandomizeModel randomizeModel, View view) {
        this.randomizeModel = randomizeModel;
        this.view = view;
    }

    /**
     * used to generate from 0 to 100 range
     */
    public void initDefaultRangeGame() {
        randomizeModel.generateRange();
        startGame();
    }

    /**
     * used to generate user chosen range
     */
    public void initCustomRangeGame() {
        int min;
        int max;
        do {
            view.printMessage(View.ENTER_RANGE);
            min = getNewNumber();
            max = getNewNumber();
        }

        while (!randomizeModel.generateRange(min, max));
        startGame();
    }

    private void startGame() {

        do {
            view.printMessage(String.format(View.GREETINGS_MESSAGE, randomizeModel.getCurrentMin(),
                    randomizeModel.getCurrentMax()));
        }
        while (!randomizeModel.guessAttempt(getNewNumber()));

        view.printMessage(View.CONGRATS_STATISTIC + randomizeModel.getUserAttemptStatistics());
    }


    /**
     * Scan for new input from user
     * if it is a number parse it
     *
     * @return users input as integer value
     */
    private int getNewNumber() {
        String scanned = scanner.nextLine();
        while (!checkInt(scanned)) {
            view.printMessage(View.INPUT_NUMBER_MESSAGE);
            scanned = scanner.nextLine();
        }
        return Integer.parseInt(scanned);
    }

    public boolean checkInt(String scanned) {
        try {
            int check = Integer.parseInt(scanned);
            return (check > Integer.MIN_VALUE && check < Integer.MAX_VALUE);
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
