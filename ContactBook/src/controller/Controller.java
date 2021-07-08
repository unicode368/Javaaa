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
        chooseLanguage("input.language");
        String[] fullName = new String[3];
        fullName[0] = takeInput("input.name.data");
        fullName[1] = takeInput("input.surname.data");
        fullName[2] = takeInput("input.patronimic.data");
        String nickname = takeInput("input.nickname.data");
        String comment = takeInput("input.comment.data");
        int group = Integer.parseInt(takeInput("input.group.data"));
        model = new Contact(nickname, comment);
        model.defineFullName(fullName[0], fullName[1], fullName[2]);
        model.defineGroup(group);
        String[] contacts = new String[5];
        contacts[0] = takeInput("input.home.phone.data");
        contacts[1] = takeInput("input.mobile.phone.data");
        contacts[2] = takeInput("input.mobile.phone.2.data");
        contacts[3] = takeInput("input.email.data");
        contacts[4] = takeInput("input.skype.data");
        model.defineContacts(contacts[0], contacts[1], contacts[2],
                contacts[3], contacts[4]);
        String[] address = new String[5];
        address[0] = takeInput("input.index.data");
        address[1] = takeInput("input.city.data");
        address[2] = takeInput("input.street.data");
        address[3] = takeInput("input.house.number.data");
        address[4] = takeInput("input.flat.number.data");
        model.defineAddress(Integer.parseInt(address[0]), address[1] , address[2],
                Integer.parseInt(address[3]), Integer.parseInt(address[4]));
        view.printResult("output.result.data", model.getAllInfo());
    }

    private void chooseLanguage(String lang) {
        String option = takeInput(lang);
        if (option.equals("2")) {
            view.changeDefaultLanguage("en", "EN");
        }
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
            case "input.name.data":
            case "input.surname.data":
            case "input.patronimic.data":
            case "input.city.data":
            case "input.street.data":    {
                return input.matches(String.valueOf(ProgramView
                        .bundle.getLocale()).equals("ua") ? RegexPatterns.NAME_REGEX_UA
                        : RegexPatterns.NAME_REGEX);
            }
            case "input.group.data":
                return input.matches(RegexPatterns.GROUP_REGEX);
            case "input.home.phone.data":
                return input.matches(RegexPatterns.HOME_PHONE_REGEX);
            case "input.mobile.phone.data":
            case "input.mobile.phone.2.data": {
                return input.matches(RegexPatterns.MOBILE_PHONE_REGEX);
            }
            case "input.email.data":
                return input.matches(RegexPatterns.EMAIL_REGEX);
            case "input.nickname.data":
            case "input.skype.data": {
                return input.matches(RegexPatterns.NICKNAME_REGEX);
            }
            case "input.index.data":
                return input.matches(RegexPatterns.INDEX_REGEX);
            case "input.house.number.data":
                return input.matches(RegexPatterns.HOUSE_NUMBER_REGEX);
            case "input.language":
                return input.matches(RegexPatterns.LANG_REGEX);
            default: return true;
        }
    }

}
