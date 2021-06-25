package view;

import java.util.Scanner;

public class Input {

    private Scanner scanner;
    private String userInput;

    public Input() {
        scanner = new Scanner(System.in);
    }

    public void writeUserInput() {
        String input = scanner.nextLine();
        setUserInput(input);
    }

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }
}
