package model;

public class FullName {

    private String name;
    private String surname;
    private String patronimic;
    private String initials;

    FullName(String name, String surname, String patronimic) {
        this.name = name;
        this.surname = surname;
        this.patronimic = patronimic;
        this.initials = createInitials();
    }

    private String createInitials() {
        if (surname.equals("") || name.equals("")) {
            return "";
        }
        return surname + " " + name.toCharArray()[0] + ".";
    }
}
