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

    public void startGame() {
        randomizeModel.generateWinCondition(RandomizeModel.RAND_START, RandomizeModel.RAND_END);
        usersInteractions(randomizeModel.getCurrentMin(), randomizeModel.getCurrentMax());

    }

    private void usersInteractions(int min, int max) {
        view.printMessage(String.format(View.GREETINGS_MESSAGE, min, max));
        String scanned = scanner.next();
        if (checkInt(scanned)) {
            int attempt = Integer.parseInt(scanned);

            while (!randomizeModel.guessAttempt(attempt)) {

                usersInteractions(randomizeModel.getCurrentMin(), randomizeModel.getCurrentMax());
            }
            System.out.println("hurey");
            System.out.println(scanned);

        } else {
            view.printMessage(View.INPUT_NUMBER_MESSAGE);
            usersInteractions(min, max);
        }
        System.out.println("end");

    }

    public boolean checkInt(String scanned) {
        try {
            Integer.parseInt(scanned);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
