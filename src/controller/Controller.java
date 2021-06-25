package controller;

import model.SentenceBuilder;
import view.Input;
import view.ProgramView;

public class Controller {

    private ProgramView view;
    private SentenceBuilder builder;
    private Input input;

    public Controller() {
        this.view = new ProgramView();
        this.builder = new SentenceBuilder();
        this.input = new Input();
    }

    public void start() {
        view.print_message(view.INPUT_INVITATION);
    }

    public boolean validate() {

    }
}
