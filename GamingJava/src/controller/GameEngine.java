package controller;

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
        view.printMessage(view.OPTION_INPUT,
                String.valueOf(game.getMinValue()),
                String.valueOf(game.getMaxValue()));
        input.writeUserInput();
        retypeInput();
    }

    private String validate(String input) {
        if (!isNumeric(input)) {
            return view.STRING_INPUT;
        } else if (Integer.parseInt(input) < game.getMinValue()
                || Integer.parseInt(input) > game.getMaxValue()){
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
