package view;

public class ProgramView {

    public final String NECESSARY_INPUT = "Введіть %s:\n";
    public final String COMMENT_INPUT = "Залиште коментар щодо контакту:";
    public final String GROUP_INPUT = "Оберіть групу, до якої відноситься контакт:\n" +
                                        "1. Сім'я.\n" +
                                        "2. Робота.\n" +
                                        "3. Друзі.\n";
    public final String UNNECESSARY_INPUT = "Введіть %s (не обов'язково):";

    public final String WRONG_INPUT = "Некорректне введено %s. Будь ласка, спробуйте ще.\n";
    public final String WRONG_GROUP = "Будь ласка, оберіть групу зі списку наявних.";

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printMessage(String message, String type) {
        System.out.format(message, type);
    }

    public void printError(String message, String option) {
        System.err.format(message, option);
    }

    public void printError(String message) {
        System.err.println(message);
    }
}
