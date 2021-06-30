package controller;

import model.Game;
import view.Input;
import view.ProgramView;

public class GameEngine {

    Game game;
    Input input;
    ProgramView programView;

    public GameEngine() {
        game = new Game();
        input = new Input();
        programView = new ProgramView();
    }

    public void start() {

    }

}
