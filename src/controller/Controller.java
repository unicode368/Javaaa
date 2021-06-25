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
        view.printMessage(view.INPUT_INVITATION_HELLO);
        input.writeUserInput();
        while (!validate(input.getUserInput())) {
            view.printError(view.HELLO_ERROR);
            input.writeUserInput();
        }
        builder.setSentence(input.getUserInput());
        view.printMessage(view.INPUT_INVITATION_WORLD);
        input.writeUserInput();
        while (!validate(input.getUserInput())) {
            view.printError(view.WORLD_ERROR);
            input.writeUserInput();
        }
        builder.setSentence(input.getUserInput());
        view.printMessage(view.RESULT_STRING);
        view.printMessage();
    }

    private boolean validate(String input) {
        if (builder.getSentence() == null) {
            return input.equals("Hello");
        } else {
            return input.equals("world!");
        }
    }
}
