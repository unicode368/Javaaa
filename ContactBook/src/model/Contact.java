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

    public Contact(FullName fullName, String nickname, String comment,
                   Group group, Contacts contacts, Address address) {
        this.fullName = fullName;
        this.nickname = nickname;
        this.comment = comment;
        this.group = group;
        this.contacts = contacts;
        this.address = address;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDateTime now = LocalDateTime.now();
        this.dateCreated = dtf.format(now);
        this.dateModified = dateCreated;
    }
}
