package model.contact;

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

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronimic() {
        return patronimic;
    }

    public String getInitials() {
        return initials;
    }

    public String[] getFullName() {
        return new String[]{name,
                surname,
                patronimic,
                initials};
    }
}
