package controller;

import model.SentenceBuilder;
import view.Input;
import view.ProgramView;

public class Controller {

    private ProgramView view;
    private SentenceBuilder builder;
    private Input input;

    public Controller() {
        view = new ProgramView();
        builder = new SentenceBuilder(null);
        input = new Input();
    }

    public void start() {
        view.print_message(view.INPUT_INVITATION);
        input.writeUserInput();
        validate(input.getUserInput());
    }

    public boolean validate(String input) {

    }
}
