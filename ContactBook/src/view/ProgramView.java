package view;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class ProgramView {

    private static String MESSAGE_BUNDLE_NAME = "messages";
    public static ResourceBundle bundle =
            ResourceBundle.getBundle(
                    MESSAGE_BUNDLE_NAME,
                    new Locale("ua", "UA"));

    public void printMessage(String message) {
        System.out.println(bundle.getString(message));
    }

    public void printResult(String message, String... args) {
        System.out.println(MessageFormat.format(bundle.getString(message), args));
    }

    public void printError(String message) {
        System.err.println(bundle.getString(message));
    }

    public void changeDefaultLanguage(String lang, String country) {
        bundle = ResourceBundle.getBundle(
                MESSAGE_BUNDLE_NAME,
                new Locale(lang, country));
    }
}
