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
        view.print_message(view.INPUT_INVITATION_HELLO);
        input.writeUserInput();
        while (!validate(input.getUserInput())) {
            view.print_error(view.HELLO_ERROR);
            input.writeUserInput();
        }
    }

    private boolean validate(String input) {
        if (builder.getSentence().getWords() == null) {
            return input.equals("Hello");
        } else {
            return input.equals("world!");
        }
    }
}
