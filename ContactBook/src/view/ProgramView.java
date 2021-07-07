package view;

import java.util.Locale;
import java.util.ResourceBundle;

public class ProgramView {

    private static String MESSAGE_BUNDLE_NAME = "properties";
    public static final ResourceBundle bundle =
            ResourceBundle.getBundle(
                    MESSAGE_BUNDLE_NAME,
                    new Locale("ua", "UA"));

    public final String UNNECESSARY_INPUT = "Введіть %s (не обов'язково):";

    public final String WRONG_INPUT = "Некорректне введено %s. Будь ласка, спробуйте ще.\n";
    public final String WRONG_GROUP = "Будь ласка, оберіть групу зі списку наявних.";

    public void printMessage(String message) {
        System.out.println(bundle.getString(message));
    }

    public void printError(String message, String option) {
        System.err.format(message, option);
    }

    public void printError(String message) {
        System.err.println(message);
    }
}
