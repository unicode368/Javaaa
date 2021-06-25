package view;

public class ProgramView {

    public final String INPUT_INVITATION_HELLO = "Введіть \'Hello\':";
    public final String INPUT_INVITATION_WORLD = "Введіть \'world!\':";
    public final String HELLO_ERROR = "Будь ласка, введіть \'Hello\'.";
    public final String WORLD_ERROR = "Будь ласка, введіть \'world!\'.";
    public final String RESULT_STRING = "Утворене речення:";

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printError(String message) {
        System.err.println(message);
    }

    public void print(String text) {
        System.out.println(text);
    }
}
