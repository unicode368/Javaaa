package controller;

import model.Boundaries;
import model.Game;
import view.Input;
import view.ProgramView;

public class GameEngine {

    Game game;
    Input input;
    ProgramView view;

    public GameEngine() {
        game = new Game();
        input = new Input();
        view = new ProgramView();
    }

    public void start() {
        typeNumber();
        while (!game.checkNumber(Integer
                .parseInt(input.getUserInput()))
                .equals("equal")) {
            typeNumber();
        }
        view.printMessage(view.NUMBER_FOUND, input.getUserInput());

    }

    private void typeNumber() {
        view.printMessage(view.OPTION_INPUT,
                String.valueOf(game.getMinValue()),
                String.valueOf(game.getMaxValue()));
        input.writeUserInput();
        retypeInput();
    }

    private String validate(String input) {
        if (!isNumeric(input)) {
            return view.STRING_INPUT;
        } else if (Integer.parseInt(input) == Boundaries.MIN_VALUE ||
                    Integer.parseInt(input) == Boundaries.MAX_VALUE ||
                    Integer.parseInt(input) < game.getMinValue() ||
                    Integer.parseInt(input) > game.getMaxValue()){
            return view.INPUT_OUT_OF_RANGE;
        } else {
            return "";
        }
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    private void retypeInput() {
        String validatorVal = validate(input.getUserInput());
        while (true) {
            if (validatorVal.equals("")) {
                break;
            } else {
                if (validatorVal.equals(view.INPUT_OUT_OF_RANGE)) {
                    view.printError(validatorVal,
                            String.valueOf(game.getMinValue()),
                            String.valueOf(game.getMaxValue()));
                } else {
                    view.printError(validatorVal);
                }
                input.writeUserInput();
            }
        }
    }

}
