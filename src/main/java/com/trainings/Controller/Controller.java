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
        checkInt(scanner);
        int s = scanner.nextInt();
        System.out.println(s);
    }

    public boolean checkInt(Scanner sc) {
        if (sc.hasNextInt()) {
            return true;
        }
        return false;
    }
}
