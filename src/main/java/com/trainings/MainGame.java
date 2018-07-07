package com.trainings;

import com.trainings.Controller.Controller;
import com.trainings.Model.RandomizeModel;
import com.trainings.View.View;

public class MainGame {
    public static void main(String[] args) {
        RandomizeModel randomizeModel = new RandomizeModel();
        View view = new View();
        Controller controller = new Controller(randomizeModel, view);
        controller.startGame();
    }
}
