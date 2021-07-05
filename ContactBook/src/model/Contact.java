package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Contact {

    private FullName fullName;
    private String nickname;
    private String comment;
    private Group group;
    private Contacts contacts;
    private Address address;
    private String dateCreated;
    private String dateModified;
    private final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private final LocalDateTime NOW = LocalDateTime.now();

    public Contact(String nickname, String comment,
                   Group group, Contacts contacts) {
        this.fullName = new FullName("", "", "");
        this.nickname = nickname;
        this.comment = comment;
        this.group = group;
        this.contacts = contacts;
        this.address = new Address(0, "", "", 0, 0);
        this.dateCreated = DTF.format(NOW);
        this.dateModified = dateCreated;
    }

    public Contact(FullName fullName, String nickname, String comment,
                   Group group, Contacts contacts, Address address) {
        this.fullName = fullName;
        this.nickname = nickname;
        this.comment = comment;
        this.group = group;
        this.contacts = contacts;
        this.address = address;
        this.dateCreated = DTF.format(NOW);
        this.dateModified = dateCreated;
    }

    public Contacts createContacts(String homePhone,
                                   String mobilePhone,
                                   String mobilePhone2,
                                   String email,
                                   String skype) {
        return new Contacts(homePhone, mobilePhone, mobilePhone2, email, skype);
    }
}
