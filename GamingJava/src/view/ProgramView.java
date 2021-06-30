package view;

public class ProgramView {

    public final String OPTION_INPUT = "Будь ласка, введіть число від %s до %s:";
    public final String STRING_INPUT = "Введене значення має бути числом.";
    public final String INPUT_OUT_OF_RANGE = "Число має бути в діапазоні від %s до %s.";
    public final String NUMBER_LESS = "Шукане число менше за %s";
    public final String NUMBER_BIGGER = "Шукане число більше за %s";
    public final String NUMBER_FOUND = "Знайдено шукане число - %s!" + "\nСтатистика по грі:\n";

    public void printMessage(String message,
                                String min, String max) {
        System.out.format(message, min, max);
    }

    public void printMessage(String message, String number) {
        System.out.format(message, number);
    }

    public void printError(String message) {
        System.err.println(message);
    }

    public void printError(String message, String min, String max) {
        System.err.format(message, min, max);
    }

}
