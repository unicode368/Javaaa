package controller;

import model.ContactBook;
import model.contact.Contact;
import model.RegexPatterns;
import model.exceptions.InvalidLoginException;
import view.Input;
import view.ProgramView;

import java.util.ArrayList;

public class Controller {
    private Input input;
    private ProgramView view;
    private ContactBook model;

    public Controller() {
        input = new Input();
        view = new ProgramView();
        model = new ContactBook();
    }

    public void start() {
        String[][] allContactFields;
        int nicknamePosition = 0;
        int commentPosition = 1;
        int groupPosition = 2;
        int i = 0;

        chooseLanguage();
        while (i != 2) {
            allContactFields = getAllContactFields();
            while (true) {
                try {
                    model.addNewContact(allContactFields[3][nicknamePosition],
                            allContactFields[3][commentPosition],
                            allContactFields[0],
                            allContactFields[1],
                            allContactFields[2],
                            allContactFields[3][groupPosition]);
                } catch (InvalidLoginException nicknameInvalid) {
                    view.printError(nicknameInvalid.getMessage());
                    allContactFields[3][nicknamePosition] =
                            takeInput("input.nickname.data");
                    continue;
                }
                break;
            }
            view.printAllResults("output.result.data",
                    model.getAllContacts());
            i++;
        }
    }

    private String[][] getAllContactFields() {
        String[] fullName = new String[3];
        String[] contacts = new String[5];
        String[] address = new String[5];
        String nickname;
        String comment;
        String group;

        fullName[0] = takeInput("input.name.data");
        fullName[1] = takeInput("input.surname.data");
        fullName[2] = takeInput("input.patronimic.data");
        nickname = takeInput("input.nickname.data");
        comment = takeInput("input.comment.data");
        group = takeInput("input.group.data");
        contacts[0] = takeInput("input.home.phone.data");
        contacts[1] = takeInput("input.mobile.phone.data");
        contacts[2] = takeInput("input.mobile.phone.2.data");
        contacts[3] = takeInput("input.email.data");
        contacts[4] = takeInput("input.skype.data");
        address[0] = takeInput("input.index.data");
        address[1] = takeInput("input.city.data");
        address[2] = takeInput("input.street.data");
        address[3] = takeInput("input.house.number.data");
        address[4] = takeInput("input.flat.number.data");

        return new String[][]{fullName, contacts, address,
                    new String[]{nickname, comment, group}};
    }

    private void chooseLanguage() {
        String option = takeInput("input.language");

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
            case "input.street.data": {
                return input.matches(String.valueOf(ProgramView
                        .bundle.getLocale()).equals("ua") ?
                        RegexPatterns.NAME_REGEX_UA
                        : RegexPatterns.NAME_REGEX);
            }
            case "input.group.data":
                return input.matches(RegexPatterns.GROUP_REGEX);
            case "input.home.phone.data":
                return input.matches(RegexPatterns.HOME_PHONE_REGEX);
            case "input.mobile.phone.data":
                return input.matches(RegexPatterns.MOBILE_PHONE_REGEX);
            case "input.mobile.phone.2.data":
                return input.matches(RegexPatterns.MOBILE_PHONE_REGEX)
                        || input.equals("");
            case "input.email.data":
                return input.matches(RegexPatterns.EMAIL_REGEX);
            case "input.nickname.data":
                return input.matches(RegexPatterns.NICKNAME_REGEX);
            case "input.skype.data":
                return input.matches(RegexPatterns.NICKNAME_REGEX)
                        || input.equals("");
            case "input.index.data":
                return input.matches(RegexPatterns.INDEX_REGEX);
            case "input.house.number.data":
                return input.matches(String.valueOf(ProgramView
                        .bundle.getLocale()).equals("ua") ?
                        RegexPatterns.HOUSE_NUMBER_REGEX_UA
                        : RegexPatterns.HOUSE_NUMBER_REGEX);
            case "input.flat.number.data":
                return input.matches(RegexPatterns.FLAT_NUMBER_REGEX);
            case "input.language":
                return input.matches(RegexPatterns.LANG_REGEX);
            default: return true;
        }
    }

}
