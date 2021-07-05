package controller;

import view.Input;
import view.ProgramView;

public class Controller {

    private Input input;
    private ProgramView view;

    public Controller() {
        input = new Input();
        view = new ProgramView();
    }

    public void start() {
        String name = takeInput(view.NAME_INPUT, "ім'я");
        String surname = takeInput(view.SURNAME_INPUT, "прізвище");
        String patronimic = takeInput(view.PATRONIMIC_INPUT, "по-батькові");
        String nickname = takeInput(view.NICKNAME_INPUT, "прізвище");
    }

    public String takeInput(String message, String type) {
        view.printMessage(message);
        input.writeUserInput();
        while (!validate(input.getUserInput())) {
            printByType(type);
            input.writeUserInput();
        }
        return input.getUserInput();
    }

    public void printByType(String type) {
    private void printMessageByType(String message, String type) {
        if (type.equals("коментар") || type.equals("група")) {
            view.printMessage(message);
        } else {
            view.printMessage(message, type);
        }
    }
        if (type.equals("група")) {
            view.printError(view.WRONG_GROUP);
        } else {
            view.printError(view.WRONG_INPUT, type);
        }
    }

    public boolean validate(String input) {
        return false;
    }

}
