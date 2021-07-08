package controller;

import model.Contact;
import model.RegexPatterns;
import view.Input;
import view.ProgramView;

public class Controller {

    private Input input;
    private ProgramView view;
    private Contact model;

    public Controller() {
        input = new Input();
        view = new ProgramView();
    }

    public void start() {
        String[] fullName = new String[3];
        fullName[0] = takeInput("input.name");
        fullName[1] = takeInput("input.surname");
        fullName[2] = takeInput("input.patronimic");
        String nickname = takeInput("input.nickname");
        String comment = takeInput("input.comment");
        int group = Integer.parseInt(takeInput("input.group"));
        model = new Contact(nickname, comment);
        model.defineFullName(fullName[0], fullName[1], fullName[2]);
        model.defineGroup(group);
        String[] contacts = new String[5];
        contacts[0] = takeInput("input.home.phone");
        contacts[1] = takeInput("input.mobile.phone");
        contacts[2] = takeInput("input.mobile.phone.2");
        contacts[3] = takeInput("input.email");
        contacts[4] = takeInput("input.skype");
        model.defineContacts(contacts[0], contacts[1], contacts[2],
                contacts[3], contacts[4]);
        String[] address = new String[5];
        address[0] = takeInput("input.index");
        address[1] = takeInput("input.city");
        address[2] = takeInput("input.street");
        address[3] = takeInput("input.house.number");
        address[4] = takeInput("input.flat.number");
        model.defineAddress(Integer.parseInt(address[0]), address[1] , address[2],
                Integer.parseInt(address[3]), Integer.parseInt(address[4]));
        view.printResult("output.result", model.getAllInfo());
    }

    public String takeInput(String message) {
        view.printMessage(message);
        input.writeUserInput();
        while (!validate(input.getUserInput(), message)) {
            view.printError(message + ".error");
            input.writeUserInput();
        }
        return input.getUserInput();
    }


    private boolean validate(String input, String type) {
        switch (type) {
            case "input.name":
            case "input.surname":
            case "input.patronimic": {
                return input.matches(RegexPatterns.NAME_REGEX);
            }
            case "input.nickname":
            case "input.skype": {
                return input.matches(RegexPatterns.NICKNAME_REGEX);
            }
            default: return true;
        }
    }

}
