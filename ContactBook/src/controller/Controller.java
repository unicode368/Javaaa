package controller;

import model.Contact;
import model.RegexPatterns;
import view.Input;
import view.ProgramView;

public class Controller {

    private Input input;
    private ProgramView view;
    private Contact model;
    private RegexPatterns patterns;

    public Controller() {
        input = new Input();
        view = new ProgramView();
        patterns = new RegexPatterns();
    }

    public void start() {
        String[] fullName = new String[3];
        fullName[0] = takeInput(view.NECESSARY_INPUT, "ім'я");
        fullName[1] = takeInput(view.NECESSARY_INPUT, "прізвище");
        fullName[2] = takeInput(view.NECESSARY_INPUT, "по-батькові");
        String nickname = takeInput(view.NECESSARY_INPUT, "нікнейм");
        String comment = takeInput(view.COMMENT_INPUT, "коментар");
        int group = Integer.parseInt(takeInput(view.GROUP_INPUT, "група"));
        model = new Contact(nickname, comment);
        model.defineFullName(fullName[0], fullName[1], fullName[2]);
        model.defineGroup(group);
        String[] contacts = new String[5];
        contacts[0] = takeInput(view.NECESSARY_INPUT, "домашній телефон");
        contacts[1] = takeInput(view.NECESSARY_INPUT, "мобільний телефон");
        contacts[2] = takeInput(view.UNNECESSARY_INPUT, "додатковий мобільний телефон");
        contacts[3] = takeInput(view.NECESSARY_INPUT, "e-mail");
        contacts[4] = takeInput(view.UNNECESSARY_INPUT, "skype");
        model.defineContacts(contacts[0], contacts[1], contacts[2],
                contacts[3], contacts[4]);
        String[] address = new String[5];
        address[0] = takeInput(view.NECESSARY_INPUT, "домашній телефон");
        address[1] = takeInput(view.NECESSARY_INPUT, "мобільний телефон");
        address[2] = takeInput(view.NECESSARY_INPUT, "додатковий мобільний телефон");
        address[3] = takeInput(view.NECESSARY_INPUT, "e-mail");
        address[4] = takeInput(view.NECESSARY_INPUT, "skype");
        model.defineAddress(Integer.parseInt(address[0]), address[1] , address[2],
                Integer.parseInt(address[3]), Integer.parseInt(address[4]));
    }

    public String takeInput(String message, String type) {
        printMessageByType(message, type);
        input.writeUserInput();
        while (!validate(input.getUserInput(), type)) {
            printErrorByType(type);
            input.writeUserInput();
        }
        return input.getUserInput();
    }

    private void printMessageByType(String message, String type) {
        if (type.equals("коментар") || type.equals("група")) {
            view.printMessage(message);
        } else {
            view.printMessage(message, type);
        }
    }

    private void printErrorByType(String type) {
        if (type.equals("група")) {
            view.printError(view.WRONG_GROUP);
        } else {
            view.printError(view.WRONG_INPUT, type);
        }
    }

    private boolean validate(String input, String type) {
        switch (type) {
            case "ім'я":
            case "прізвище":
            case "по-батькові": {
                return input.matches(patterns.NAME_REGEX);
            }
            default: return true;
        }
    }

}
